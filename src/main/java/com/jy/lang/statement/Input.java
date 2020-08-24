package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Statement;

/**
 * The input of RPC
 *
 * @author zhy
 */
public class Input extends AbstractStatement implements Statement {
    @Override
    public <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException {

    }
}
