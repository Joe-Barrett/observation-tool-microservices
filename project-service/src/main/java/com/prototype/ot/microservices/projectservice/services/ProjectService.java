package com.prototype.ot.microservices.projectservice.services;

import com.prototype.ot.microservices.projectservice.model.ObsProject;
import com.prototype.ot.microservices.projectservice.model.ObsProposal;
import com.prototype.ot.microservices.projectservice.model.ProjectListItem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.xml.bind.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class ProjectService {

    public ProjectService() {

    }

    public List<ObsProject> getAllProjects() throws IOException, JAXBException {
        return this.loadResourceList("ObsProject.xml", ObsProject.class);
    }

    public List<ProjectListItem> getProjectList() throws IOException, JAXBException {
        List<ObsProject> projects = this.getAllProjects();
        List<ProjectListItem> projectList = new ArrayList<>();
        ProjectListItem projectListItem;
        for (ObsProject project : projects) {
            projectListItem = new ProjectListItem(project.getProjectName(),
                                                  project.getPI(),
                                                  project.getCode(),
                                                  project.getTimeOfCreation(),
                                                  project.getObsProjectEntity().getEntityId(),
                                                  project.getObsProposalRef().getEntityId());
            projectList.add(projectListItem);
        }
        return projectList;
    }

    public ObsProject getProject(String projectRef) throws IOException, JAXBException {
        List<ObsProject> projects = this.loadResourceList("ObsProject.xml", ObsProject.class);
        for (ObsProject project : projects) {
            if (project.getObsProjectEntity().getEntityId().equals(projectRef)) {
                return project;
            }
        }
        return null;
    }

    public List<ObsProposal> getAllProposals() throws IOException, JAXBException {
        return this.loadResourceList("ObsProposal.xml", ObsProposal.class);
    }

    public ObsProposal getProposal(String proposalRef) throws IOException, JAXBException {
        List<ObsProposal> proposals = this.loadResourceList("ObsProposal.xml", ObsProposal.class);
        for (ObsProposal obsProposal : proposals) {
            if (obsProposal.getObsProposalEntity().getEntityId().equals(proposalRef)) {
                return obsProposal;
            }
        }
        return null;
    }

    public void saveProposal(ObsProposal proposal) throws JAXBException, IOException {
        // Find corresponding project
        ObsProject project = null;
        List<ObsProject> projects = this.getAllProjects();
        for (ObsProject proj: projects) {
            if (proj.getObsProposalRef().getEntityId().equals(proposal.getObsProposalEntity().getEntityId())) {
                project = proj;
                break;
            }
        }
        // Convert both to xml strings
        Marshaller marshaller;
        JAXBContext context = JAXBContext.newInstance(ObsProject.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(project, writer);
        String projectXml = writer.toString();
        context = JAXBContext.newInstance(ObsProposal.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        writer = new StringWriter();
        marshaller.marshal(proposal, writer);
        String proposalXml = writer.toString();
        // Convert to bytes
        byte[] projBytes = projectXml.getBytes(StandardCharsets.UTF_8);
        byte[] propBytes = proposalXml.getBytes(StandardCharsets.UTF_8);
        // Put into zip entry
        OutputStream out = new FileOutputStream("/data/test.aot");
        final ZipSupport.ZipWriter zipWriter = new ZipSupport.ZipWriter(out);
        zipWriter.putZipEntry("ObsProject.xml", projBytes);
        zipWriter.putZipEntry("ObsProposal.xml", propBytes);
        // Close entry
        zipWriter.close();
    }

    public void updateProposal(ObsProposal proposal) {
        System.out.println("ProjectService, updateProposal");
        JSONObject object = new JSONObject(proposal);
        String xml = XML.toString(object);
        System.out.println(xml);
    }

    public ObsProject updateProject(String projectCode, ObsProject project) {
        return null;
    }

    public ObsProject createProject(ObsProject project) {
        return project;
    }

    public void deleteProject(String projectCode) {

    }

    private String stripTags(String raw) {
        return raw
                .replace("prj:", "")
                .replace("prp:", "")
                .replace("val:", "");
    }

    private static JSONObject switchColons(JSONObject original) {
        JSONObject toReturn = new JSONObject();
        Iterator<String> keys = original.keys();
        while (keys.hasNext()) {
            String oldKey = keys.next();
            String newKey = oldKey.replace(':', '_');
            if (original.get(oldKey) instanceof JSONObject) {
                toReturn.put(newKey, switchColons(original.getJSONObject(oldKey)));
            } else if (original.get(oldKey) instanceof JSONArray) {
                toReturn.put(newKey, switchColonsArray(original.getJSONArray(oldKey)));
            } else {
                toReturn.put(newKey, original.get(oldKey));
            }
        }
        return toReturn;
    }

    private static JSONArray switchColonsArray(JSONArray array) {
        JSONArray toReturn = new JSONArray();
        for (int i = 0; i < array.length(); i++) {
            if (array.get(i) instanceof JSONObject) {
                toReturn.put(switchColons(array.getJSONObject(i)));
            } else {
                toReturn.put(array.get(i));
            }
        }
        return toReturn;
    }

    private <T> List<T> loadResourceList(String filename, Class<T> cls) throws IOException, JAXBException {
        List<T> returnList = new ArrayList<>();
        ClassLoader cl = this.getClass().getClassLoader();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(cl);
        Resource[] resources = resourcePatternResolver.getResources("classpath*:/projects/real-projects/*.aot");
        ZipSupport.ZipReader zipReader;
        ZipSupport.ZipNtry entry;
        String xml;
        for (Resource f : resources) {
            zipReader = new ZipSupport.ZipReader(f.getInputStream());
            entry = zipReader.getZipEntry();
            while (!entry.toString().equals(filename)) {
                entry = zipReader.getZipEntry();
            }
            xml = new String(entry.getData(), StandardCharsets.UTF_8);
            JAXBContext jaxbContext = JAXBContext.newInstance("com.prototype.ot.microservices.projectservice.model");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader stringReader = new StringReader(xml);
            JAXBElement<T> element = (JAXBElement<T>) unmarshaller.unmarshal(stringReader);
            returnList.add(cls.cast(element.getValue()));
        }
        return returnList;
    }

}