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

    public ObsProject createNewProject() throws JAXBException, IOException {
        checkProjectList();
        ObsProject newProject = new ObsProject();
        ObsProposal newProposal = new ObsProposal();
        newProject.setObsProposal(newProposal);
        newProposal.setObsProject(newProject);
        persistChanges(newProject, newProposal);
        return newProject;
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
        this.persistChanges(project);
        this.projectList.put(getFilename(project), listItemFromProject(project));
        this.messageService.sendMessage("project-update-queue", project.getObsProjectEntity().getEntityId());
        return project;
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
        persistChanges(proposal);
        return proposal;
    }

    public ObsProposal addScienceGoal(String proposalRef) throws IOException, JAXBException {
        ObsProposal proposal = this.getProposal(proposalRef);
        proposal.addScienceGoal();
        persistChanges(proposal);
        return proposal;
    }

    public ObsProposal removeScienceGoal(String proposalRef, int index) throws IOException, JAXBException {
        ObsProposal proposal = this.getProposal(proposalRef);
        proposal.removeScienceGoal(index);
        persistChanges(proposal);
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
        for (String filename : this.projectList.keySet()) {
            if (project.getObsProjectEntity().getEntityId().equals(this.projectList.get(filename).getObsProjectEntityId()))
                return filename;
        }
        throw new NullPointerException("Could not find matching file");
    }

    private void persistChanges(ObsProject project) throws JAXBException, IOException {
        ObsProposal proposal = this.getMatchingProposal(project);
        this.persistChanges(project, proposal);
    }

    private void persistChanges(ObsProposal proposal) throws JAXBException, IOException {
        ObsProject project = this.getMatchingProject(proposal);
        this.persistChanges(project, proposal);
    }

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
     * The master method when all 3 are present
     *
     * @param project
     * @param proposal
     * @param filename
     * @throws JAXBException
     * @throws IOException
     */
    private void persistChanges(ObsProject project, ObsProposal proposal, String filename) throws JAXBException, IOException {
        FileUtilities.saveAotFile(project, proposal, filename);
    }


}
