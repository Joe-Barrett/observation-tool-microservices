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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * Setup for the receiver and correlator from a science goal point of view. Allows selection of type of setup: continuum, spectral scan or a full setup. In all cases this is implemented by defining one or more spectral windows.
 * 
 * <p>Java class for SpectralSetupParametersT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpectralSetupParametersT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="representativeFrequency" type="{Alma/ValueTypes}FrequencyT"/>
 *         &lt;element name="userRepresentativeFrequency" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="singleContinuumFrequency" type="{Alma/ValueTypes}FrequencyT" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="ScienceSpectralWindow" type="{Alma/ObsPrep/ObsProject}ScienceSpectralWindowT"/>
 *           &lt;element name="SpectralScan" type="{Alma/ObsPrep/ObsProject}SpectralScanT"/>
 *         &lt;/choice>
 *         &lt;element name="AdvancedSpectralSetup" type="{Alma/ObsPrep/ObsProject}AdvancedSpectralSetupT" minOccurs="0"/>
 *         &lt;element name="OverlaidSpectralLine" type="{Alma/ObsPrep/ObsProject}OverlaidSpectralLineT" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="polarisation">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="SINGLE_X"/>
 *             &lt;enumeration value="SINGLE_Y"/>
 *             &lt;enumeration value="DOUBLE"/>
 *             &lt;enumeration value="FULL"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="continuum"/>
 *             &lt;enumeration value="scan"/>
 *             &lt;enumeration value="full"/>
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
@XmlType(name = "SpectralSetupParametersT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "representativeFrequency",
    "userRepresentativeFrequency",
    "singleContinuumFrequency",
        "spectralWindows",
    "advancedSpectralSetup",
    "overlaidSpectralLine"
})
public class SpectralSetupParametersT {

    @XmlElement(required = true)
    private FrequencyT representativeFrequency;
    @XmlElement(defaultValue = "false")
    private boolean userRepresentativeFrequency;
    private FrequencyT singleContinuumFrequency;
    @XmlElements({
        @XmlElement(name = "ScienceSpectralWindow", type = ScienceSpectralWindowT.class),
        @XmlElement(name = "SpectralScan", type = SpectralScanT.class)
    })
    private List<AbstractScienceSpectralWindowT> spectralWindows;
    @XmlElement(name = "AdvancedSpectralSetup")
    private AdvancedSpectralSetupT advancedSpectralSetup;
    @XmlElement(name = "OverlaidSpectralLine")
    private List<OverlaidSpectralLineT> overlaidSpectralLine;
    @XmlAttribute(name = "polarisation")
    private String polarisation;
    @XmlAttribute(name = "type")
    private String type;

    /**
     * Gets the value of the representativeFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyT }
     *     
     */
    public FrequencyT getRepresentativeFrequency() {
        return representativeFrequency;
    }

    /**
     * Sets the value of the representativeFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyT }
     *     
     */
    public void setRepresentativeFrequency(FrequencyT value) {
        this.representativeFrequency = value;
    }

    /**
     * Gets the value of the userRepresentativeFrequency property.
     * 
     */
    public boolean isUserRepresentativeFrequency() {
        return userRepresentativeFrequency;
    }

    /**
     * Sets the value of the userRepresentativeFrequency property.
     * 
     */
    public void setUserRepresentativeFrequency(boolean value) {
        this.userRepresentativeFrequency = value;
    }

    /**
     * Gets the value of the singleContinuumFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyT }
     *     
     */
    public FrequencyT getSingleContinuumFrequency() {
        return singleContinuumFrequency;
    }

    /**
     * Sets the value of the singleContinuumFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyT }
     *     
     */
    public void setSingleContinuumFrequency(FrequencyT value) {
        this.singleContinuumFrequency = value;
    }

    /**
     * Gets the value of the spectralWindows property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spectralWindows property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpectralWindows().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScienceSpectralWindowT }
     * {@link SpectralScanT }
     * 
     * 
     */
    public List<AbstractScienceSpectralWindowT> getSpectralWindows() {
        if (spectralWindows == null) {
            spectralWindows = new ArrayList<>();
        }
        return this.spectralWindows;
    }

    /**
     * Gets the value of the advancedSpectralSetup property.
     * 
     * @return
     *     possible object is
     *     {@link AdvancedSpectralSetupT }
     *     
     */
    public AdvancedSpectralSetupT getAdvancedSpectralSetup() {
        return advancedSpectralSetup;
    }

    /**
     * Sets the value of the advancedSpectralSetup property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdvancedSpectralSetupT }
     *     
     */
    public void setAdvancedSpectralSetup(AdvancedSpectralSetupT value) {
        this.advancedSpectralSetup = value;
    }

    /**
     * Gets the value of the overlaidSpectralLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the overlaidSpectralLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOverlaidSpectralLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OverlaidSpectralLineT }
     * 
     * 
     */
    public List<OverlaidSpectralLineT> getOverlaidSpectralLine() {
        if (overlaidSpectralLine == null) {
            overlaidSpectralLine = new ArrayList<>();
        }
        return this.overlaidSpectralLine;
    }

    /**
     * Gets the value of the polarisation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolarisation() {
        return polarisation;
    }

    /**
     * Sets the value of the polarisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolarisation(String value) {
        this.polarisation = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
