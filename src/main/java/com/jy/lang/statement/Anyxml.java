package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Statement;

/**
 * Section 7.10, RFC 6020
 * The anyxml’s Substatements
 * +--------------+---------+-------------+
 * | substatement | section | cardinality |
 * +--------------+---------+-------------+
 * | config       | 7.19.1  | 0..1        |
 * | description  | 7.19.3  | 0..1        |
 * | if-feature   | 7.18.2  | 0..n        |
 * | mandatory    | 7.6.5   | 0..1        |
 * | must         | 7.5.3   | 0..n        |
 * | reference    | 7.19.4  | 0..1        |
 * | status       | 7.19.2  | 0..1        |
 * | when         | 7.19.5  | 0..1        |
 * +--------------+---------+-------------
 */
public class Anyxml extends AbstractStatement {

    public static String KEYWORD = "anyxml";

    private Config config;
    private Description description;
    private IfFeature ifFeature;
    private Mandatory mandatory;
    private Must must;
    private Reference reference;
    private Status status;
    private When when;

    @Override
    public <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException {
        if (statement instanceof Config) {
            config = (Config) statement;
        } else if (statement instanceof Description) {
            description = (Description) statement;
        } else if (statement instanceof IfFeature) {
            ifFeature = (IfFeature) ((AbstractStatement) statement).setMax(Integer.MAX_VALUE);
        } else if (statement instanceof Mandatory) {
            mandatory = (Mandatory) statement;
        } else if (statement instanceof Must) {
            must = (Must) ((AbstractStatement) statement).setMax(Integer.MAX_VALUE);
        } else if (statement instanceof Reference) {
            reference = (Reference) statement;
        } else if (statement instanceof Status) {
            status = (Status) statement;
        } else if (statement instanceof When) {
            when = (When) statement;
        } else {
            notSupport(statement.getClass());
        }
    }

    public Config getConfig() {
        return config;
    }

    public Anyxml setConfig(Config config) {
        this.config = config;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public Anyxml setDescription(Description description) {
        this.description = description;
        return this;
    }

    public IfFeature getIfFeature() {
        return ifFeature;
    }

    public Anyxml setIfFeature(IfFeature ifFeature) {
        this.ifFeature = ifFeature;
        return this;
    }

    public Mandatory getMandatory() {
        return mandatory;
    }

    public Anyxml setMandatory(Mandatory mandatory) {
        this.mandatory = mandatory;
        return this;
    }

    public Must getMust() {
        return must;
    }

    public Anyxml setMust(Must must) {
        this.must = must;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Anyxml setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Anyxml setStatus(Status status) {
        this.status = status;
        return this;
    }

    public When getWhen() {
        return when;
    }

    public Anyxml setWhen(When when) {
        this.when = when;
        return this;
    }
}
