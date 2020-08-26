package com.jy.lang;

import com.jy.SyntaxException;

/**
 * statement = keyword [argument] (";" /"{" *statement "}" )
 *
 * @author zhy
 */
public interface Statement {

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
     * Transfer the argument value 2 java variable
     *
     * @return the java variable
     * @throws IllegalArgumentException while this statement does not support value
     */
    Object value2Java() throws IllegalArgumentException;
}
