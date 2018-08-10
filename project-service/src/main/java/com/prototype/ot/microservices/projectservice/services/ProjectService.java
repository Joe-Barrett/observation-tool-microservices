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
import com.prototype.ot.microservices.projectservice.utilities.FileUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ProjectService {

    private Map<String, ProjectListItem> projectList;
    private MessageService messageService;

    @Autowired
    public ProjectService(MessageService messageService) throws JAXBException, IOException {
        this.messageService = messageService;
        this.createProjectList();
    }

    private void checkProjectList() throws JAXBException, IOException {
        if (this.projectList == null) {
            createProjectList();
        }
    }

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

    public List<ProjectListItem> getProjectList() throws IOException, JAXBException {
        checkProjectList();
        return new ArrayList<>(this.projectList.values());
    }

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

    public ObsProject putProject(ObsProject project) throws JAXBException, IOException {
        checkProjectList();
        ObsProposal proposal = null;
        String foundFilename = "";
        for (String filename : this.projectList.keySet()) {
            if (project.getObsProjectEntity().getEntityId().equals(this.projectList.get(filename).getObsProjectEntityId())) {
                proposal = FileUtilities.loadResourceFromFilepath(FileUtilities.PROJECT_DIRECTORY + filename,
                                                                  FileUtilities.PROPOSAL_XML,
                                                                  ObsProposal.class);
                foundFilename = filename;
                break;
            }
        }
        FileUtilities.saveAotFile(project, proposal, foundFilename.substring(0, foundFilename.lastIndexOf(".")));
        this.projectList.put(foundFilename, listItemFromProject(project));
        this.messageService.sendMessage("project-update-queue", project.getObsProjectEntity().getEntityId());
        return project;
    }

    public ObsProject createNewProject() throws JAXBException, IOException {
        checkProjectList();
        // Create new ObsProject
        ObsProject newProject = new ObsProject();
        // Create ObsProgram
        // Create ObsProposal
        ObsProposal newProposal = new ObsProposal();
        // Set ObsProgram in project
        // Set ObsProposal in Project
        newProject.setObsProposal(newProposal);
        // Set ObsProject in Proposal
        newProposal.setObsProject(newProject);
        FileUtilities.saveAotFile(newProject, newProposal);
        this.projectList.put(newProject.getObsProjectEntity().getEntityId() + FileUtilities.FILE_EXTENSION,
                             listItemFromProject(newProject));
        return newProject;
    }

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

    public ObsProposal putProposal(ObsProposal proposal) throws JAXBException, IOException {
        checkProjectList();
        ObsProject project = this.getMatchingProject(proposal);
        String foundFilename = this.getFilename(project);
        FileUtilities.saveAotFile(project, proposal, foundFilename.substring(0, foundFilename.lastIndexOf(".")));
        this.projectList.put(foundFilename, listItemFromProject(project));
        return proposal;
    }

    public ObsProposal addScienceGoal(String proposalRef) throws IOException, JAXBException {
        ObsProposal proposal = this.getProposal(proposalRef);
        proposal.addScienceGoal();
        ObsProject project = this.getMatchingProject(proposal);
        String foundFilename = this.getFilename(project);
        FileUtilities.saveAotFile(project, proposal, foundFilename.substring(0, foundFilename.lastIndexOf(".")));
        return proposal;
    }

    public ObsProposal removeScienceGoal(String proposalRef, int index) throws IOException, JAXBException {
        ObsProposal proposal = this.getProposal(proposalRef);
        proposal.removeScienceGoal(index);
        ObsProject project = this.getMatchingProject(proposal);
        String foundFilename = this.getFilename(project);
        FileUtilities.saveAotFile(project, proposal, foundFilename.substring(0, foundFilename.lastIndexOf(".")));
        return proposal;
    }

    private static ProjectListItem listItemFromProject(ObsProject project) {
        return new ProjectListItem(project.getProjectName(),
                                   project.getPI(),
                                   project.getCode(),
                                   project.getTimeOfCreation(),
                                   project.getObsProjectEntity().getEntityId(),
                                   project.getObsProposalRef().getEntityId());
    }

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

    private String getFilename(ObsProject project) {
        for (String filename: this.projectList.keySet()) {
            if (project.getObsProjectEntity().getEntityId().equals(this.projectList.get(filename).getObsProjectEntityId()))
                return filename;
        }
        throw new NullPointerException("Could not find matching file");
    }

}
