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

package com.prototype.ot.microservices.projectservice.model;

public class ProjectListItem {

    private String
            projectName,
            pI,
            code,
            timeOfCreation,
            obsProjectEntityId,
            obsProposalEntityId;

    public ProjectListItem(String projectName,
                           String pI,
                           String code,
                           String timeOfCreation,
                           String obsProjectEntityId,
                           String obsProposalEntityId) {
        this.projectName = projectName;
        this.pI = pI;
        this.code = code;
        this.timeOfCreation = timeOfCreation;
        this.obsProjectEntityId = obsProjectEntityId;
        this.obsProposalEntityId = obsProposalEntityId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getpI() {
        return pI;
    }

    public void setpI(String pI) {
        this.pI = pI;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(String timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public String getObsProjectEntityId() {
        return obsProjectEntityId;
    }

    public void setObsProjectEntityId(String obsProjectEntityId) {
        this.obsProjectEntityId = obsProjectEntityId;
    }

    public String getObsProposalEntityId() {
        return obsProposalEntityId;
    }

    public void setObsProposalEntityId(String obsProposalEntityId) {
        this.obsProposalEntityId = obsProposalEntityId;
    }

}
