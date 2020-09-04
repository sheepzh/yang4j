package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;
import com.bird.yang4j.core.lang.Valuable;
import com.bird.yang4j.core.lang.annotation.AliasFor;

import java.util.Stack;

/**
 * Section 9.6.5
 */
@AliasFor("enum")
public class EnumS extends BaseAppendableStatement implements Valuable<String> {

    private Description description;
    private Reference reference;
    private Status status;
    private Value value;

    @Override
    public String getArgumentJava() throws IllegalArgumentException {
        return argument;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
