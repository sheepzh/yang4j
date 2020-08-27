package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.5
 */
public class Container extends BaseAppendableStatement {
    private List<Anyxml> anyxmlList;
    private List<Choice> choiceList;
    private Config config;
    private List<Container> containerList;
    private Description description;
    private List<Grouping> groupingList;
    private List<IfFeature> ifFeatureList;
    private List<Leaf> leafList;
    private List<LeafList> leafListList;
    private List<ListS> listS;
    private List<Must> mustList;
    private Presence presence;
    private Reference reference;
    private Status status;
    private List<Typedef> typedefList;
    private List<Uses> usesList;
    private When when;

    public List<Anyxml> getAnyxmlList() {
        return anyxmlList;
    }

    public Container setAnyxmlList(List<Anyxml> anyxmlList) {
        this.anyxmlList = anyxmlList;
        return this;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public Container setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
        return this;
    }

    public Config getConfig() {
        return config;
    }

    public Container setConfig(Config config) {
        this.config = config;
        return this;
    }

    public List<Container> getContainerList() {
        return containerList;
    }

    public Container setContainerList(List<Container> containerList) {
        this.containerList = containerList;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public Container setDescription(Description description) {
        this.description = description;
        return this;
    }

    public List<Grouping> getGroupingList() {
        return groupingList;
    }

    public Container setGroupingList(List<Grouping> groupingList) {
        this.groupingList = groupingList;
        return this;
    }

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public Container setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
        return this;
    }

    public List<Leaf> getLeafList() {
        return leafList;
    }

    public Container setLeafList(List<Leaf> leafList) {
        this.leafList = leafList;
        return this;
    }

    public List<LeafList> getLeafListList() {
        return leafListList;
    }

    public Container setLeafListList(List<LeafList> leafListList) {
        this.leafListList = leafListList;
        return this;
    }

    public List<ListS> getListS() {
        return listS;
    }

    public Container setListS(List<ListS> listS) {
        this.listS = listS;
        return this;
    }

    public List<Must> getMustList() {
        return mustList;
    }

    public Container setMustList(List<Must> mustList) {
        this.mustList = mustList;
        return this;
    }

    public Presence getPresence() {
        return presence;
    }

    public Container setPresence(Presence presence) {
        this.presence = presence;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Container setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Container setStatus(Status status) {
        this.status = status;
        return this;
    }

    public List<Typedef> getTypedefList() {
        return typedefList;
    }

    public Container setTypedefList(List<Typedef> typedefList) {
        this.typedefList = typedefList;
        return this;
    }

    public List<Uses> getUsesList() {
        return usesList;
    }

    public Container setUsesList(List<Uses> usesList) {
        this.usesList = usesList;
        return this;
    }

    public When getWhen() {
        return when;
    }

    public Container setWhen(When when) {
        this.when = when;
        return this;
    }
}
