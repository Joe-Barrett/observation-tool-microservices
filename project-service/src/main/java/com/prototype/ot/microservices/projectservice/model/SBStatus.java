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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 04:31:38 PM BST 
//


package com.prototype.ot.microservices.projectservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SBStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{Alma/Scheduling/ProjectStatus}ObsUnitStatusT">
 *       &lt;sequence>
 *         &lt;element name="SBStatusEntity" type="{Alma/Scheduling/SBStatus}SBStatusEntityT"/>
 *         &lt;element name="SchedBlockRef" type="{Alma/ObsPrep/SchedBlock}SchedBlockRefT"/>
 *         &lt;element name="sensitivityGoalJy" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="sensitivityAchievedJy" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="hasSensitivityGoal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="qa0Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExecStatus" type="{Alma/Scheduling/SBStatus}ExecStatusT" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="schemaVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="13" />
 *       &lt;attribute name="revision" type="{http://www.w3.org/2001/XMLSchema}string" default="24" />
 *       &lt;attribute name="almatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="APDM::SBStatus" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBStatus", namespace = "Alma/Scheduling/SBStatus", propOrder = {
    "sbStatusEntity",
    "schedBlockRef",
    "sensitivityGoalJy",
    "sensitivityAchievedJy",
    "hasSensitivityGoal",
    "qa0Notes",
    "execStatus"
})
public class SBStatus
    extends ObsUnitStatusT
{

    @XmlElement(name = "SBStatusEntity", required = true)
    private SBStatusEntityT sbStatusEntity;
    @XmlElement(name = "SchedBlockRef", required = true)
    private SchedBlockRefT schedBlockRef;
    @XmlElement(defaultValue = "0.0")
    private double sensitivityGoalJy;
    @XmlElement(defaultValue = "0.0")
    private double sensitivityAchievedJy;
    @XmlElement(defaultValue = "false")
    private boolean hasSensitivityGoal;
    private String qa0Notes;
    @XmlElement(name = "ExecStatus")
    private List<ExecStatusT> execStatus;
    @XmlAttribute(name = "schemaVersion", required = true)
    private String schemaVersion;
    @XmlAttribute(name = "revision")
    private String revision;
    @XmlAttribute(name = "almatype", required = true)
    private String almatype;

    /**
     * Gets the value of the sbStatusEntity property.
     * 
     * @return
     *     possible object is
     *     {@link SBStatusEntityT }
     *     
     */
    public SBStatusEntityT getSBStatusEntity() {
        return sbStatusEntity;
    }

    /**
     * Sets the value of the sbStatusEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link SBStatusEntityT }
     *     
     */
    public void setSBStatusEntity(SBStatusEntityT value) {
        this.sbStatusEntity = value;
    }

    /**
     * Gets the value of the schedBlockRef property.
     * 
     * @return
     *     possible object is
     *     {@link SchedBlockRefT }
     *     
     */
    public SchedBlockRefT getSchedBlockRef() {
        return schedBlockRef;
    }

    /**
     * Sets the value of the schedBlockRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchedBlockRefT }
     *     
     */
    public void setSchedBlockRef(SchedBlockRefT value) {
        this.schedBlockRef = value;
    }

    /**
     * Gets the value of the sensitivityGoalJy property.
     * 
     */
    public double getSensitivityGoalJy() {
        return sensitivityGoalJy;
    }

    /**
     * Sets the value of the sensitivityGoalJy property.
     * 
     */
    public void setSensitivityGoalJy(double value) {
        this.sensitivityGoalJy = value;
    }

    /**
     * Gets the value of the sensitivityAchievedJy property.
     * 
     */
    public double getSensitivityAchievedJy() {
        return sensitivityAchievedJy;
    }

    /**
     * Sets the value of the sensitivityAchievedJy property.
     * 
     */
    public void setSensitivityAchievedJy(double value) {
        this.sensitivityAchievedJy = value;
    }

    /**
     * Gets the value of the hasSensitivityGoal property.
     * 
     */
    public boolean isHasSensitivityGoal() {
        return hasSensitivityGoal;
    }

    /**
     * Sets the value of the hasSensitivityGoal property.
     * 
     */
    public void setHasSensitivityGoal(boolean value) {
        this.hasSensitivityGoal = value;
    }

    /**
     * Gets the value of the qa0Notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQa0Notes() {
        return qa0Notes;
    }

    /**
     * Sets the value of the qa0Notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQa0Notes(String value) {
        this.qa0Notes = value;
    }

    /**
     * Gets the value of the execStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the execStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExecStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExecStatusT }
     * 
     * 
     */
    public List<ExecStatusT> getExecStatus() {
        if (execStatus == null) {
            execStatus = new ArrayList<>();
        }
        return this.execStatus;
    }

    /**
     * Gets the value of the schemaVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaVersion() {
        if (schemaVersion == null) {
            return "13";
        } else {
            return schemaVersion;
        }
    }

    /**
     * Sets the value of the schemaVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaVersion(String value) {
        this.schemaVersion = value;
    }

    /**
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevision() {
        if (revision == null) {
            return "24";
        } else {
            return revision;
        }
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevision(String value) {
        this.revision = value;
    }

    /**
     * Gets the value of the almatype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlmatype() {
        if (almatype == null) {
            return "APDM::SBStatus";
        } else {
            return almatype;
        }
    }

    /**
     * Sets the value of the almatype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlmatype(String value) {
        this.almatype = value;
    }

}
