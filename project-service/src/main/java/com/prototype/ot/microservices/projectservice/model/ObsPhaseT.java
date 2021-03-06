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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The abstract concept of a "Phase". An ObsProject will accumulate data pertaining to different "Phases" of the Project, Phase I (Proposal preparation) and Phase II (Observing Program Preparation) are the most obvious, but other phases may be identified. In particular the reviewing comments and decisions are captured in a "Phase". The characteristic common to all Phases is that they contain an ObsPlan. For Phase I this is the planned program at that time. For Phase II this is the approved part of the program and represents what will actually be observed. The full concept for other phases is not defined, but could be developed.
 * 
 * <p>Java class for ObsPhaseT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObsPhaseT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="ObservatoryGoal" type="{Alma/ObsPrep/ObsProject}ObservatoryGoalT"/>
 *           &lt;element name="OpticalPointingScienceGoal" type="{Alma/ObsPrep/ObsProject}OpticalPointingScienceGoalT"/>
 *           &lt;element name="ScienceGoal" type="{Alma/ObsPrep/ObsProject}ScienceGoalT"/>
 *         &lt;/choice>
 *         &lt;element name="ObsPlan" type="{Alma/ObsPrep/ObsProject}ObsUnitSetT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObsPhaseT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "scienceGoals",
    "obsPlan"
})
@XmlSeeAlso({
    ObsProgramT.class,
    ObsReview.class,
    ObsProposal.class
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ObsProgramT.class, name = "ObsProgramT"),
        @JsonSubTypes.Type(value = ObsReview.class, name = "ObsReview"),
        @JsonSubTypes.Type(value = ObsProposal.class, name = "ObsProposal")
})
public abstract class ObsPhaseT {

    @XmlElements({
        @XmlElement(name = "ObservatoryGoal", type = ObservatoryGoalT.class),
        @XmlElement(name = "OpticalPointingScienceGoal", type = OpticalPointingScienceGoalT.class),
        @XmlElement(name = "ScienceGoal", type = ScienceGoalT.class)
    })
    private List<AbstractScienceGoalT> scienceGoals;
    @XmlElement(name = "ObsPlan", required = true)
    private ObsUnitSetT obsPlan;

    public void addScienceGoal() {
        if (this.scienceGoals == null) {
            this.scienceGoals = new ArrayList<>();
        }
        this.scienceGoals.add(new ScienceGoalT());
    }

    public void removeScienceGoal(int index) {
        this.scienceGoals.remove(index);
    }

    /**
     * Gets the value of the scienceGoals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scienceGoals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScienceGoals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObservatoryGoalT }
     * {@link OpticalPointingScienceGoalT }
     * {@link ScienceGoalT }
     * 
     * 
     */
    public List<AbstractScienceGoalT> getScienceGoals() {
        if (scienceGoals == null) {
            scienceGoals = new ArrayList<>();
        }
        return this.scienceGoals;
    }

    /**
     * Gets the value of the obsPlan property.
     * 
     * @return
     *     possible object is
     *     {@link ObsUnitSetT }
     *     
     */
    public ObsUnitSetT getObsPlan() {
        return obsPlan;
    }

    /**
     * Sets the value of the obsPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObsUnitSetT }
     *     
     */
    public void setObsPlan(ObsUnitSetT value) {
        this.obsPlan = value;
    }

}
