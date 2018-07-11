package com.prototype.ot.microservices.projectservice.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import com.google.gson.Gson;
import com.prototype.ot.microservices.projectservice.model.ObsProject;
import com.prototype.ot.microservices.projectservice.model.ObsProposal;
import com.prototype.ot.microservices.projectservice.model.ProjectListItem;
import com.prototype.ot.microservices.projectservice.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/list")
    public ResponseEntity getProjectList() {
        try {
            List<ProjectListItem> projectList = this.projectService.getProjectList();
            return ResponseEntity.ok(projectList);
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/project")
    public ResponseEntity getProject(@RequestParam(value = "projectRef") String projectRef) {
        try {
            ObsProject foundProject = this.projectService.getProject(projectRef);
            return ResponseEntity.ok(new Gson().toJson(foundProject));
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/proposal")
    public ResponseEntity getProposal(@RequestParam(value = "proposalRef", required = false) String proposalRef) {
        try {
            ObsProposal foundProposal = this.projectService.getProposal(proposalRef);
            ObjectMapper mapper = new ObjectMapper();
            AnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
            mapper.setAnnotationIntrospector(introspector);
            return ResponseEntity.ok(mapper.writeValueAsString(foundProposal));
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/schema")
    public ResponseEntity makeSchema() {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            JsonSchemaGenerator schemaGenerator = new JsonSchemaGenerator(mapper);
            JsonSchema schema = schemaGenerator.generateSchema(ObsProposal.class);
            return ResponseEntity.ok(mapper.writeValueAsString(schema));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping(path = "/proposal")
    public ResponseEntity putProposal(@RequestBody String proposal) {
        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        try {
            ObsProposal obsProposal = mapper.readValue(proposal, ObsProposal.class);
            System.out.println(obsProposal.getCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

}
