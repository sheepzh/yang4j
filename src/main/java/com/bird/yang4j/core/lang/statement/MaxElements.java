package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.AbstractStatement;
import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.Valuable;
import com.bird.yang4j.core.util.StringUtils;


public class MaxElements extends AbstractStatement implements Valuable<Integer> {
    public static final int UNBOUNDED = Integer.MAX_VALUE;

    private final static SyntaxException SYNTAX_ERROR =
            new SyntaxException("The argument of 'max-elements' must be a positive integer or the string 'unbounded'");

    @Override
    public void assertChild() throws SyntaxException {
        assertValid0();
    }

    @Override
    public Integer getArgumentJava() throws IllegalArgumentException {
        return assertValid0();
    }

    private Integer assertValid0() {
        if (StringUtils.isBlank(argument)) {
            throw SYNTAX_ERROR;
        }
        if ("unbounded".equals(argument)) return UNBOUNDED;
        try {
            int val = Integer.parseInt(argument);
            if (val < 1) throw new SyntaxException();
            return val;
        } catch (NumberFormatException ne) {
            throw SYNTAX_ERROR;
        }
    }
}
