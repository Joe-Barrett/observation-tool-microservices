package com.prototype.ot.microservices.projectservice.resources;

import com.prototype.ot.microservices.projectservice.model.project.ObsProject;
import com.prototype.ot.microservices.projectservice.model.project.ObsProposal;
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
            List<ObsProject> projects = this.projectService.getAllProjects();
            return ResponseEntity.ok(projects);
        } catch (IOException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/project")
    public ResponseEntity getProject(@RequestParam(value = "projectRef") String projectRef) {
        try {
            ObsProject foundProject = this.projectService.getProject(projectRef);
            return ResponseEntity.ok(foundProject);
        } catch (IOException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/proposal")
    public ResponseEntity getProposal(@RequestParam(value = "proposalRef", required = false) String proposalRef) {
        try {
            ObsProposal foundProposal = this.projectService.getProposal(proposalRef);
            return ResponseEntity.ok(foundProposal);
        } catch (IOException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

}
