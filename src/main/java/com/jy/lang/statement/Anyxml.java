package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Statement;

import java.util.LinkedList;
import java.util.List;

/**
 * Section 7.10
 * <p>
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

    private Config config;
    private Description description;
    private List<IfFeature> ifFeatureList;
    private Mandatory mandatory;
    private List<Must> mustList;
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
            if (ifFeatureList == null) ifFeatureList = new LinkedList<>();
            ifFeatureList.add((IfFeature) statement);
        } else if (statement instanceof Mandatory) {
            mandatory = (Mandatory) statement;
        } else if (statement instanceof Must) {
            if (mustList == null) mustList = new LinkedList<>();
            mustList.add((Must) statement);
        } else if (statement instanceof Reference) {
            reference = (Reference) statement;
        } else if (statement instanceof Status) {
            status = (Status) statement;
        } else if (statement instanceof When) {
            when = (When) statement;
        } else {
            notSupport(statement);
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

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public Anyxml setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
        return this;
    }

    public Mandatory getMandatory() {
        return mandatory;
    }

    public Anyxml setMandatory(Mandatory mandatory) {
        this.mandatory = mandatory;
        return this;
    }

    public List<Must> getMustList() {
        return mustList;
    }

    public Anyxml setMustList(List<Must> mustList) {
        this.mustList = mustList;
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
