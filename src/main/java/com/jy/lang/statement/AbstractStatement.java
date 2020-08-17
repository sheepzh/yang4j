package com.jy.lang.statement;

import com.jy.lang.Statement;

/**
 * @author zhy
 */
public abstract class AbstractStatement implements Statement {
    /**
     * Name of this statement
     */
    protected String name;

    public String getName() {
        return name;
    }

    public Statement setName(String name) {
        this.name = name;
        return this;
    }
}
