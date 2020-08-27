package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

/**
 * Section 7.17
 */
public class Extension extends BaseAppendableStatement {
    private Argument argumentS;
    private Description description;
    private Reference reference;
    private Status status;

    public Argument getArgumentS() {
        return argumentS;
    }

    public void setArgumentS(Argument argumentS) {
        this.argumentS = argumentS;
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
}
