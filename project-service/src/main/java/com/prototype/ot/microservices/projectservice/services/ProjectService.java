package com.prototype.ot.microservices.projectservice.services;

import com.prototype.ot.microservices.projectservice.model.ObsProject;
import com.prototype.ot.microservices.projectservice.model.ObsProposal;
import com.prototype.ot.microservices.projectservice.model.ProjectListItem;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ProjectService {

    private Map<String, ProjectListItem> projectList;
    private final static String PROJECT_DIRECTORY = "/data/projects/";
    private final static String PROJECT_XML = "ObsProject.xml";
    private final static String PROPOSAL_XML = "ObsProposal.xml";
    private final static String FILE_EXTENSION = ".aot";


    public ProjectService() {

    }

    private void createProjectList() throws JAXBException, IOException {
        this.projectList = new HashMap<>();
        File folder = new File(PROJECT_DIRECTORY);
        ObsProject project;
        ProjectListItem listItem;
        for (File f : Objects.requireNonNull(folder.listFiles())) {
            if (!f.isDirectory() && f.getName().substring(f.getName().lastIndexOf(".") + 1).equals("aot")) {
                project = loadResourceFromFilepath(f.getAbsolutePath(), PROJECT_XML, ObsProject.class);
                listItem = listItemFromProject(project);
                this.projectList.put(f.getName(), listItem);
            }
        }
    }

    public List<ProjectListItem> getProjectList() throws IOException, JAXBException {
        if (this.projectList == null) {
            createProjectList();
        }
        return new ArrayList<>(this.projectList.values());
    }

    public ObsProject getProject(String projectRef) throws IOException, JAXBException {
        if (this.projectList == null) {
            createProjectList();
        }
        for (String filename:this.projectList.keySet()) {
            if (projectRef.equals(this.projectList.get(filename).getObsProjectEntityId())) {
                return loadResourceFromFilepath(PROJECT_DIRECTORY+filename, PROJECT_XML, ObsProject.class);
            }
        }
        return null;
    }

    public ObsProject putProject(ObsProject project) {
        return project;
    }

    public ObsProject createNewProject() throws JAXBException, IOException {
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
        saveAotFile(newProject, newProposal);
        if (this.projectList == null) {
            this.createProjectList();
        }
//        this.projectList.add(listItemFromProject(newProject));
        return newProject;
    }

    public ObsProposal getProposal(String proposalRef) throws IOException, JAXBException {
        if (this.projectList == null) {
            createProjectList();
        }
        for (String filename:this.projectList.keySet()) {
            if (proposalRef.equals(this.projectList.get(filename).getObsProposalEntityId())) {
                return loadResourceFromFilepath(PROJECT_DIRECTORY+filename, PROPOSAL_XML, ObsProposal.class);
            }
        }
        return null;
    }

    public ObsProposal putProposal(ObsProposal proposal) throws JAXBException, IOException {
        ObsProject project = null;
        for (String filename : this.projectList.keySet()) {
            if (proposal.getObsProposalEntity().getEntityId().equals(this.projectList.get(filename).getObsProposalEntityId())) {
                project = loadResourceFromFilepath(PROJECT_DIRECTORY + filename, PROJECT_XML, ObsProject.class);
                break;
            }
        }
        saveAotFile(project, proposal);
        return proposal;
    }

    public void deleteProject(String projectCode) {

    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> loadResourceList(String filename, Class<T> cls) throws IOException, JAXBException {
        List<T> returnList = new ArrayList<>();
        File folder = new File(PROJECT_DIRECTORY);
        ZipSupport.ZipReader zipReader;
        ZipSupport.ZipNtry entry;
        String xml;
        JAXBContext jaxbContext = JAXBContext.newInstance(cls);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        for (File f : Objects.requireNonNull(folder.listFiles())) {
            if (!f.isDirectory() && f.getName().substring(f.getName().lastIndexOf(".")).equals(FILE_EXTENSION)) {
                zipReader = new ZipSupport.ZipReader(new FileInputStream(f));
                entry = zipReader.getZipEntry();
                while (!entry.toString().equals(filename)) {
                    entry = zipReader.getZipEntry();
                }
                xml = new String(entry.getData(), StandardCharsets.UTF_8);
                T element = (T) unmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
                if (element instanceof JAXBElement) {
                    returnList.add(cls.cast(((JAXBElement) element).getValue()));
                } else {
                    returnList.add(element);
                }
            }
        }
        return returnList;
    }

//    private <T> T loadResourceFromId(String entityId, Class<T> cls) {
//
//    }

    @SuppressWarnings("unchecked")
    private <T> T loadResourceFromFilepath(String filepath, String fileType, Class<T> cls) throws JAXBException, IOException {
        File file = new File(filepath);
        ZipSupport.ZipReader zipReader;
        ZipSupport.ZipNtry entry;
        String xml;
        JAXBContext jaxbContext = JAXBContext.newInstance(cls);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        zipReader = new ZipSupport.ZipReader(new FileInputStream(file));
        entry = zipReader.getZipEntry();
        while (!entry.toString().equals(fileType)) {
            entry = zipReader.getZipEntry();
        }
        xml = new String(entry.getData(), StandardCharsets.UTF_8);
        T element = (T) unmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
        if (element instanceof JAXBElement) {
            return cls.cast(((JAXBElement) element).getValue());
        } else {
            return element;
        }
    }

    private static void saveAotFile(ObsProject project, ObsProposal proposal) throws JAXBException, IOException {
        saveAotFile(project, proposal, project.getObsProjectEntity().getEntityId());
    }

    private static void saveAotFile(ObsProject project, ObsProposal proposal, String fileName) throws JAXBException,
            IOException {
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
        OutputStream out = new FileOutputStream("/data/projects/" + fileName + ".aot");
        final ZipSupport.ZipWriter zipWriter = new ZipSupport.ZipWriter(out);
        zipWriter.putZipEntry("ObsProject.xml", projBytes);
        zipWriter.putZipEntry("ObsProposal.xml", propBytes);
        // Close entry
        zipWriter.close();
    }

    private static ProjectListItem listItemFromProject(ObsProject project) {
        return new ProjectListItem(project.getProjectName(),
                                   project.getPI(),
                                   project.getCode(),
                                   project.getTimeOfCreation(),
                                   project.getObsProjectEntity().getEntityId(),
                                   project.getObsProposalRef().getEntityId());
    }

}
