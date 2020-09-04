package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.AbstractStatement;
import com.bird.yang4j.core.lang.Valuable;
import com.bird.yang4j.core.lang.constant.StatusEnum;
import com.bird.yang4j.core.util.StringUtils;

/**
 * Section 7.19.2
 */
public class Status extends AbstractStatement implements Valuable<StatusEnum> {
    @Override
    public StatusEnum getArgumentJava() throws IllegalArgumentException {
        if (StringUtils.isBlank(argument)) {
            return StatusEnum.DEFAULT;
        }
        try {
            return Enum.valueOf(StatusEnum.class, argument);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Unknown argument of 'status' statement: " + argument);
        }
    }
}
