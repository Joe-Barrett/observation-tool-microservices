package com.prototype.ot.microservices.projectservice.model.project;

public class ObsProject {
    private ObsDocEntity prj_ObsProjectEntity;
    private DocRef prj_ObsProposalRef;
    private ObsProgram prj_ObsProgram;
    private String
            prj_status,
            prj_projectName,
            prj_pI,
            prj_version,
            prj_code,
            prj_timeOfCreation,
            prj_letterGrade,
            prj_staffProjectNote,
            prj_taPhase2Comments,
            prj_consensusReport,
            prj_p2gAttentionReasons;
    private float
            prj_revision;
    private boolean
            prj_manualMode,
            prj_simulationMode,
            prj_isComissioning,
            prj_isCalibration,
            prj_p2gAttention;

    public ObsProgram getPrj_ObsProgram() {
        return prj_ObsProgram;
    }

    public void setPrj_ObsProgram(ObsProgram prj_ObsProgram) {
        this.prj_ObsProgram = prj_ObsProgram;
    }

    public String getPrj_status() {
        return prj_status;
    }

    public void setPrj_status(String prj_status) {
        this.prj_status = prj_status;
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

    public String getPrj_version() {
        return prj_version;
    }

    public void setPrj_version(String prj_version) {
        this.prj_version = prj_version;
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

    public String getPrj_letterGrade() {
        return prj_letterGrade;
    }

    public void setPrj_letterGrade(String prj_letterGrade) {
        this.prj_letterGrade = prj_letterGrade;
    }

    public String getPrj_staffProjectNote() {
        return prj_staffProjectNote;
    }

    public void setPrj_staffProjectNote(String prj_staffProjectNote) {
        this.prj_staffProjectNote = prj_staffProjectNote;
    }

    public String getPrj_taPhase2Comments() {
        return prj_taPhase2Comments;
    }

    public void setPrj_taPhase2Comments(String prj_taPhase2Comments) {
        this.prj_taPhase2Comments = prj_taPhase2Comments;
    }

    public String getPrj_consensusReport() {
        return prj_consensusReport;
    }

    public void setPrj_consensusReport(String prj_consensusReport) {
        this.prj_consensusReport = prj_consensusReport;
    }

    public String getPrj_p2gAttentionReasons() {
        return prj_p2gAttentionReasons;
    }

    public void setPrj_p2gAttentionReasons(String prj_p2gAttentionReasons) {
        this.prj_p2gAttentionReasons = prj_p2gAttentionReasons;
    }

    public float getPrj_revision() {
        return prj_revision;
    }

    public void setPrj_revision(float prj_revision) {
        this.prj_revision = prj_revision;
    }

    public boolean isPrj_manualMode() {
        return prj_manualMode;
    }

    public void setPrj_manualMode(boolean prj_manualMode) {
        this.prj_manualMode = prj_manualMode;
    }

    public boolean isPrj_simulationMode() {
        return prj_simulationMode;
    }

    public void setPrj_simulationMode(boolean prj_simulationMode) {
        this.prj_simulationMode = prj_simulationMode;
    }

    public boolean isPrj_isComissioning() {
        return prj_isComissioning;
    }

    public void setPrj_isComissioning(boolean prj_isComissioning) {
        this.prj_isComissioning = prj_isComissioning;
    }

    public boolean isPrj_isCalibration() {
        return prj_isCalibration;
    }

    public void setPrj_isCalibration(boolean prj_isCalibration) {
        this.prj_isCalibration = prj_isCalibration;
    }

    public boolean isPrj_p2gAttention() {
        return prj_p2gAttention;
    }

    public void setPrj_p2gAttention(boolean prj_p2gAttention) {
        this.prj_p2gAttention = prj_p2gAttention;
    }

    public DocRef getPrj_ObsProposalRef() {
        return prj_ObsProposalRef;
    }

    public void setPrj_ObsProposalRef(DocRef prj_ObsProposalRef) {
        this.prj_ObsProposalRef = prj_ObsProposalRef;
    }

    public ObsDocEntity getPrj_ObsProjectEntity() {
        return prj_ObsProjectEntity;
    }

    public void setPrj_ObsProjectEntity(ObsDocEntity prj_ObsProjectEntity) {
        this.prj_ObsProjectEntity = prj_ObsProjectEntity;
    }
}
