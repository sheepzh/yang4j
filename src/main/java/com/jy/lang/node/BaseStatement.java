package com.jy.lang.node;

import com.jy.lang.BuiltInType;

/**
 * @author zhy
 */
public class BaseStatement extends Statement {
    private BuiltInType type;
    private String description;

    public BuiltInType getType() {
        return type;
    }

    public BaseStatement setType(BuiltInType type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BaseStatement setDescription(String description) {
        this.description = description;
        return this;
    }
}
