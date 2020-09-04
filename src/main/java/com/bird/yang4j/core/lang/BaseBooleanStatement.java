package com.bird.yang4j.core.lang;

import com.bird.yang4j.core.util.NameUtil;
import com.bird.yang4j.core.util.StringUtils;
import com.bird.yang4j.core.SyntaxException;

import static com.bird.yang4j.core.lang.builtin.BuiltInType.BOOLEAN;

/**
 * The statements which takes as an argument a string that is "true" or "false"
 */
public abstract class BaseBooleanStatement extends AbstractStatement implements Valuable<Boolean> {

    @Override
    public void assertChild() throws SyntaxException {
        super.assertChild();
        if (!"true".equals(argument) && !"false".equals(argument)) {
            throw new SyntaxException("The argument of %s must be 'true' or 'false', but '%s' found!",
                    NameUtil.java2Yang(this.getClass()), argument
            );
        }
    }

    @Override
    public Boolean getArgumentJava() throws IllegalArgumentException {
        if (StringUtils.isBlank(argument)) {
            throw new SyntaxException("No value in config!");
        } else {
            return BOOLEAN.fromArgument(argument);
        }
    }
}
