package com.prototype.ot.microservices.projectservice.model.project;

public class ProjectListItem {

    private String
            prj_projectName,
            prj_pI,
            prj_code,
            prj_timeOfCreation,
            projectRef,
            proposalRef;

    public ProjectListItem() {

    }

    public ProjectListItem(String prj_projectName,
                           String prj_pI,
                           String prj_code,
                           String prj_timeOfCreation,
                           String projectId,
                           String proposalId) {
        this.prj_projectName = prj_projectName;
        this.prj_pI = prj_pI;
        this.prj_code = prj_code;
        this.prj_timeOfCreation = prj_timeOfCreation;
        this.projectRef = projectId;
        this.proposalRef = proposalId;
    }

    public String getPrj_projectName() {
        return prj_projectName;
    }

    public void setPrj_projectName(String prj_projectName) {
        this.prj_projectName = prj_projectName;
    }

    public String getPrj_pI() {
        return prj_pI;
    }

    public void setPrj_pI(String prj_pI) {
        this.prj_pI = prj_pI;
    }

    public String getPrj_code() {
        return prj_code;
    }

    public void setPrj_code(String prj_code) {
        this.prj_code = prj_code;
    }

    public String getPrj_timeOfCreation() {
        return prj_timeOfCreation;
    }

    public void setPrj_timeOfCreation(String prj_timeOfCreation) {
        this.prj_timeOfCreation = prj_timeOfCreation;
    }

    public String getProjectRef() {
        return projectRef;
    }

    public void setProjectRef(String projectRef) {
        this.projectRef = projectRef;
    }

    public String getProposalRef() {
        return proposalRef;
    }

    public void setProposalRef(String proposalRef) {
        this.proposalRef = proposalRef;
    }
}
