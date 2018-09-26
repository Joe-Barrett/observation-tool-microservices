/*
 * ALMA - Atacama Large Millimeter Array
 * Copyright (c) UKATC - UK Astronomy Technology Centre, Science and Technology Facilities Council, 2018
 * (in the framework of the ALMA collaboration).
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA
 */

package com.prototype.ot.microservices.projectservice.services;

import com.prototype.ot.microservices.projectservice.model.ObsProject;
import com.prototype.ot.microservices.projectservice.model.ObsProposal;
import com.prototype.ot.microservices.projectservice.model.ProjectListItem;
import com.prototype.ot.microservices.projectservice.model.ScienceGoalT;
import com.prototype.ot.microservices.projectservice.utilities.FileUtilities;
import com.prototype.ot.microservices.projectservice.utilities.ProjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Methods to support the project API defined in ProjectResource.
 */
@Service
public class ProjectService {

    private ProjectList projectList = new ProjectList();
    private MessageService messageService;

    /**
     * Constructor
     *
     * @param messageService Injected service for handling inter-service messages
     */
    @Autowired
    public ProjectService(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Creates a new project with proposal and saves to an AOT file
     *
     * @return the newly created project
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ObsProject createNewProject() throws JAXBException, IOException {
        this.projectList.checkProjectList();
        ObsProject newProject = new ObsProject();
        ObsProposal newProposal = new ObsProposal();
        newProject.setObsProposal(newProposal);
        newProposal.setObsProject(newProject);
        persistChanges(newProject, newProposal);
        return newProject;
    }

    /**
     * Gets a stored project from the server
     *
     * @param projectRef The entity id of the project to retrieve
     * @return The found project
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ObsProject getProject(String projectRef) throws JAXBException, IOException{
       String filename =  this.projectList.getFilenameFromProjectID(projectRef);
       return FileUtilities.loadResourceFromFilepath(FileUtilities.PROJECT_DIRECTORY + filename,
                                                              FileUtilities.PROJECT_XML,
                                                              ObsProject.class);
    }

    /**
     * Puts a project onto the server, used when a project is updated
     *
     * @param project The project to store
     * @return The same project following validation and checks
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ObsProject putProject(ObsProject project) throws JAXBException, IOException {
        projectList.checkProjectList();
        this.persistChanges(project);
        generateSBsProject(project.getObsProjectEntity().getEntityId());
        return project;
    }

    /**
     * Generate the Scheduling Blocks for a saved project
     *
     * @param projectRef The ID of project for which the SBs are being generated
     * @return The same project following validation and checks
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ProjectListItem generateSBsProject(String projectRef) throws JAXBException, IOException {
        projectList.checkProjectList();
        String fileToUpdate = projectList.getFilenameFromProjectID(projectRef);
        this.messageService.sendMessage("project-update-queue", fileToUpdate);
        return projectList.get(fileToUpdate);
    }

    public void deleteProject(String projectRef) throws IOException {
        String matchFilename =  projectList.getFilenameFromProjectID(projectRef);
        FileUtilities.deleteFile(matchFilename);
    }

    /**
     * Gets a stored proposal from the server
     *
     * @param proposalRef The entity id of the proposal to retrieve
     * @return The found proposal
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ObsProposal getProposal(String proposalRef) throws IOException, JAXBException {
        String filename = projectList.getFilenameFromProposalID(proposalRef);
        return FileUtilities.loadResourceFromFilepath(FileUtilities.PROJECT_DIRECTORY + filename,
                                                          FileUtilities.PROPOSAL_XML,
                                                          ObsProposal.class);
    }

    /**
     * Puts a proposal onto the server, used when a proposal is updated
     *
     * @param proposal The proposal to store
     * @return The same proposal following validation and checks
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ObsProposal putProposal(ObsProposal proposal) throws JAXBException, IOException {
        projectList.checkProjectList();
        persistChanges(proposal);
        return proposal;
    }

    /**
     * Adds a new science goal to the identified proposal
     *
     * @param proposalRef The entity id of the proposal to add a science goal to
     * @return The proposal with science goal added
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ObsProposal addScienceGoal(String proposalRef) throws IOException, JAXBException {
        ObsProposal proposal = this.getProposal(proposalRef);
        proposal.addScienceGoal();
        persistChanges(proposal);
        return proposal;
    }

    /**
     * Removes a science goal from the identified proposal at the given index
     *
     * @param proposalRef The entity id of the proposal to remove the science goal from
     * @param index       The index of the science goal to remove
     * @return The proposal with science goal removed
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ObsProposal removeScienceGoal(String proposalRef, int index) throws IOException, JAXBException {
        ObsProposal proposal = this.getProposal(proposalRef);
        proposal.removeScienceGoal(index);
        persistChanges(proposal);
        return proposal;
    }

    /**
     * Adds a new source to the given proposal and science goal
     *
     * @param proposalRef The entity id of the proposal to work with
     * @param goalIndex   The index of the science goal to add a source to
     * @return The proposal with source added
     * @throws IOException   From file reading
     * @throws JAXBException From marshalling
     */
    public ObsProposal addSource(String proposalRef, int goalIndex) throws IOException, JAXBException {
        ObsProposal proposal = this.getProposal(proposalRef);
        ((ScienceGoalT) proposal.getScienceGoals().get(goalIndex)).addSource();
        persistChanges(proposal);
        return proposal;
    }

    /**
     * Removes a source at the given index from the given proposal and science goal
     * 
     * @param proposalRef The entity id of the proposal to work with
     * @param goalIndex The index of the science goal to remove the source from
     * @param sourceIndex The index of the source to remove
     * @return The proposal with source removed
     * @throws IOException From file reading
     */
    public ObsProposal removeSource(String proposalRef, int goalIndex, int sourceIndex) throws IOException,
            JAXBException {
        ObsProposal proposal = this.getProposal(proposalRef);
        ((ScienceGoalT) proposal.getScienceGoals().get(goalIndex)).removeSource(sourceIndex);
        persistChanges(proposal);
        return proposal;
    }

    /**
     * Finds the matching project to a given proposal
     *
     * @param proposal The proposal to match with
     * @return The matching project
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    private ObsProject getMatchingProject(ObsProposal proposal) throws JAXBException, IOException {
        String proposalRef  = proposal.getObsProposalEntity().getEntityId();
        String filename = this.projectList.getFilenameFromProposalID(proposalRef);
        return  FileUtilities.loadResourceFromFilepath(FileUtilities.PROJECT_DIRECTORY + filename,
                                                                 FileUtilities.PROJECT_XML,
                                                                 ObsProject.class);
    }

    /**
     * Finds a matching proposal from a given project
     *
     * @param project The project to match with
     * @return The found proposal
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    private ObsProposal getMatchingProposal(ObsProject project) throws JAXBException, IOException {
        ObsProposal proposal = null;
        String projectRef  = project.getObsProjectEntity().getEntityId();
        String filename = this.projectList.getFilenameFromProjectID(projectRef);
        return FileUtilities.loadResourceFromFilepath(FileUtilities.PROJECT_DIRECTORY + filename,
                    FileUtilities.PROPOSAL_XML,
                    ObsProposal.class);
    }

    /**
     * Persists changes made to a project, this finds the matching proposal and saves to an AOT
     *
     * @param project The project to persist
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    private void persistChanges(ObsProject project) throws JAXBException, IOException {
        ObsProposal proposal = this.getMatchingProposal(project);
        this.persistChanges(project, proposal);
    }

    /**
     * Persists changes made to a proposal, this finds the matching project and saves to an AOT
     *
     * @param proposal The proposal to persist
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    private void persistChanges(ObsProposal proposal) throws JAXBException, IOException {
        ObsProject project = this.getMatchingProject(proposal);
        this.persistChanges(project, proposal);
    }

    /**
     * Persists a project and proposal without having to find either
     *
     * @param project  The project to persist
     * @param proposal The proposal to persist
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    private void persistChanges(ObsProject project, ObsProposal proposal) throws JAXBException, IOException {

        String projectRef = project.getObsProjectEntity().getEntityId();
        String proposalRef = proposal.getObsProposalEntity().getEntityId();

        // Find filename
        String matchingFilename = this.projectList.getMatchingFilename(proposalRef, projectRef);


        if (!matchingFilename.equals("")) {
            this.persistChanges(project, proposal, matchingFilename.substring(0, matchingFilename.lastIndexOf(".")));
        } else {
            FileUtilities.saveAotFile(project, proposal);
            this.projectList.addProjectToList(project);
        }
    }

    /**
     * Persists a project and proposal under the given filename
     *
     * @param project  The project to persist
     * @param proposal The proposal to persist
     * @param filename The filename to save them under (excluding extension)
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    private void persistChanges(ObsProject project, ObsProposal proposal, String filename) throws JAXBException, IOException {
        FileUtilities.saveAotFile(project, proposal, filename);
    }

    /**
     * Returns a list of all the available projects
     *
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ArrayList<ProjectListItem> getProjectList() throws IOException, JAXBException{
        return this.projectList.getProjectList();
    }
}
