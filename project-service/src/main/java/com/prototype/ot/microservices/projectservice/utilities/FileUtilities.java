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

package com.prototype.ot.microservices.projectservice.utilities;

import com.prototype.ot.microservices.projectservice.model.ObsProject;
import com.prototype.ot.microservices.projectservice.model.ObsProposal;
import org.springframework.stereotype.Component;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Component
public class FileUtilities {
    public final static String PROJECT_DIRECTORY = "/data/projects/";
    public final static String PROJECT_XML = "ObsProject.xml";
    public final static String PROPOSAL_XML = "ObsProposal.xml";
    public final static String FILE_EXTENSION = ".aot";

    @SuppressWarnings("unchecked")
    public static <T> T loadResourceFromFilepath(String filepath, String fileType, Class<T> cls) throws JAXBException,
            IOException {
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

    public static void saveAotFile(ObsProject project, ObsProposal proposal) throws JAXBException, IOException {
        saveAotFile(project, proposal, project.getObsProjectEntity().getEntityId());
    }

    public static void saveAotFile(ObsProject project, ObsProposal proposal, String fileName) throws JAXBException,
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
}
