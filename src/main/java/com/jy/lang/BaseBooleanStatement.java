package com.jy.lang;

import com.jy.SyntaxException;
import com.jy.util.StringUtils;

import static com.jy.lang.BuiltInType.BOOLEAN;

/**
 * The statements which takes as an argument a string that is "true" or "false"
 */
public abstract class BaseBooleanStatement extends AbstractStatement {
    @Override
    public Object value2Java() throws IllegalArgumentException {
        if (StringUtils.isBlank(argument)) {
            throw new SyntaxException("No value in config!");
        } else {
            return BOOLEAN.fromArgument(argument);
        }
    }
}
