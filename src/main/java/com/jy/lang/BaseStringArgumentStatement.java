package com.jy.lang;

/**
 * The statements which takes as an argument a string
 */
public class BaseStringArgumentStatement extends AbstractStatement {
    @Override
    public Object value2Java() throws IllegalArgumentException {
        return BuiltInType.STRING.fromArgument(argument);
    }
}
