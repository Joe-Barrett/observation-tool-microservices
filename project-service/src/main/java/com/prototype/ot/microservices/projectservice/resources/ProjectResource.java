package com.prototype.ot.microservices.projectservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectResource {

    private ProjectService projectService;

    public ProjectResource() {
        this.projectService = new ProjectService();
    }

    public ResponseEntity getAllProjects() {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity getProposal(String proposalRef) {
        return ResponseEntity.ok().build();
    }

}
