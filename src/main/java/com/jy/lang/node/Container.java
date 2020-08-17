package com.jy.lang.node;

import java.util.List;

/**
 * @author zhy
 */
public class Container extends Statement {
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
}
