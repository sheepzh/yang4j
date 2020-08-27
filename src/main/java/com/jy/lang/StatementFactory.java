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
                Leaf.class, LeafList.class, ListS.class,
                Module.class,
                Namespace.class,
                Organization.class, Output.class,
                Prefix.class,
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

    public Statement product(String keyword, String argument) {
        Supplier<? extends Statement> constructor = constructorMap.get(keyword);
        if (constructor == null) throw new SyntaxException("Unknown keyword: %s", keyword);
        Statement result = constructor.get();
        result.setKeyword(keyword);
        result.setArgument(argument);
        return result;
    }
}
