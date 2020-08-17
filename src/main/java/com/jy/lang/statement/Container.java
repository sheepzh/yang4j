package com.jy.lang.statement;

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

    public Container appendChild(Statement statement) {
        children.add(statement);
        return this;
    }
}
