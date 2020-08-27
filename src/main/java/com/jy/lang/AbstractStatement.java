package com.jy.lang;

import com.jy.SyntaxException;
import com.jy.util.NameUtil;


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

    protected void notSupport(Statement child) {
        throw new SyntaxException("%s is not support in %s",
                NameUtil.java2Yang(child.getClass()),
                NameUtil.java2Yang(this.getClass())
        );
    }
}
