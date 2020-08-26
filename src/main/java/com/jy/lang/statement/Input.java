package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Statement;

public class Input extends AbstractStatement implements Statement {
    @Override
    public <T extends Statement> void append(T s) throws SyntaxException, NullPointerException {

    }
}
