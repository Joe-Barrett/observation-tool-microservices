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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Advanced spectral window setup. These properties will be used to set some details in the correlator and spectral setups in the SB, but are not displayed in the Science Goal by default, being classified as "advanced". Many are not yet available.
 * 
 * <p>Java class for AdvancedWindowSetupT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdvancedWindowSetupT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="smoothingFactor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="oversampling" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="addedSensitivity" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="useImage" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="useThis" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="smoothingFunction" default="HANNING">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="UNIFORM"/>
 *             &lt;enumeration value="HANNING"/>
 *             &lt;enumeration value="HAMMING"/>
 *             &lt;enumeration value="BARTLETT"/>
 *             &lt;enumeration value="BLACKMANN"/>
 *             &lt;enumeration value="BLACKMANN_HARRIS"/>
 *             &lt;enumeration value="WELCH"/>
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
@XmlType(name = "AdvancedWindowSetupT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "smoothingFactor",
    "oversampling",
    "addedSensitivity",
    "useImage",
    "useThis"
})
public class AdvancedWindowSetupT {

    @XmlElement(defaultValue = "1")
    private int smoothingFactor;
    @XmlElement(defaultValue = "false")
    private boolean oversampling;
    @XmlElement(defaultValue = "false")
    private boolean addedSensitivity;
    @XmlElement(defaultValue = "false")
    private boolean useImage;
    @XmlElement(defaultValue = "true")
    private boolean useThis;
    @XmlAttribute(name = "smoothingFunction")
    private String smoothingFunction;

    /**
     * Gets the value of the smoothingFactor property.
     * 
     */
    public int getSmoothingFactor() {
        return smoothingFactor;
    }

    /**
     * Sets the value of the smoothingFactor property.
     * 
     */
    public void setSmoothingFactor(int value) {
        this.smoothingFactor = value;
    }

    /**
     * Gets the value of the oversampling property.
     * 
     */
    public boolean isOversampling() {
        return oversampling;
    }

    /**
     * Sets the value of the oversampling property.
     * 
     */
    public void setOversampling(boolean value) {
        this.oversampling = value;
    }

    /**
     * Gets the value of the addedSensitivity property.
     * 
     */
    public boolean isAddedSensitivity() {
        return addedSensitivity;
    }

    /**
     * Sets the value of the addedSensitivity property.
     * 
     */
    public void setAddedSensitivity(boolean value) {
        this.addedSensitivity = value;
    }

    /**
     * Gets the value of the useImage property.
     * 
     */
    public boolean isUseImage() {
        return useImage;
    }

    /**
     * Sets the value of the useImage property.
     * 
     */
    public void setUseImage(boolean value) {
        this.useImage = value;
    }

    /**
     * Gets the value of the useThis property.
     * 
     */
    public boolean isUseThis() {
        return useThis;
    }

    /**
     * Sets the value of the useThis property.
     * 
     */
    public void setUseThis(boolean value) {
        this.useThis = value;
    }

    /**
     * Gets the value of the smoothingFunction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmoothingFunction() {
        if (smoothingFunction == null) {
            return "HANNING";
        } else {
            return smoothingFunction;
        }
    }

    /**
     * Sets the value of the smoothingFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmoothingFunction(String value) {
        this.smoothingFunction = value;
    }

}
