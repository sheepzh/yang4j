package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.builtin.BuiltInType;
import com.jy.lang.builtin.BuiltInTypeFactory;
import com.jy.lang.Valuable;

/**
 * Section 7.6.3
 */
public class Type extends AbstractStatement implements Valuable<BuiltInType<?>> {
    @Override
    public void assertChild() throws SyntaxException {
        assertValid0();
    }

    @Override
    public BuiltInType<?> getArgumentJava() throws IllegalArgumentException {
        return assertValid0();
    }

    private BuiltInType<?> assertValid0() {
        BuiltInType<?> builtInType = BuiltInTypeFactory.getInstance().product(argument);
        if (builtInType == null) {
            throw new SyntaxException("Invalid argument of 'type': %s", argument);
        }
        return builtInType;
    }
}
