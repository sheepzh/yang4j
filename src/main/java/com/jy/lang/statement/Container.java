package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.Statement;

import java.util.List;

/**
 * @author zhy
 */
public class Container implements Statement {
    List<Statement> children;

    public void add(Statement statement) {
        children.add(statement);
    }

    public List<Statement> getChildren() {
        return children;
    }

    public Container setChildren(List<Statement> children) {
        this.children = children;
        return this;
    }

    @Override
    public <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException {

    }
}
