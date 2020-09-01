package com.jy.lang;

import com.jy.lang.builtin.BuiltInType;

/**
 * The statements which takes as an argument a string
 */
public abstract class BaseTextStatement extends AbstractStatement implements Valuable<String> {
    @Override
    public String getArgumentJava() throws IllegalArgumentException {
        return BuiltInType.STRING.fromArgument(argument);
    }
}
