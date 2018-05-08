package com.prototype.ot.microservices.projectservice.model.project;

public class ObsPlan {

    private String
            name,
            note;
    private boolean runSciencePipeline;
    private ObsUnitControl ObsUnitControl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isRunSciencePipeline() {
        return runSciencePipeline;
    }

    public void setRunSciencePipeline(boolean runSciencePipeline) {
        this.runSciencePipeline = runSciencePipeline;
    }

    public ObsUnitControl getObsUnitControl() {
        return ObsUnitControl;
    }

    public void setObsUnitControl(ObsUnitControl obsUnitControl) {
        ObsUnitControl = obsUnitControl;
    }
}
