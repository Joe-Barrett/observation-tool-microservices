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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The base class supporting the system side (i.e. executable at the observatory) of the project data model. With its specialisations ObsUnitSet and SchedBlock the pattern supports arbitrary hierarchical structures. The status attribute allows a lifecycle to be tracked for all types of ObsUnit.
 * 
 * <p>Java class for ObsUnitT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObsUnitT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObsUnitControl" type="{Alma/ObsPrep/ObsProject}ObsUnitControlT"/>
 *         &lt;element name="UnitDependencies" type="{Alma/ObsPrep/ObsProject}UnitDependenciesT"/>
 *         &lt;element name="ObsProjectRef" type="{Alma/ObsPrep/ObsProject}ObsProjectRefT"/>
 *       &lt;/sequence>
 *       &lt;attribute name="status" default="NewPhase2">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Approved"/>
 *             &lt;enumeration value="Broken"/>
 *             &lt;enumeration value="Canceled"/>
 *             &lt;enumeration value="Deleted"/>
 *             &lt;enumeration value="FullyObserved"/>
 *             &lt;enumeration value="PartiallyObserved"/>
 *             &lt;enumeration value="Phase2Submitted"/>
 *             &lt;enumeration value="PipelineError"/>
 *             &lt;enumeration value="Processed"/>
 *             &lt;enumeration value="Ready"/>
 *             &lt;enumeration value="Repaired"/>
 *             &lt;enumeration value="Running"/>
 *             &lt;enumeration value="ObservingTimedOut"/>
 *             &lt;enumeration value="ToBeRepaired"/>
 *             &lt;enumeration value="Verified"/>
 *             &lt;enumeration value="AnyState"/>
 *             &lt;enumeration value="Phase1Submitted"/>
 *             &lt;enumeration value="NewPhase1"/>
 *             &lt;enumeration value="NewPhase2"/>
 *             &lt;enumeration value="ObservingTerminated"/>
 *             &lt;enumeration value="ObservingAborted"/>
 *             &lt;enumeration value="ObservingFailed"/>
 *             &lt;enumeration value="VerificationFailure"/>
 *             &lt;enumeration value="Suspended"/>
 *             &lt;enumeration value="Rejected"/>
 *             &lt;enumeration value="CSVReady"/>
 *             &lt;enumeration value="CSVRunning"/>
 *             &lt;enumeration value="CSVSuspended"/>
 *             &lt;enumeration value="Completed"/>
 *             &lt;enumeration value="Delivered"/>
 *             &lt;enumeration value="InProgress"/>
 *             &lt;enumeration value="PipelineProcessing"/>
 *             &lt;enumeration value="ReadyForProcessing"/>
 *             &lt;enumeration value="ReadyToDeliver"/>
 *             &lt;enumeration value="CalibratorCheck"/>
 *             &lt;enumeration value="QA2InProgress"/>
 *             &lt;enumeration value="ManualProcessing"/>
 *             &lt;enumeration value="ReprocessingRequired"/>
 *             &lt;enumeration value="Waiting"/>
 *             &lt;enumeration value="QA3InProgress"/>
 *             &lt;enumeration value="PartiallyCompleted"/>
 *             &lt;enumeration value="NotObserved"/>
 *             &lt;enumeration value="ProcessingProblem"/>
 *             &lt;enumeration value="Processing"/>
 *             &lt;enumeration value="ReadyForReview"/>
 *             &lt;enumeration value="Reviewing"/>
 *             &lt;enumeration value="DeliveryInProgress"/>
 *             &lt;enumeration value="DoNotObserve"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObsUnitT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "name",
    "note",
    "obsUnitControl",
    "unitDependencies",
    "obsProjectRef"
})
@XmlSeeAlso({
    ObsUnitSetT.class,
    SchedBlock.class
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ObsUnitSetT.class, name = "ObsUnitSetT"),
        @JsonSubTypes.Type(value = SchedBlock.class, name = "SchedBlock")
})
public abstract class ObsUnitT {

    @XmlElement(required = true)
    private String name;
    private String note;
    @XmlElement(name = "ObsUnitControl", required = true)
    private ObsUnitControlT obsUnitControl;
    @XmlElement(name = "UnitDependencies", required = true)
    private UnitDependenciesT unitDependencies;
    @XmlElement(name = "ObsProjectRef", required = true)
    private ObsProjectRefT obsProjectRef;
    @XmlAttribute(name = "status")
    private String status;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Gets the value of the obsUnitControl property.
     * 
     * @return
     *     possible object is
     *     {@link ObsUnitControlT }
     *     
     */
    public ObsUnitControlT getObsUnitControl() {
        return obsUnitControl;
    }

    /**
     * Sets the value of the obsUnitControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObsUnitControlT }
     *     
     */
    public void setObsUnitControl(ObsUnitControlT value) {
        this.obsUnitControl = value;
    }

    /**
     * Gets the value of the unitDependencies property.
     * 
     * @return
     *     possible object is
     *     {@link UnitDependenciesT }
     *     
     */
    public UnitDependenciesT getUnitDependencies() {
        return unitDependencies;
    }

    /**
     * Sets the value of the unitDependencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitDependenciesT }
     *     
     */
    public void setUnitDependencies(UnitDependenciesT value) {
        this.unitDependencies = value;
    }

    /**
     * Gets the value of the obsProjectRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObsProjectRefT }
     *     
     */
    public ObsProjectRefT getObsProjectRef() {
        return obsProjectRef;
    }

    /**
     * Sets the value of the obsProjectRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObsProjectRefT }
     *     
     */
    public void setObsProjectRef(ObsProjectRefT value) {
        this.obsProjectRef = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        if (status == null) {
            return "NewPhase2";
        } else {
            return status;
        }
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
