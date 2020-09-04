package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.AbstractStatement;
import com.bird.yang4j.core.lang.Valuable;

public class Position extends AbstractStatement implements Valuable<Long> {
    public static final long MAX = 4294967295L;
    public static final long MIN = 0;


    @Override
    public void assertArgument() throws SyntaxException {
        try {
            long result = Long.parseLong(argument);
            if (result < MIN || result > MAX) {
                throw new SyntaxException("Position '%d' is out of limit [%d-%d]", result, MIN, MAX);
            }
        } catch (NumberFormatException nfe) {
            throw new SyntaxException(nfe, "Format error!");
        }
    }

    @Override
    public Long getArgumentJava() throws IllegalArgumentException {
        return Long.parseLong(argument);
    }
}
