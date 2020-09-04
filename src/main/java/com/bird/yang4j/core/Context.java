package com.bird.yang4j.core;

import com.bird.yang4j.core.lang.statement.Typedef;
import com.bird.yang4j.core.lang.builtin.BuiltInType;

import java.util.HashMap;
import java.util.Map;

/**
 * The context of nodes of statement
 *
 * @author zhy
 */
public class Context {

    private final Map<String, Typedef> derivedTypes = new HashMap<>();

    /**
     * The context of parent statement
     */
    private Context parent;

    /**
     * Add one derived type to the context
     *
     * @param typedef typedef
     */
    public void addDerivedType(Typedef typedef) {
        derivedTypes.put(typedef.getArgument(), typedef);
    }

    /**
     * Get the origin type
     *
     * @param typeArgument derived type argument
     * @return origin type
     */
    public BuiltInType<?> getOriginTypeOf(String typeArgument) {
        Context current = this;
        Typedef typedef = null;
        while (current != null && typedef == null) {
            typedef = current.derivedTypes.get(typeArgument);
            current = current.getParent();
        }
        return typedef == null ? null : typedef.getType().getArgumentJava();
    }

    public Context getParent() {
        return parent;
    }

    public void setParent(Context parent) {
        this.parent = parent;
    }
}
