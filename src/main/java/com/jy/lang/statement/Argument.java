package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Statement;

public class Argument extends AbstractStatement {
    @Override
    public <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException {

    }
}
