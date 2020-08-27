package com.jy.lang;

/**
 * The statements which takes as an argument a string
 */
public abstract class BaseTextStatement extends AbstractStatement implements Valuable {
    @Override
    public Object getArgumentJava() throws IllegalArgumentException {
        return BuiltInType.STRING.fromArgument(argument);
    }
}
