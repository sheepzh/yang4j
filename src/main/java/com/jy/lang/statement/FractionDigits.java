package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Valuable;

/**
 * Fraction digits for 'decimal64'
 * Section 9.3.4
 */
public class FractionDigits extends AbstractStatement implements Valuable<Integer> {

    @Override
    public void assertArgument() throws SyntaxException {
        assertArgument0();
    }

    @Override
    public Integer getArgumentJava() throws IllegalArgumentException {
        return Integer.parseInt(argument);
    }

    private void assertArgument0() {
        try {
            int result = Integer.parseInt(argument);
            if (result < 1 || result > 18)
                throw new SyntaxException("Value of 'fraction-digits' is out of limit (1-18)");
        } catch (NumberFormatException ne) {
            throw new SyntaxException("Format error!");
        }
    }
}
