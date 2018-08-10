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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *
 */
@Service
public class ProjectService {

    private Map<String, ProjectListItem> projectList;
    private MessageService messageService;

    /**
     * Constructor
     *
     * @param messageService Injected service for handling inter-service messages
     * @throws JAXBException From createProjectList, issue with marshaling
     * @throws IOException   From createProjectList, file reading
     */
    @Autowired
    public ProjectService(MessageService messageService) throws JAXBException, IOException {
        this.messageService = messageService;
        this.createProjectList();
    }

    /**
     * Checks if the project list is present and creates if not
     *
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    private void checkProjectList() throws JAXBException, IOException {
        if (this.projectList == null) {
            createProjectList();
        }
    }

    /**
     * Creates a list of all projects available and stores locally
     *
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    private void createProjectList() throws JAXBException, IOException {
        this.projectList = new HashMap<>();
        File folder = new File(FileUtilities.PROJECT_DIRECTORY);
        ObsProject project;
        ProjectListItem listItem;
        for (File f : Objects.requireNonNull(folder.listFiles())) {
            if (!f.isDirectory() && f.getName().substring(f.getName().lastIndexOf(".") + 1).equals("aot")) {
                project = FileUtilities.loadResourceFromFilepath(f.getAbsolutePath(),
                                                                 FileUtilities.PROJECT_XML,
                                                                 ObsProject.class);
                listItem = listItemFromProject(project);
                this.projectList.put(f.getName(), listItem);
            }
        }
    }

    /**
     * Returns the list of values from projectList
     *
     * @return List of project list items
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public List<ProjectListItem> getProjectList() throws JAXBException, IOException {
        checkProjectList();
        return new ArrayList<>(this.projectList.values());
    }

    /**
     * Creates a new project with proposal and saves to an AOT file
     *
     * @return the newly created project
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public ObsProject createNewProject() throws JAXBException, IOException {
        checkProjectList();
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
    public ObsProject getProject(String projectRef) throws IOException, JAXBException {
        checkProjectList();
        for (String filename : this.projectList.keySet()) {
            if (projectRef.equals(this.projectList.get(filename).getObsProjectEntityId())) {
                return FileUtilities.loadResourceFromFilepath(FileUtilities.PROJECT_DIRECTORY + filename,
                                                              FileUtilities.PROJECT_XML,
                                                              ObsProject.class);
            }
        }
        return null;
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
        checkProjectList();
        this.persistChanges(project);
        this.messageService.sendMessage("project-update-queue", project.getObsProjectEntity().getEntityId());
        return project;
    }

    public void deleteProject(String projectRef) throws IOException {
        String matchFilename = "";
        for (String filename : projectList.keySet()) {
            if (projectRef.equals(projectList.get(filename).getObsProjectEntityId())) {
                matchFilename = filename;
                break;
            }
        }
        if (matchFilename.equals("")) {
            throw new FileNotFoundException("Could not find matching project file");
        }
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
        checkProjectList();
        for (String filename : this.projectList.keySet()) {
            if (proposalRef.equals(this.projectList.get(filename).getObsProposalEntityId())) {
                return FileUtilities.loadResourceFromFilepath(FileUtilities.PROJECT_DIRECTORY + filename,
                                                              FileUtilities.PROPOSAL_XML,
                                                              ObsProposal.class);
            }
        }
        return null;
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
        checkProjectList();
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
     * @throws JAXBException From marshalling
     */
    public ObsProposal removeSource(String proposalRef, int goalIndex, int sourceIndex) throws IOException,
            JAXBException {
        ObsProposal proposal = this.getProposal(proposalRef);
        ((ScienceGoalT) proposal.getScienceGoals().get(goalIndex)).removeSource(sourceIndex);
        persistChanges(proposal);
        return proposal;
    }

    /**
     * Creates a project list item from a project
     *
     * @param project The project to create the list item from
     * @return The new list item
     */
    private static ProjectListItem listItemFromProject(ObsProject project) {
        return new ProjectListItem(project.getProjectName(),
                                   project.getPI(),
                                   project.getCode(),
                                   project.getTimeOfCreation(),
                                   project.getObsProjectEntity().getEntityId(),
                                   project.getObsProposalRef().getEntityId());
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
        ObsProject project = null;
        for (String filename : this.projectList.keySet()) {
            if (proposal.getObsProposalEntity().getEntityId().equals(this.projectList.get(filename).getObsProposalEntityId())) {
                project = FileUtilities.loadResourceFromFilepath(FileUtilities.PROJECT_DIRECTORY + filename,
                                                                 FileUtilities.PROJECT_XML,
                                                                 ObsProject.class);
                break;
            }
        }
        return project;
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
        for (String filename : this.projectList.keySet()) {
            if (project.getObsProjectEntity().getEntityId().equals(this.projectList.get(filename).getObsProjectEntityId())) {
                proposal = FileUtilities.loadResourceFromFilepath(FileUtilities.PROJECT_DIRECTORY + filename,
                                                                  FileUtilities.PROPOSAL_XML,
                                                                  ObsProposal.class);
            }
        }
        return proposal;
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
        // Find filename
        String matchingFilename = "";
        for (String filename : this.projectList.keySet()) {
            if (project.getObsProjectEntity().getEntityId().equals(this.projectList.get(filename).getObsProjectEntityId()) &&
                    proposal.getObsProposalEntity().getEntityId().equals(this.projectList.get(filename).getObsProposalEntityId())) {
                matchingFilename = filename;
                break;
            }
        }
        if (!matchingFilename.equals("")) {
            this.persistChanges(project, proposal, matchingFilename.substring(0, matchingFilename.lastIndexOf(".")));
        } else {
            FileUtilities.saveAotFile(project, proposal);
            this.projectList.put(project.getObsProjectEntity().getEntityId() + FileUtilities.FILE_EXTENSION,
                                 listItemFromProject(project));
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


}
