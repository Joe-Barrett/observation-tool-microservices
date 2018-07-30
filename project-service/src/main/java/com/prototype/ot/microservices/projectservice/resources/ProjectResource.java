package com.prototype.ot.microservices.projectservice.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.prototype.ot.microservices.projectservice.model.*;
import com.prototype.ot.microservices.projectservice.services.ProjectService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@RestController
public class ProjectResource {

    private ProjectService projectService;
    private ObjectMapper objectMapper;

    public ProjectResource() {
        this.projectService = new ProjectService();
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
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
            return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(this.objectMapper.writeValueAsString(projectList));
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping("/project")
    public ResponseEntity getProject(@RequestParam(value = "entityRef") String entityRef) {
        try {
            ObsProject foundProject = this.projectService.getProject(entityRef);
            return ResponseEntity.status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.objectMapper.writeValueAsString(foundProject));
//            return ResponseEntity.ok(this.objectMapper.writeValueAsString(foundProject));
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @PutMapping(path = "/project")
    public ResponseEntity putProject(@RequestBody ObsProject project) {
        System.out.println(project.getObsProjectEntity().getEntityId());
        return ResponseEntity.ok(project.getObsProjectEntity().getEntityId());
    }

    @GetMapping(path = "/proposal")
    public ResponseEntity getProposal(@RequestParam(value = "entityRef") String entityRef) {
        try {
            ObsProposal foundProposal = this.projectService.getProposal(entityRef);
            return ResponseEntity.ok(this.objectMapper.writeValueAsString(foundProposal));
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @PutMapping(path = "/proposal")
    public ResponseEntity putProposal(@RequestBody ObsProposal proposal) {
        try {
            proposal.setTitle("No, I say test");
            Marshaller marshaller;
            JAXBContext context = JAXBContext.newInstance(ObsProposal.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(proposal, writer);
            this.projectService.saveProposal(proposal);
            return ResponseEntity.ok(this.objectMapper.writeValueAsString(proposal));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(path = "/schema")
    public ResponseEntity makeSchema() {
        try {
            JsonSchemaGenerator schemaGenerator = new JsonSchemaGenerator(this.objectMapper);
            JsonSchema schema = schemaGenerator.generateSchema(ObsProposal.class);
            return ResponseEntity.ok(this.objectMapper.writeValueAsString(schema));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping(path = "/new")
    public ResponseEntity newProject() {
        try {
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
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.objectMapper.writeValueAsString(newProject));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
