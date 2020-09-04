package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;
import com.bird.yang4j.core.SyntaxException;

import java.util.List;

/**
 * Section 7.1
 */
public class Module extends BaseAppendableStatement {

    /**
     * Mustn't be null
     */
    private Namespace namespace;
    /**
     * Must't be null
     */
    private Prefix prefix;

    private List<Anyxml> anyxmlList;
    private List<Augment> augments;
    private List<Choice> choiceList;
    private Contact contact;
    private List<Container> containerList;
    private Description description;
    private List<Deviation> deviationList;
    private List<Extension> extensionList;
    private List<Feature> featureList;
    private List<Grouping> groupingList;
    private List<Identity> identityList;
    private List<Import> importList;
    private List<Include> includeList;
    private List<Leaf> leaves;
    private List<LeafList> leafListList;
    private List<ListS> listList;
    private List<Notification> notificationList;
    private Organization organization;
    private Reference reference;
    private List<Revision> revisionList;
    private List<Rpc> rpc;
    private List<Typedef> typedefList;
    private List<Uses> usesList;

    @Override
    public void assertChild() throws SyntaxException {
        super.assertChild();
        required(namespace, Namespace.class);
        required(prefix, Prefix.class);
    }

    public Namespace getNamespace() {
        return namespace;
    }

    public Module setNamespace(Namespace namespace) {
        this.namespace = namespace;
        return this;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public Module setPrefix(Prefix prefix) {
        this.prefix = prefix;
        return this;
    }

    public List<Anyxml> getAnyxmlList() {
        return anyxmlList;
    }

    public Module setAnyxmlList(List<Anyxml> anyxmlList) {
        this.anyxmlList = anyxmlList;
        return this;
    }

    public List<Augment> getAugments() {
        return augments;
    }

    public Module setAugments(List<Augment> augments) {
        this.augments = augments;
        return this;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public Module setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
        return this;
    }

    public Contact getContact() {
        return contact;
    }

    public Module setContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    public List<Container> getContainerList() {
        return containerList;
    }

    public Module setContainerList(List<Container> containerList) {
        this.containerList = containerList;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public Module setDescription(Description description) {
        this.description = description;
        return this;
    }

    public List<Deviation> getDeviationList() {
        return deviationList;
    }

    public Module setDeviationList(List<Deviation> deviationList) {
        this.deviationList = deviationList;
        return this;
    }

    public List<Extension> getExtensionList() {
        return extensionList;
    }

    public Module setExtensionList(List<Extension> extensionList) {
        this.extensionList = extensionList;
        return this;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public Module setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
        return this;
    }

    public List<Grouping> getGroupingList() {
        return groupingList;
    }

    public Module setGroupingList(List<Grouping> groupingList) {
        this.groupingList = groupingList;
        return this;
    }

    public List<Identity> getIdentityList() {
        return identityList;
    }

    public Module setIdentityList(List<Identity> identityList) {
        this.identityList = identityList;
        return this;
    }

    public List<Import> getImportList() {
        return importList;
    }

    public Module setImportList(List<Import> importList) {
        this.importList = importList;
        return this;
    }

    public List<Include> getIncludeList() {
        return includeList;
    }

    public Module setIncludeList(List<Include> includeList) {
        this.includeList = includeList;
        return this;
    }

    public List<Leaf> getLeaves() {
        return leaves;
    }

    public Module setLeaves(List<Leaf> leaves) {
        this.leaves = leaves;
        return this;
    }

    public List<LeafList> getLeafListList() {
        return leafListList;
    }

    public Module setLeafListList(List<LeafList> leafListList) {
        this.leafListList = leafListList;
        return this;
    }

    public List<ListS> getListList() {
        return listList;
    }

    public Module setListList(List<ListS> listList) {
        this.listList = listList;
        return this;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public Module setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
        return this;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Module setOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Module setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public List<Revision> getRevisionList() {
        return revisionList;
    }

    public Module setRevisionList(List<Revision> revisionList) {
        this.revisionList = revisionList;
        return this;
    }

    public List<Rpc> getRpc() {
        return rpc;
    }

    public Module setRpc(List<Rpc> rpc) {
        this.rpc = rpc;
        return this;
    }

    public List<Typedef> getTypedefList() {
        return typedefList;
    }

    public Module setTypedefList(List<Typedef> typedefList) {
        this.typedefList = typedefList;
        return this;
    }

    public List<Uses> getUsesList() {
        return usesList;
    }

    public Module setUsesList(List<Uses> usesList) {
        this.usesList = usesList;
        return this;
    }
}
