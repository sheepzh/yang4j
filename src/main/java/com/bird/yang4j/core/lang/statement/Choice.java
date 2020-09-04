package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.9
 */
public class Choice extends BaseAppendableStatement {
    private List<Anyxml> anyxmlList;
    private List<Case> caseLists;
    private Config config;
    private List<Container> containerList;
    private Default aDefault;
    private Description description;
    private List<IfFeature> ifFeatureList;
    private List<Leaf> leafList;
    private List<LeafList> leafListList;
    private List<ListS> listList;
    private Mandatory mandatory;
    private Reference reference;
    private Status status;
    private When when;

    public List<Anyxml> getAnyxmlList() {
        return anyxmlList;
    }

    public Choice setAnyxmlList(List<Anyxml> anyxmlList) {
        this.anyxmlList = anyxmlList;
        return this;
    }

    public List<Case> getCaseLists() {
        return caseLists;
    }

    public Choice setCaseLists(List<Case> caseLists) {
        this.caseLists = caseLists;
        return this;
    }

    public Config getConfig() {
        return config;
    }

    public Choice setConfig(Config config) {
        this.config = config;
        return this;
    }

    public List<Container> getContainerList() {
        return containerList;
    }

    public Choice setContainerList(List<Container> containerList) {
        this.containerList = containerList;
        return this;
    }

    public Default getaDefault() {
        return aDefault;
    }

    public Choice setaDefault(Default aDefault) {
        this.aDefault = aDefault;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public Choice setDescription(Description description) {
        this.description = description;
        return this;
    }

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public Choice setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
        return this;
    }

    public List<Leaf> getLeafList() {
        return leafList;
    }

    public Choice setLeafList(List<Leaf> leafList) {
        this.leafList = leafList;
        return this;
    }

    public List<LeafList> getLeafListList() {
        return leafListList;
    }

    public Choice setLeafListList(List<LeafList> leafListList) {
        this.leafListList = leafListList;
        return this;
    }

    public List<ListS> getListList() {
        return listList;
    }

    public Choice setListList(List<ListS> listList) {
        this.listList = listList;
        return this;
    }

    public Mandatory getMandatory() {
        return mandatory;
    }

    public Choice setMandatory(Mandatory mandatory) {
        this.mandatory = mandatory;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Choice setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Choice setStatus(Status status) {
        this.status = status;
        return this;
    }

    public When getWhen() {
        return when;
    }

    public Choice setWhen(When when) {
        this.when = when;
        return this;
    }
}
