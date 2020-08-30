package com.jy.lang;

import com.jy.SyntaxException;
import com.jy.lang.statement.Default;
import com.jy.util.NameUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Appendable statement
 *
 * @author zhy
 */
public abstract class BaseAppendableStatement extends AbstractStatement implements ChildrenAppendable {

    private static final Map<Class<? extends BaseAppendableStatement>, Map<Class<?>, Field>>
            SUB_FIELD_MAP = new ConcurrentHashMap<>(32);
    private static final Map<Class<? extends BaseAppendableStatement>, Map<Class<?>, Field>>
            LIST_SUB_FIELD_MAP = new ConcurrentHashMap<>(32);

    /**
     * @param s required statement
     */
    protected final <T extends Statement> void required(T s, Class<T> clz) {
        if (s == null) {
            throw new SyntaxException("'%s' is required in '%s'",
                    NameUtil.java2Yang(clz), NameUtil.java2Yang(this.getClass()));
        }
    }

    /**
     * Assert the default value matches the type
     */
    protected final void assertDefault(com.jy.lang.statement.Type type, Default defaultVal) {
        if (defaultVal != null) {
            BuiltInType<?> builtInType = type.getArgumentJava();
            try {
                builtInType.fromArgument(defaultVal.getArgument());
            } catch (IllegalArgumentException | SyntaxException e) {
                throw new SyntaxException(e,
                        "The value of 'default' doest match this type: type=%s, default=%s",
                        argument, type.getArgument());
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void assertValid() throws SyntaxException {
        initSubFieldType();
        initSubListFieldType();
        Class<? extends BaseAppendableStatement> thisClz = this.getClass();
        SUB_FIELD_MAP.get(thisClz).forEach((c, f) -> {
            try {
                Statement child = (Statement) f.get(this);
                if (child != null) {
                    child.assertValid();
                }
            } catch (IllegalAccessException e) {
                // Never happen
                e.printStackTrace();
            }
        });
        LIST_SUB_FIELD_MAP.get(thisClz).forEach((c, f) -> {
            try {
                List<Statement> childList = (List<Statement>) f.get(this);
                if (childList != null) {
                    childList.forEach(Statement::assertValid);
                }
            } catch (IllegalAccessException e) {
                // Never happen
                e.printStackTrace();
            }
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Statement> void append(T s) throws SyntaxException, NullPointerException {
        notNull(s);
        Class<T> type = (Class<T>) s.getClass();
        Field field = getField(type);
        if (field != null) {
            // Single substatement
            Statement previous;
            try {
                previous = (Statement) field.get(this);
                // Assert not duplicate
                notDuplicate(previous);
                field.set(this, s);
            } catch (IllegalAccessException e) {
                // Never happen
                dealIllegalAccessException(e);
            }
        } else {
            field = getListField(type);
            if (field != null) {
                // Multiple substatement
                try {
                    Collection<T> previous = (Collection<T>) field.get(this);
                    if (previous == null) {
                        previous = new LinkedList<>();
                        field.set(this, previous);
                    }
                    previous.add(s);
                } catch (IllegalAccessException e) {
                    // Never happen
                    dealIllegalAccessException(e);
                }
            } else {
                throw new IllegalArgumentException("Can't append!");
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Statement> T get(Class<T> clz) {
        initSubFieldType();
        Map<Class<?>, Field> fieldMap = SUB_FIELD_MAP.get(this.getClass());
        Field field = fieldMap.get(clz);
        if (field == null) {
            return super.get(clz);
        }
        try {
            return (T) field.get(this);
        } catch (IllegalAccessException e) {
            // never happen
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Statement> List<T> getList(Class<T> clz) {
        initSubFieldType();
        Map<Class<?>, Field> fieldMap = LIST_SUB_FIELD_MAP.get(this.getClass());
        Field field = fieldMap.get(clz);
        if (field == null) {
            return super.getList(clz);
        }
        try {
            return (List<T>) field.get(this);
        } catch (IllegalAccessException e) {
            // never happen
            e.printStackTrace();
        }
        return null;
    }

    private void dealIllegalAccessException(IllegalAccessException iae) {
        iae.printStackTrace();
        throw new SyntaxException("Unknown statement");
    }

    private <T extends Statement> Field getField(Class<T> type) {
        initSubFieldType();
        return SUB_FIELD_MAP.get(this.getClass()).get(type);
    }

    private void initSubFieldType() {
        final Class<? extends BaseAppendableStatement> thisClz = this.getClass();
        if (SUB_FIELD_MAP.get(thisClz) == null) {
            synchronized (thisClz) {
                if (SUB_FIELD_MAP.get(thisClz) == null) {
                    Map<Class<?>, Field> fieldBuf = new HashMap<>();
                    Field[] fields = thisClz.getDeclaredFields();
                    for (Field field : fields) {
                        Class<?> fieldClz = field.getType();
                        if (isStatementClz(fieldClz)) {
                            field.setAccessible(true);
                            fieldBuf.put(fieldClz, field);
                        }
                    }
                    SUB_FIELD_MAP.put(thisClz, fieldBuf);
                }
            }
        }
    }

    private <T extends Statement> Field getListField(Class<T> type) {
        initSubListFieldType();
        return LIST_SUB_FIELD_MAP.get(this.getClass()).get(type);
    }

    private void initSubListFieldType() {
        final Class<? extends BaseAppendableStatement> thisClz = this.getClass();
        if (!LIST_SUB_FIELD_MAP.containsKey(thisClz)) {
            synchronized (thisClz) {
                if (!LIST_SUB_FIELD_MAP.containsKey(thisClz)) {
                    Map<Class<?>, Field> fieldBuf = new HashMap<>();
                    Field[] fields = thisClz.getDeclaredFields();
                    for (Field field : fields) {
                        Type fc = field.getGenericType();
                        if (fc instanceof ParameterizedType) {
                            ParameterizedType pt = (ParameterizedType) fc;
                            Type[] types = pt.getActualTypeArguments();
                            if (types != null && types.length > 0) {
                                Class<?> typeClz = (Class<?>) types[0];
                                if (isStatementClz(typeClz)) {
                                    field.setAccessible(true);
                                    fieldBuf.put(typeClz, field);
                                }
                            }
                        }
                    }
                    LIST_SUB_FIELD_MAP.put(thisClz, fieldBuf);
                }
            }
        }
    }

    private boolean isStatementClz(Class<?> clz) {
        Queue<Class<?>> queue = new LinkedList<>(Arrays.asList(clz.getInterfaces()));
        queue.add(clz.getSuperclass());
        Set<Class<?>> checked = new HashSet<>();
        Class<?> statementClz = Statement.class;
        while (true) {
            Class<?> one = queue.poll();
            if (one == null) {
                return false;
            } else if (!checked.contains(one)) {
                if (one == statementClz || one.isAssignableFrom(statementClz)) {
                    return true;
                }
                for (Class<?> in : one.getInterfaces()) {
                    if (!checked.contains(in)) {
                        queue.add(in);
                    }
                }
                Class<?> sc = one.getSuperclass();
                if (!checked.contains(sc)) {
                    queue.add(sc);
                }
                checked.add(one);
            }
        }
    }

    private <T extends Statement> void notNull(T t) {
        if (t == null) throw new NullPointerException("Statement to append must not be null!");
    }


    /**
     * Judge whether the substatement exist
     *
     * @param previous previous substatement instance
     */
    private void notDuplicate(Statement previous) {
        if (previous != null) {
            throw new SyntaxException("Duplicate %s has bean set up  in %s statement",
                    NameUtil.java2Yang(previous.getClass()),
                    NameUtil.java2Yang(this.getClass())
            );
        }
    }
}
