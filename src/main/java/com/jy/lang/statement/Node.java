package com.jy.lang.statement;

import com.jy.lang.AbstractStatement;
import com.jy.lang.BuiltInType;

/**
 * Node
 *
 * @author zhy
 */
public abstract class Node extends AbstractStatement {
    private BuiltInType type;
    private String description;

    public BuiltInType getType() {
        return type;
    }

    public void setType(BuiltInType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
