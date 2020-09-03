package com.jy.lang;

import com.jy.SyntaxException;
import com.jy.lang.statement.*;
import com.jy.lang.statement.Module;
import com.jy.util.NameUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Supplier;

/**
 * Factory of statement
 *
 * @author zhy
 */
public class StatementFactory {
    private static StatementFactory instance;

    private final Map<String, Supplier<? extends Statement>> constructorMap;

    public static StatementFactory getInstance() {
        if (instance == null) {
            synchronized (StatementFactory.class) {
                if (instance == null) instance = new StatementFactory();
            }
        }
        return instance;
    }

    private StatementFactory() {
        constructorMap = new HashMap<>();
        register(
                Anyxml.class, Augment.class,
                Case.class, Choice.class, Config.class, Contact.class, Container.class,
                Default.class, Description.class,
                Input.class,
                Key.class,
                Leaf.class, LeafList.class, Length.class, ListS.class,
                Module.class,
                Namespace.class,
                Organization.class, Output.class,
                Pattern.class, Prefix.class,
                Revision.class, Rpc.class,
                Type.class
        );
    }

    /**
     * Registry statements
     *
     * @param classes type of statement
     */
    @SafeVarargs
    private final void register(Class<? extends Statement>... classes) {
        for (Class<? extends Statement> clz : classes) {
            try {
                Constructor<? extends Statement> constructor = clz.getConstructor();
                constructorMap.put(NameUtil.java2Yang(clz), () -> {
                    try {
                        return constructor.newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException("Registry error", e);
                    }
                });
            } catch (NoSuchMethodException nme) {
                throw new RuntimeException("Registry error", nme);
            }
        }
    }

    /**
     * @throws IllegalArgumentException if the keyword is illegal
     */
    public Statement product(String keyword) {
        return product(keyword, null);
    }

    /**
     * @throws IllegalArgumentException if the keyword is illegal
     */
    public Statement product(String keyword, String argument) {
        Supplier<? extends Statement> constructor = constructorMap.get(keyword);
        if (constructor == null) throw new IllegalArgumentException("Illegal keyword: " + keyword);
        Statement result = constructor.get();
        result.setArgument(argument);
        return result;
    }
}
