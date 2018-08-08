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

package com.prototype.ot.microservices.projectservice.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.prototype.ot.microservices.projectservice.model.ObsProject;
import com.prototype.ot.microservices.projectservice.model.ObsProposal;
import com.prototype.ot.microservices.projectservice.model.ProjectListItem;
import com.prototype.ot.microservices.projectservice.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@Resource
public class ProjectResource {

    private ProjectService projectService;
    private ObjectMapper objectMapper;

    @Autowired
    public ProjectResource(ProjectService projectService) {
        this.projectService = projectService;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @GetMapping(path = "/list")
    public ResponseEntity getProjectList() {
        try {
            List<ProjectListItem> projectList = this.projectService.getProjectList();
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.objectMapper.writeValueAsString(projectList));
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity newProject() {
        try {
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.objectMapper.writeValueAsString(this.projectService.createNewProject()));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/project")
    public ResponseEntity getProject(@RequestParam(value = "entityRef") String entityRef) {
        try {
            ObsProject foundProject = this.projectService.getProject(entityRef);
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.objectMapper.writeValueAsString(foundProject));
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @PutMapping(path = "/project")
    public ResponseEntity putProject(@RequestBody ObsProject project) {
        try {
            ObsProject verified = this.projectService.putProject(project);
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.objectMapper.writeValueAsString(verified));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(path = "/proposal")
    public ResponseEntity getProposal(@RequestParam(value = "entityRef") String entityRef) {
        try {
            ObsProposal foundProposal = this.projectService.getProposal(entityRef);
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.objectMapper.writeValueAsString(foundProposal));
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @PutMapping(path = "/proposal")
    public ResponseEntity putProposal(@RequestBody ObsProposal proposal) {
        try {
            ObsProposal validated = this.projectService.putProposal(proposal);
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.objectMapper.writeValueAsString(validated));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping(path = "/science-goal")
    public ResponseEntity putScienceGoal(@RequestParam String entityRef) {
        try {
            ObsProposal addedGoal = this.projectService.addScienceGoal(entityRef);
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.objectMapper.writeValueAsString(addedGoal));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
