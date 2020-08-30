package com.jy.lang;

/**
 * @author zhy
 */
public abstract class AbstractStatement implements Statement {

    protected String argument;
    protected Statement parent;

    @Override
    public String getArgument() {
        return argument;
    }

    @Override
    public void setArgument(String argument) {
        this.argument = argument;
    }

    @Override
    public Statement getParent() {
        return parent;
    }

    @Override
    public void setParent(Statement parent) {
        this.parent = parent;
    }
}
