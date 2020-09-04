package com.bird.yang4j.core.lang;

import com.bird.yang4j.core.Context;

/**
 * @author zhy
 */
public abstract class AbstractStatement implements Statement {

    protected String argument;
    protected Statement parent;
    protected Context context;

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

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }
}
