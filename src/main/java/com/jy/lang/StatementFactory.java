package com.jy.lang;

import com.jy.SyntaxException;
import com.jy.lang.statement.Anyxml;
import com.jy.lang.statement.Module;
import com.jy.lang.statement.Rpc;

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
        constructorMap.put(Anyxml.KEYWORD, Anyxml::new);
        constructorMap.put(Module.KEYWORD, Module::new);
        constructorMap.put(Rpc.KEYWORD, Rpc::new);
    }

    public Statement product(String keyword, String argument) {
        Supplier<? extends AbstractStatement> constructor = constructorMap.get(keyword);
        if (constructor == null) throw new SyntaxException("Unknown keyword: %s", keyword);
        return constructor.get().setKeyword(keyword).setArgument(argument);
    }
}
