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

    protected <T extends Statement> void notNull(T t) {
        if (t == null) throw new NullPointerException("Statement to append must not be null!");
    }

    protected void notSupport(Statement child) {
        throw new SyntaxException("%s is not support in %s",
                NameUtil.java2Yang(child.getClass()),
                NameUtil.java2Yang(this.getClass())
        );
    }

    /**
     * Do not support by default
     *
     * @param statement tail child
     * @param <T>       type of child
     * @throws SyntaxException always thrown
     */
    @Override
    public <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException {
        notSupport(statement);
    }

    /**
     * Do not support by default
     *
     * @throws IllegalArgumentException always thrown
     */
    @Override
    public Object value2Java() throws IllegalArgumentException {
        throw new IllegalArgumentException(
                String.format("Argument of %s is not value", NameUtil.java2Yang(this.getClass()))
        );
    }
}
