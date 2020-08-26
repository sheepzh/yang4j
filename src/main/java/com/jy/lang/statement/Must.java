package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.BuiltInType;
import com.jy.lang.Statement;

/**
 * Section 7.5.3
 */
public class Must extends AbstractStatement {
    private Description description;
    private ErrorAppTag errorAppTag;
    private ErrorMessage errorMessage;
    private Reference reference;

    @Override
    public <T extends Statement> void append(T s) throws SyntaxException, NullPointerException {
        notNull(s);
        if (s instanceof Description) {
            description = (Description) s;
        } else if (s instanceof ErrorAppTag) {
            errorAppTag = (ErrorAppTag) s;
        } else if (s instanceof ErrorMessage) {
            errorMessage = (ErrorMessage) s;
        } else if (s instanceof Reference) {
            reference = (Reference) s;
        } else {
            notSupport(s);
        }
    }

    @Override
    public String value2Java() throws IllegalArgumentException {
        return BuiltInType.STRING.fromArgument(argument);
    }

    public Description getDescription() {
        return description;
    }

    public Must setDescription(Description description) {
        this.description = description;
        return this;
    }

    public ErrorAppTag getErrorAppTag() {
        return errorAppTag;
    }

    public Must setErrorAppTag(ErrorAppTag errorAppTag) {
        this.errorAppTag = errorAppTag;
        return this;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public Must setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Must setReference(Reference reference) {
        this.reference = reference;
        return this;
    }
}
