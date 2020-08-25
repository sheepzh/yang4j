package com.jy.lang.statement;

import com.jy.lang.AbstractStatement;
import com.jy.lang.BuiltInType;

/**
 * Section 7.6.5
 */
public class Mandatory extends AbstractStatement {
    @Override
    public Object value2Java() throws IllegalArgumentException {
        return BuiltInType.BOOLEAN.fromArgument(argument);
    }
}
