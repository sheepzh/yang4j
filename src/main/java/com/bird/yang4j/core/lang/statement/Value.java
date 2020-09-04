package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.AbstractStatement;
import com.bird.yang4j.core.lang.Valuable;

/**
 * Section 9.6.4.2
 * The value of enum is unused by YANG and the XML encoding, but is carried as a convenience to implementors.
 */
public class Value extends AbstractStatement implements Valuable<Integer> {
    // Min and max is defined in RFC 6020;
    public final static int MIN = -2147483648;
    public final static int MAX = 2147483647;

    @Override
    public void assertArgument() throws SyntaxException {
        super.assertArgument();
        try {
            // MIN = Integer.MIN_VALUE
            // MAX = Integer.MAX_VALUE
            // So need not validate
            Integer.parseInt(argument);
        } catch (NumberFormatException nfe) {
            throw new SyntaxException("Format integer error with '%s'!", argument);
        }
    }

    public Integer getArgumentJava() {
        try {
            return Integer.parseInt(argument);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(nfe);
        }
    }
}
