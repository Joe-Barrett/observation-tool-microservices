package com.prototype.ot.microservices.projectservice.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.prototype.ot.microservices.projectservice.model.ObsProject;
import com.prototype.ot.microservices.projectservice.model.ObsProposal;
import com.prototype.ot.microservices.projectservice.model.ProjectListItem;
import com.prototype.ot.microservices.projectservice.services.ProjectService;
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

    @GetMapping("/project")
    public ResponseEntity getProject(@RequestParam(value = "projectRef") String projectRef) {
        try {
            ObsProject foundProject = this.projectService.getProject(projectRef);
            ObjectMapper mapper = new ObjectMapper();
            return ResponseEntity.ok(mapper.writeValueAsString(foundProject));
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
    public ResponseEntity getProposal(@RequestParam(value = "proposalRef", required = false) String proposalRef) {
        try {
            ObsProposal foundProposal = this.projectService.getProposal(proposalRef);
            ObjectMapper mapper = new ObjectMapper();
            return ResponseEntity.ok(mapper.writeValueAsString(foundProposal));
        } catch (IOException | JAXBException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @PutMapping(path = "/proposal")
    public ResponseEntity putProposal(@RequestBody ObsProposal proposal) {
        try {
            proposal.setTitle("Edited by server");
            Marshaller marshaller;
            JAXBContext context = JAXBContext.newInstance(ObsProposal.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            PrintWriter out = new PrintWriter("/data/test.xml");
            marshaller.marshal(proposal, writer);
            out.println(writer.toString());
            out.close();
            this.projectService.saveProposal(proposal);
            return ResponseEntity.ok(writer.toString());
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
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

}
