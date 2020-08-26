package com.jy.lang;

import com.jy.SyntaxException;
import com.jy.util.NameUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Appendable statement
 *
 * @author zhy
 */
public abstract class BaseAppendableStatement extends AbstractStatement {

    private Map<Class<?>, Field> subFieldType;
    private Map<Class<?>, Field> listSubFieldType;

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
                e.printStackTrace();
                throw new SyntaxException("Unknown statement %s", NameUtil.java2Yang(s.getClass()));
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
                    e.printStackTrace();
                    throw new SyntaxException("Unknown statement %s", NameUtil.java2Yang(s.getClass()));
                }
            }
        }
    }

    private <T extends Statement> Field getField(Class<T> type) {
        if (subFieldType == null) {
            subFieldType = new HashMap<>();
            Class<? extends BaseAppendableStatement> clz = this.getClass();
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                Class<?> fieldClz = field.getType();
                if (isStatementClz(fieldClz)) {
                    field.setAccessible(true);
                    subFieldType.put(fieldClz, field);
                }
            }
        }
        return subFieldType.get(type);
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

    private <T extends Statement> Field getListField(Class<T> type) {
        if (listSubFieldType == null) {
            listSubFieldType = new HashMap<>();
            Class<? extends BaseAppendableStatement> clz = this.getClass();
            Field[] fields = clz.getFields();
            for (Field field : fields) {
                Type fc = field.getGenericType();
                if (fc instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) fc;
                    Type[] types = pt.getActualTypeArguments();
                    if (types != null && types.length > 0) {
                        Class<?> typeClz = (Class<?>) types[0];
                        if (isStatementClz(typeClz)) {
                            field.setAccessible(true);
                            listSubFieldType.put(clz, field);
                        }
                    }
                }
            }
        }
        return listSubFieldType.get(type);
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
