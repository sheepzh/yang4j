package com.jy.lang;

/**
 * @author zhy
 */
public abstract class AbstractStatement implements Statement {

    protected String argument;

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
