package com.prototype.ot.microservices.projectservice.resources;

import com.prototype.ot.microservices.projectservice.model.project.ObsProject;
import com.prototype.ot.microservices.projectservice.model.project.ObsProposal;
import com.prototype.ot.microservices.projectservice.model.project.ProjectListItem;
import com.prototype.ot.microservices.projectservice.services.ProjectService;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ProjectResource {

    private ProjectService projectService;

    public ProjectResource() {
        this.projectService = new ProjectService();
    }

    @GetMapping
    public ResponseEntity getAllProjects() {
        try {
            List<JSONObject> projects = this.projectService.getAllProjects();
            return ResponseEntity.ok(projects.toString());
        } catch (IOException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/list")
    public ResponseEntity getProjectList() {
        try {
            List<ProjectListItem> projectList = this.projectService.getProjectList();
            return ResponseEntity.ok(projectList);
        } catch (IOException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/project")
    public ResponseEntity getProject(@RequestParam(value = "projectRef") String projectRef) {
        try {
            JSONObject foundProject = this.projectService.getProject(projectRef);
            return ResponseEntity.ok(foundProject.toString());
        } catch (IOException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/proposal")
    public ResponseEntity getProposal(@RequestParam(value = "proposalRef", required = false) String proposalRef) {
        try {
            JSONObject foundProposal = this.projectService.getProposal(proposalRef);
            return ResponseEntity.ok(foundProposal.toString());
        } catch (IOException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

}
