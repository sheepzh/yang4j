package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.Statement;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhy
 */
public class LeafList extends Node {
    private List<Leaf> leafList = new LinkedList<Leaf>();

    public LeafList appendChild(Statement statement) throws SyntaxException {
        if (!(statement instanceof Leaf))
            throw new SyntaxException("leaf list must contains any nodes but leaf");
        return this;
    }
}
