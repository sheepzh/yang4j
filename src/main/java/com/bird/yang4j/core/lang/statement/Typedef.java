package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.BaseAppendableStatement;

/**
 * Section 7.5
 */
public class Typedef extends BaseAppendableStatement {
    /**
     * Must not be null
     * Perhaps, the type can't be a base built-in type, but must be traced back to a YANG built-in type
     */
    private Type type;

    private Default defaultS;
    private Description description;
    private Reference reference;
    private Status status;
    private Units units;

    @Override
    public void assertChild() throws SyntaxException {
        super.assertChild();
        required(type, Type.class);
        assertDefault(type, defaultS);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Default getDefault() {
        return defaultS;
    }

    public void setDefault(Default defaultS) {
        this.defaultS = defaultS;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }
}
