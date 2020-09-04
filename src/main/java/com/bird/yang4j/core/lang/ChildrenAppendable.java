package com.bird.yang4j.core.lang;

/**
 * Statements which can contains children
 */
public interface ChildrenAppendable extends Statement {

    /**
     * Append one child at the tail of this
     *
     * @param s   tail child
     * @param <T> s type
     * @throws IllegalArgumentException if this statement must not contain this substatement
     * @throws NullPointerException     if param s is null
     */
    <T extends Statement> void append(T s) throws IllegalArgumentException, NullPointerException;

    /**
     * Get the identifier of this statement, always means its argument
     *
     * @return identifier
     */
    default String getIdentifier() {
        return getArgument();
    }
}
