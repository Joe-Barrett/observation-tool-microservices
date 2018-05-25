package com.prototype.ot.microservices.projectservice.model;

public class ProjectListItem {

    private String
            projectName,
            pI,
            code,
            timeOfCreation,
            obsProjectEntityId,
            obsProposalEntityId;

    public ProjectListItem(String projectName,
                           String pI,
                           String code,
                           String timeOfCreation,
                           String obsProjectEntityId,
                           String obsProposalEntityId) {
        this.projectName = projectName;
        this.pI = pI;
        this.code = code;
        this.timeOfCreation = timeOfCreation;
        this.obsProjectEntityId = obsProjectEntityId;
        this.obsProposalEntityId = obsProposalEntityId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getpI() {
        return pI;
    }

    public void setpI(String pI) {
        this.pI = pI;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(String timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public String getObsProjectEntityId() {
        return obsProjectEntityId;
    }

    public void setObsProjectEntityId(String obsProjectEntityId) {
        this.obsProjectEntityId = obsProjectEntityId;
    }

    public String getObsProposalEntityId() {
        return obsProposalEntityId;
    }

    public void setObsProposalEntityId(String obsProposalEntityId) {
        this.obsProposalEntityId = obsProposalEntityId;
    }

}
