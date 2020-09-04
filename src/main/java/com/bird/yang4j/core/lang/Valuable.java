package com.bird.yang4j.core.lang;

/**
 * Regard the argument as one value of this statement
 */
public interface Valuable<T> extends Statement {

    /**
     * Transfer the argument value 2 java variable
     *
     * @return the java variable
     * @throws IllegalArgumentException while this statement does not support value
     */
    T getArgumentJava() throws IllegalArgumentException;
}
