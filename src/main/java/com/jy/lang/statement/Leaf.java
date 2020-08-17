package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.Statement;

/**
 * @author zhy
 */
public class Leaf extends Node {
    public Leaf appendChild(Statement statement) throws SyntaxException {
        throw new SyntaxException("Leaf mustn't contain any child node");
    }
}
