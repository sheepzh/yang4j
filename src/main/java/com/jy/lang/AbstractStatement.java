package com.jy.lang;

/**
 * @author zhy
 */
public abstract class AbstractStatement implements Statement {

    /**
     * Name of this statement
     */
    protected String keyword;

    protected String argument;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
