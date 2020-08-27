package com.jy.lang;

import com.jy.SyntaxException;

/**
 * Statements which can contains children
 */
public interface ChildrenAppendable extends Statement {

    /**
     * Append one child at the tail of this
     *
     * @param s   tail child
     * @param <T> s type
     * @throws SyntaxException      while syntax error happens
     * @throws NullPointerException while param s is null
     */
    <T extends Statement> void append(T s) throws SyntaxException, NullPointerException;

    /**
     * Get the identifier of this statement, always means its argument
     *
     * @return identifier
     */
    default String getIdentifier() {
        return getArgument();
    }
}
