package com.jy.lang.statement;

import com.jy.lang.AbstractStatement;
import com.jy.lang.constant.StatusEnumSet;
import com.jy.util.StringUtils;

/**
 * Section 7.19.2
 */
public class Status extends AbstractStatement {
    @Override
    public StatusEnumSet value2Java() throws IllegalArgumentException {
        if (StringUtils.isBlank(argument)) {
            return StatusEnumSet.DEFAULT;
        }
        try {
            return Enum.valueOf(StatusEnumSet.class, argument);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Unknown value of status statement: " + argument);
        }
    }
}
