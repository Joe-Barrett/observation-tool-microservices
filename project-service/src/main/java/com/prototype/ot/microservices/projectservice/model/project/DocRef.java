package com.prototype.ot.microservices.projectservice.model.project;

public class DocRef {
    private String entityTypeName;
    private String entityId;
    private float documentVersion;

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        this.entityTypeName = entityTypeName;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public float getDocumentVersion() {
        return documentVersion;
    }

    public void setDocumentVersion(float documentVersion) {
        this.documentVersion = documentVersion;
    }
}
