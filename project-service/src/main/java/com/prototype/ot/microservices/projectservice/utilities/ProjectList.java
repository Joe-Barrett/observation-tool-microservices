package com.prototype.ot.microservices.projectservice.utilities;

import com.prototype.ot.microservices.projectservice.model.ObsProject;
import com.prototype.ot.microservices.projectservice.model.ProjectListItem;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * How the internal list of available projects used by the ProjectService is
 * stored and accessed.
 *
 * Separated out because it may be useful to share this with other services
 * at some stage.
 *
 * @see com.prototype.ot.microservices.projectservice.services.ProjectService
 */
public class ProjectList {

    private Map<String, ProjectListItem> projectList;

    /**
     * Checks if the project list is present and creates if not
     *
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
    public void checkProjectList() throws JAXBException, IOException {
        if (this.projectList == null) {
            createProjectList();
        }
    }

    public ArrayList<ProjectListItem> getProjectList() throws JAXBException, IOException {
        checkProjectList();
        return new ArrayList<>(this.projectList.values());
    }

    /**
     * Return the filename of the first project on the list with both a matching proposal
     * and project ID
     *
     * If none is found then an empty string is returned.
     *
     * @param projectRef  - the entity ID for the project
     * @param proposalRef  - the entity ID for the proposal
     *
     */
    public String getMatchingFilename(String proposalRef, String projectRef)  {

        for (String filename : this.projectList.keySet()) {
            if (projectRef.equals(this.projectList.get(filename).getObsProjectEntityId()) &&
                    proposalRef.equals(this.projectList.get(filename).getObsProposalEntityId())) {
                return filename;
            }
        }
        return "";
    }

    public ProjectListItem get(String filename) {
        return this.projectList.get(filename);
    }


    /**
     * Return the filename of the first project on the list with a matching  project ID
     * If none is found then a FileNotFound exception is thrown.
     *
     * @param projectRef  - the entity ID for the project
     *
     * @exception FileNotFoundException - no matching file was found.
     *
     */
    public String getFilenameFromProjectID(String projectRef) throws FileNotFoundException {
        try{
            checkProjectList();
            for (String filename : this.projectList.keySet()) {

                String currentId = this.projectList.get(filename).getObsProjectEntityId();
                String result = "fname : " + filename + ", inputRef : " + projectRef + " , currentId "+currentId;
                System.out.println(result);

                if (projectRef.equals(currentId)) {
                    return filename;
                }
            }
        }catch (JAXBException | IOException e) {
            throw new FileNotFoundException("Error looking for project file" + e.getMessage());
        }
        throw new FileNotFoundException("Could not find matching project file");
    }

    /**
     * Return the filename of the first project on the list with a matching proposalID
     * If none is found then a FileNotFound exception is thrown.
     *
     * @param proposalRef - the entity ID for the proposal
     *
     * @exception FileNotFoundException - no matching file was found.
     *
     */
    public String getFilenameFromProposalID(String proposalRef) throws FileNotFoundException {
        try {
            checkProjectList();
            for (String filename : this.projectList.keySet()) {
                if (proposalRef.equals(this.projectList.get(filename).getObsProposalEntityId())) {
                    return filename;
                }
            }
        }catch (JAXBException | IOException e){
            throw new FileNotFoundException("Error looking for project file"+e.getMessage());
        }
        throw new FileNotFoundException("Could not find matching project file");
    }

    /**
     * Adds a new project entry to the project list extracting the
     * info from the project supplied
     *
     * @param project  project to be added to the project list
     *
     */
    public void addProjectToList ( ObsProject project) {

        String filename = project.getObsProjectEntity().getEntityId() + FileUtilities.FILE_EXTENSION;
        this.projectList.put(filename, listItemFromProject(project));

    }

    /**
     * Creates a list of all projects available and stores locally
     *
     * @throws JAXBException From marshalling
     * @throws IOException   From file reading
     */
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

    /**
     * Creates a project list item representing a supplied project
     *
     * @param project The project to create the list item from
     * @return The new list item
     */
    private static ProjectListItem listItemFromProject(ObsProject project) {
        return new ProjectListItem(project.getProjectName(),
                project.getPI(),
                project.getCode(),
                project.getTimeOfCreation(),
                project.getObsProjectEntity().getEntityId(),
                project.getObsProposalRef().getEntityId());
    }
}