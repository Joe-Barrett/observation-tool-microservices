package com.prototype.ot.microservices.projectservice.model.project;

public class ObsUnitControl {

    private String arrayRequested;
    private int
            userPriority,
            tacPriority,
            aggregatedExecutionCount;

    public String getArrayRequested() {
        return arrayRequested;
    }

    public void setArrayRequested(String arrayRequested) {
        this.arrayRequested = arrayRequested;
    }

    public int getUserPriority() {
        return userPriority;
    }

    public void setUserPriority(int userPriority) {
        this.userPriority = userPriority;
    }

    public int getTacPriority() {
        return tacPriority;
    }

    public void setTacPriority(int tacPriority) {
        this.tacPriority = tacPriority;
    }

    public int getAggregatedExecutionCount() {
        return aggregatedExecutionCount;
    }

    public void setAggregatedExecutionCount(int aggregatedExecutionCount) {
        this.aggregatedExecutionCount = aggregatedExecutionCount;
    }
}
