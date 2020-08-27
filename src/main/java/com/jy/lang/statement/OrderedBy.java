package com.jy.lang.statement;

import com.jy.lang.AbstractStatement;
import com.jy.lang.Valuable;
import com.jy.lang.constant.OrderedByEnum;
import com.jy.util.StringUtils;

/**
 * Section 7.7.5
 */
public class OrderedBy extends AbstractStatement implements Valuable<OrderedByEnum> {
    @Override
    public OrderedByEnum getArgumentJava() throws IllegalArgumentException {
        if (StringUtils.isBlank(argument)) {
            return OrderedByEnum.DEFAULT;
        }
        try {
            return Enum.valueOf(OrderedByEnum.class, argument);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Unknown argument of 'ordered-by' statement: " + argument);
        }
    }
}
