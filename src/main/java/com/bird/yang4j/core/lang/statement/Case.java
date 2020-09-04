package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.AbstractStatement;

import java.util.List;

public class Case extends AbstractStatement {
    private List<Anyxml> anyxmlList;
    private List<Choice> choiceList;
    private List<Container> containerList;
    private Description description;
    private List<IfFeature> ifFeatureList;
    private List<Leaf> leafList;
    private List<LeafList> leafListList;
    private List<ListS> listList;
    private Reference reference;
    private Status status;
    private List<Uses> usesList;
    private When when;

    public List<Anyxml> getAnyxmlList() {
        return anyxmlList;
    }

    public Case setAnyxmlList(List<Anyxml> anyxmlList) {
        this.anyxmlList = anyxmlList;
        return this;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public Case setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
        return this;
    }

    public List<Container> getContainerList() {
        return containerList;
    }

    public Case setContainerList(List<Container> containerList) {
        this.containerList = containerList;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public Case setDescription(Description description) {
        this.description = description;
        return this;
    }

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public Case setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
        return this;
    }

    public List<Leaf> getLeafList() {
        return leafList;
    }

    public Case setLeafList(List<Leaf> leafList) {
        this.leafList = leafList;
        return this;
    }

    public List<LeafList> getLeafListList() {
        return leafListList;
    }

    public Case setLeafListList(List<LeafList> leafListList) {
        this.leafListList = leafListList;
        return this;
    }

    public List<ListS> getListList() {
        return listList;
    }

    public Case setListList(List<ListS> listList) {
        this.listList = listList;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Case setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Case setStatus(Status status) {
        this.status = status;
        return this;
    }

    public List<Uses> getUsesList() {
        return usesList;
    }

    public Case setUsesList(List<Uses> usesList) {
        this.usesList = usesList;
        return this;
    }

    public When getWhen() {
        return when;
    }

    public Case setWhen(When when) {
        this.when = when;
        return this;
    }
}
