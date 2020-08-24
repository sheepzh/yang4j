package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.Statement;

/**
 * @author zhy
 */
public class LeafList extends Node {

    @Override
    public <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException {

    }
}
