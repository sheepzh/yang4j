package com.jy.lang.statement;

import com.jy.lang.AbstractStatement;
import com.jy.lang.Valuable;
import com.jy.lang.constant.StatusEnum;
import com.jy.util.StringUtils;

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
