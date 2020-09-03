package com.jy.parser;

import com.jy.lang.builtin.BuiltInType;
import com.jy.lang.statement.Typedef;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private final Map<String, Typedef> derivedTypes = new HashMap<>();

    /**
     * Add one derived type to the context
     *
     * @param typedef typedef
     */
    void addDerivedType(Typedef typedef) {
        derivedTypes.put(typedef.getArgument(), typedef);
    }

    /**
     * Get the origin type
     *
     * @param typeArgument derived type argument
     * @return origin type
     */
    BuiltInType<?> getOriginType(String typeArgument) {
        Typedef typedef = derivedTypes.get(typeArgument);
        return typedef == null ? null : typedef.getType().getArgumentJava();
    }
}
