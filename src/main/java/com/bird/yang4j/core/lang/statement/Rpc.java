package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.13
 */
public class Rpc extends BaseAppendableStatement {
    private Description description;
    private List<Grouping> groupingList;
    private List<IfFeature> ifFeatureList;
    private Input input;
    private Output output;
    private Reference reference;
    private Status status;
    private List<Typedef> typedefList;

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
