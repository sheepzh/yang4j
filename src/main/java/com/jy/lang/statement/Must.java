package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.BuiltInType;
import com.jy.lang.Statement;

/**
 * Section 7.5.3
 * <p>
 * The must’s Substatements:
 * +---------------+---------+-------------+
 * | substatement  | section | cardinality |
 * +---------------+---------+-------------+
 * | description   | 7.19.3  | 0..1        |
 * | error-app-tag | 7.5.4.2 | 0..1        |
 * | error-message | 7.5.4.1 | 0..1        |
 * | reference     | 7.19.4  | 0..1        |
 * +---------------+---------+-------------+
 */
public class Must extends AbstractStatement {
    private Description description;
    private ErrorAppTag errorAppTag;
    private ErrorMessage errorMessage;
    private Reference reference;

    @Override
    public <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException {
        notNull(statement);
        if (statement instanceof Description) {
            description = (Description) statement;
        } else if (statement instanceof ErrorAppTag) {
            errorAppTag = (ErrorAppTag) statement;
        } else if (statement instanceof ErrorMessage) {
            errorMessage = (ErrorMessage) statement;
        } else if (statement instanceof Reference) {
            reference = (Reference) statement;
        } else {
            notSupport(statement);
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
