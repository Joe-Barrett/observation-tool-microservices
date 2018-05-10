package com.prototype.ot.microservices.projectservice.model.project;

import com.prototype.ot.microservices.projectservice.model.AlmaInvestigator;

import java.util.Date;

public class ObsProposal {

    private ObsDocEntity prp_ObsProposalEntity;
    private DocRef prp_ObsProjectRef;
    private String
            prp_title,
            prp_abstract,
            prp_relatedProposals,
            prp_cycle,
            prp_recentPublications,
            prp_scientificCategoryCode,
            prp_scientificCategoryString,
            prp_proposalTypeString,
            prp_resubmittedProjectCode,
            prp_duplicateObservationJustification;
    private Date prp_dateReceived;
    private boolean
            prp_studentProject,
            prp_continuation,
            prp_isResubmission;
    private String
            prp_keyword,
            prp_keywordCode;
    private AlmaInvestigator prp_PrincipalInvestigator;
    private AlmaInvestigator[]
            prp_coPrincipalInvestigators,
            prp_coInvestigators;

    public ObsDocEntity getPrp_ObsProposalEntity() {
        return prp_ObsProposalEntity;
    }

    public void setPrp_ObsProposalEntity(ObsDocEntity prp_ObsProposalEntity) {
        this.prp_ObsProposalEntity = prp_ObsProposalEntity;
    }

    public DocRef getPrp_ObsProjectRef() {
        return prp_ObsProjectRef;
    }

    public void setPrp_ObsProjectRef(DocRef prp_ObsProjectRef) {
        this.prp_ObsProjectRef = prp_ObsProjectRef;
    }

    public String getPrp_title() {
        return prp_title;
    }

    public void setPrp_title(String prp_title) {
        this.prp_title = prp_title;
    }

    public String getPrp_abstract() {
        return prp_abstract;
    }

    public void setPrp_abstract(String prp_abstract) {
        this.prp_abstract = prp_abstract;
    }

    public String getPrp_relatedProposals() {
        return prp_relatedProposals;
    }

    public void setPrp_relatedProposals(String prp_relatedProposals) {
        this.prp_relatedProposals = prp_relatedProposals;
    }

    public String getPrp_cycle() {
        return prp_cycle;
    }

    public void setPrp_cycle(String prp_cycle) {
        this.prp_cycle = prp_cycle;
    }

    public String getPrp_recentPublications() {
        return prp_recentPublications;
    }

    public void setPrp_recentPublications(String prp_recentPublications) {
        this.prp_recentPublications = prp_recentPublications;
    }

    public String getPrp_scientificCategoryCode() {
        return prp_scientificCategoryCode;
    }

    public void setPrp_scientificCategoryCode(String prp_scientificCategoryCode) {
        this.prp_scientificCategoryCode = prp_scientificCategoryCode;
    }

    public String getPrp_scientificCategoryString() {
        return prp_scientificCategoryString;
    }

    public void setPrp_scientificCategoryString(String prp_scientificCategoryString) {
        this.prp_scientificCategoryString = prp_scientificCategoryString;
    }

    public String getPrp_proposalTypeString() {
        return prp_proposalTypeString;
    }

    public void setPrp_proposalTypeString(String prp_proposalTypeString) {
        this.prp_proposalTypeString = prp_proposalTypeString;
    }

    public String getPrp_resubmittedProjectCode() {
        return prp_resubmittedProjectCode;
    }

    public void setPrp_resubmittedProjectCode(String prp_resubmittedProjectCode) {
        this.prp_resubmittedProjectCode = prp_resubmittedProjectCode;
    }

    public String getPrp_duplicateObservationJustification() {
        return prp_duplicateObservationJustification;
    }

    public void setPrp_duplicateObservationJustification(String prp_duplicateObservationJustification) {
        this.prp_duplicateObservationJustification = prp_duplicateObservationJustification;
    }

    public Date getPrp_dateReceived() {
        return prp_dateReceived;
    }

    public void setPrp_dateReceived(Date prp_dateReceived) {
        this.prp_dateReceived = prp_dateReceived;
    }

    public boolean isPrp_studentProject() {
        return prp_studentProject;
    }

    public void setPrp_studentProject(boolean prp_studentProject) {
        this.prp_studentProject = prp_studentProject;
    }

    public boolean isPrp_continuation() {
        return prp_continuation;
    }

    public void setPrp_continuation(boolean prp_continuation) {
        this.prp_continuation = prp_continuation;
    }

    public boolean isPrp_isResubmission() {
        return prp_isResubmission;
    }

    public void setPrp_isResubmission(boolean prp_isResubmission) {
        this.prp_isResubmission = prp_isResubmission;
    }

    public String getPrp_keyword() {
        return prp_keyword;
    }

    public void setPrp_keyword(String prp_keyword) {
        this.prp_keyword = prp_keyword;
    }

    public String getPrp_keywordCode() {
        return prp_keywordCode;
    }

    public void setPrp_keywordCode(String prp_keywordCode) {
        this.prp_keywordCode = prp_keywordCode;
    }

    public AlmaInvestigator getPrp_PrincipalInvestigator() {
        return prp_PrincipalInvestigator;
    }

    public void setPrp_PrincipalInvestigator(AlmaInvestigator prp_PrincipalInvestigator) {
        this.prp_PrincipalInvestigator = prp_PrincipalInvestigator;
    }

    public AlmaInvestigator[] getPrp_coPrincipalInvestigators() {
        return prp_coPrincipalInvestigators;
    }

    public void setPrp_coPrincipalInvestigators(AlmaInvestigator[] prp_coPrincipalInvestigators) {
        this.prp_coPrincipalInvestigators = prp_coPrincipalInvestigators;
    }

    public AlmaInvestigator[] getPrp_coInvestigators() {
        return prp_coInvestigators;
    }

    public void setPrp_coInvestigators(AlmaInvestigator[] prp_coInvestigators) {
        this.prp_coInvestigators = prp_coInvestigators;
    }
}
