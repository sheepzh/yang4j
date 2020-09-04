package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.AbstractStatement;
import com.bird.yang4j.core.lang.Valuable;
import com.bird.yang4j.core.lang.constant.OrderedByEnum;
import com.bird.yang4j.core.util.StringUtils;

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
