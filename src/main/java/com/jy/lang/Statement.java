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
     * @param statement tail child
     * @param <T>       statement type
     * @throws SyntaxException      while syntax error happens
     * @throws NullPointerException while param statement is null
     */
    <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException;

    /**
     * Transfer the argument value 2 java variable
     *
     * @return the java variable
     * @throws IllegalArgumentException while this statement does not support value
     */
    Object value2Java() throws IllegalArgumentException;
}
