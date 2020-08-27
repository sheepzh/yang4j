package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Valuable;
import com.jy.util.StringUtils;

/**
 * Section 7.7.3
 */
public class MinElements extends AbstractStatement implements Valuable<Integer> {
    public static final int DEFAULT = 0;

    private final static SyntaxException SYNTAX_ERROR =
            new SyntaxException("The argument of 'min-elements' must be a non-negative integer");

    @Override
    public void assertValid() throws SyntaxException {
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
        try {
            int val = Integer.parseInt(argument);
            if (val < 0) throw new SyntaxException();
            return val;
        } catch (NumberFormatException ne) {
            throw SYNTAX_ERROR;
        }
    }
}
