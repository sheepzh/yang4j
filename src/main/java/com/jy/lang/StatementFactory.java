package com.jy.lang;

import com.jy.SyntaxException;
import com.jy.lang.statement.*;
import com.jy.lang.statement.Module;
import com.jy.util.NameUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Factory of statement
 *
 * @author zhy
 */
public class StatementFactory {
    private static StatementFactory instance;

    private final Map<String, Supplier<? extends AbstractStatement>> constructorMap;

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
        registry(Anyxml.class);
        registry(Augment.class);
        registry(Module.class);
        registry(Rpc.class);
        registry(Config.class);
    }

    /**
     * Registry statements
     *
     * @param clz type of statement
     */
    private <T extends AbstractStatement> void registry(Class<T> clz) {
        try {
            Constructor<T> constructor = clz.getConstructor();
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

    public Statement product(String keyword, String argument) {
        Supplier<? extends AbstractStatement> constructor = constructorMap.get(keyword);
        if (constructor == null) throw new SyntaxException("Unknown keyword: %s", keyword);
        return constructor.get().setKeyword(keyword).setArgument(argument);
    }
}
