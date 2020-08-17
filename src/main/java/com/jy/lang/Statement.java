package com.jy.lang;

import com.jy.SyntaxException;

/**
 * @author zhy
 */
public interface Statement {
    /**
     * Append one child at the tail of this
     *
     * @param statement tail child
     * @return <code>this</code> instance of implementor class
     * @throws SyntaxException thrown while syntax error happens
     */
    Statement appendChild(Statement statement) throws SyntaxException;
}
