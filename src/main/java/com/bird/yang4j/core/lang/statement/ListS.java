package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.BaseAppendableStatement;
import com.bird.yang4j.core.lang.Statement;
import com.bird.yang4j.core.lang.annotation.AliasFor;

import java.util.List;

/**
 * Section 7.8
 */
@AliasFor("list")
public class ListS extends BaseAppendableStatement {
    private Key key;
    private List<Anyxml> anyxmlList;
    private List<Choice> choices;
    private Config config;
    private List<Container> containerList;
    private Description description;
    private List<Grouping> groupingList;
    private List<IfFeature> ifFeatureList;
    private List<Leaf> leafList;
    private List<LeafList> leafListList;
    private List<ListS> listList;
    private MaxElements maxElements;
    private MinElements minElements;
    private List<Must> mustList;
    private OrderedBy orderedBy;
    private Reference reference;
    private Status status;
    private List<Typedef> typedef;
    private List<Unique> uniqueList;

    @Override
    public void assertChild() throws SyntaxException {
        super.assertChild();
        if (key != null) {
            String keyName = key.getArgumentJava();
            String keyNotFoundMsg = "The key '%s' is not found in those leaves of list '%s'!";
            if (leafList == null
                    || leafList.isEmpty()
                    || leafList.stream().map(Statement::getArgument).noneMatch(keyName::equals)
            ) {
                throw new SyntaxException(keyNotFoundMsg, keyName, argument);
            }
        }
    }

    public List<Anyxml> getAnyxmlList() {
        return anyxmlList;
    }

    public ListS setAnyxmlList(List<Anyxml> anyxmlList) {
        this.anyxmlList = anyxmlList;
        return this;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public ListS setChoices(List<Choice> choices) {
        this.choices = choices;
        return this;
    }

    public Config getConfig() {
        return config;
    }

    public ListS setConfig(Config config) {
        this.config = config;
        return this;
    }

    public List<Container> getContainerList() {
        return containerList;
    }

    public ListS setContainerList(List<Container> containerList) {
        this.containerList = containerList;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public ListS setDescription(Description description) {
        this.description = description;
        return this;
    }

    public List<Grouping> getGroupingList() {
        return groupingList;
    }

    public ListS setGroupingList(List<Grouping> groupingList) {
        this.groupingList = groupingList;
        return this;
    }

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public ListS setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
        return this;
    }

    public Key getKey() {
        return key;
    }

    public ListS setKey(Key key) {
        this.key = key;
        return this;
    }

    public List<Leaf> getLeafList() {
        return leafList;
    }

    public ListS setLeafList(List<Leaf> leafList) {
        this.leafList = leafList;
        return this;
    }

    public List<LeafList> getLeafListList() {
        return leafListList;
    }

    public ListS setLeafListList(List<LeafList> leafListList) {
        this.leafListList = leafListList;
        return this;
    }

    public List<ListS> getListList() {
        return listList;
    }

    public ListS setListList(List<ListS> listList) {
        this.listList = listList;
        return this;
    }

    public MaxElements getMaxElements() {
        return maxElements;
    }

    public ListS setMaxElements(MaxElements maxElements) {
        this.maxElements = maxElements;
        return this;
    }

    public MinElements getMinElements() {
        return minElements;
    }

    public ListS setMinElements(MinElements minElements) {
        this.minElements = minElements;
        return this;
    }

    public List<Must> getMustList() {
        return mustList;
    }

    public ListS setMustList(List<Must> mustList) {
        this.mustList = mustList;
        return this;
    }

    public OrderedBy getOrderedBy() {
        return orderedBy;
    }

    public ListS setOrderedBy(OrderedBy orderedBy) {
        this.orderedBy = orderedBy;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public ListS setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public ListS setStatus(Status status) {
        this.status = status;
        return this;
    }

    public List<Typedef> getTypedef() {
        return typedef;
    }

    public ListS setTypedef(List<Typedef> typedef) {
        this.typedef = typedef;
        return this;
    }

    public List<Unique> getUniqueList() {
        return uniqueList;
    }

    public ListS setUniqueList(List<Unique> uniqueList) {
        this.uniqueList = uniqueList;
        return this;
    }
}
