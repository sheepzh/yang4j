package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Statement;

/**
 * @author zhy
 */
public class Rpc extends AbstractStatement implements Statement {
    public static String KEYWORD = "rpc";

    @Override
    public <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException {

    }
}
