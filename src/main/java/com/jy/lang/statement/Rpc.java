package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Statement;

import java.util.List;

/**
 * Section 7.13
 */
public class Rpc extends AbstractStatement {
    private Description description;
    private List<Grouping> groupingList;
    private List<IfFeature> ifFeatureList;
    private Input input;
    private Output output;
    private Reference reference;
    private Status status;
    private List<Typedef> typedefList;

    @Override
    public <T extends Statement> void append(T s) throws SyntaxException, NullPointerException {
        notNull(s);
        if (s instanceof Description) {
            description = notDuplicate(description, (Description) s);
        } else if (s instanceof Grouping) {
            groupingList = nullThenNew(groupingList, (Grouping) s);
        } else if (s instanceof IfFeature) {
            ifFeatureList = nullThenNew(ifFeatureList, (IfFeature) s);
        } else if (s instanceof Input) {
            input = notDuplicate(input, (Input) s);
        } else if (s instanceof Output) {
            output = notDuplicate(output, (Output) s);
        } else if (s instanceof Reference) {
            reference = notDuplicate(reference, (Reference) s);
        } else if (s instanceof Status) {
            status = notDuplicate(status, (Status) s);
        } else if (s instanceof Typedef) {
            typedefList = nullThenNew(typedefList, (Typedef) s);
        } else {
            notNull(s);
        }
    }

    public Description getDescription() {
        return description;
    }

    public Rpc setDescription(Description description) {
        this.description = description;
        return this;
    }

    public List<Grouping> getGroupingList() {
        return groupingList;
    }

    public Rpc setGroupingList(List<Grouping> groupingList) {
        this.groupingList = groupingList;
        return this;
    }

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public Rpc setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
        return this;
    }

    public Input getInput() {
        return input;
    }

    public Rpc setInput(Input input) {
        this.input = input;
        return this;
    }

    public Output getOutput() {
        return output;
    }

    public Rpc setOutput(Output output) {
        this.output = output;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Rpc setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Rpc setStatus(Status status) {
        this.status = status;
        return this;
    }

    public List<Typedef> getTypedefList() {
        return typedefList;
    }

    public Rpc setTypedefList(List<Typedef> typedefList) {
        this.typedefList = typedefList;
        return this;
    }
}
