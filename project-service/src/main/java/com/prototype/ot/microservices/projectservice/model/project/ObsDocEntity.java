package com.prototype.ot.microservices.projectservice.model.project;

public class ObsDocEntity extends DocRef {
    private String entityIdEncrypted;

    public String getEntityIdEncrypted() {
        return entityIdEncrypted;
    }

    public void setEntityIdEncrypted(String entityIdEncrypted) {
        this.entityIdEncrypted = entityIdEncrypted;
    }
}
