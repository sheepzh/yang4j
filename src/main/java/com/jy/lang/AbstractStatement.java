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

    protected int min = 0;

    protected int max = 1;

    public String getKeyword() {
        return keyword;
    }

    public AbstractStatement setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getArgument() {
        return argument;
    }

    public AbstractStatement setArgument(String argument) {
        this.argument = argument;
        return this;
    }

    public int getMin() {
        return min;
    }

    public AbstractStatement setMin(int min) {
        this.min = min;
        return this;
    }

    public int getMax() {
        return max;
    }

    public AbstractStatement setMax(int max) {
        this.max = max;
        return this;
    }

    protected <T extends Statement> void notNull(T t) {
        if (t == null) throw new NullPointerException("Statement to append must not be null!");
    }

    protected <T extends Statement> void notSupport(Class<T> clz) {
        throw new SyntaxException("%s is not support in %s",
                NameUtil.java2Yang(clz),
                NameUtil.java2Yang(this.getClass())
        );
    }
}
