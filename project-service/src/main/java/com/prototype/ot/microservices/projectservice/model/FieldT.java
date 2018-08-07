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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Abstract field class. Holds common information
 * 
 * <p>Java class for FieldT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FieldT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="centre" type="{Alma/ValueTypes}SkyCoordinatesT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FieldT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "name",
    "centre"
})
@XmlSeeAlso({
    CircleT.class,
    PolygonT.class,
    EllipseT.class,
    RectangleT.class,
    SinglePointT.class
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CircleT.class, name = "CircleT"),
        @JsonSubTypes.Type(value = PolygonT.class, name = "PolygonT"),
        @JsonSubTypes.Type(value = EllipseT.class, name = "EllipseT"),
        @JsonSubTypes.Type(value = RectangleT.class, name = "RectangleT"),
        @JsonSubTypes.Type(value = SinglePointT.class, name = "SinglePointT"),
})
public abstract class FieldT {

    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private SkyCoordinatesT centre;

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
     * Gets the value of the centre property.
     * 
     * @return
     *     possible object is
     *     {@link SkyCoordinatesT }
     *     
     */
    public SkyCoordinatesT getCentre() {
        return centre;
    }

    /**
     * Sets the value of the centre property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkyCoordinatesT }
     *     
     */
    public void setCentre(SkyCoordinatesT value) {
        this.centre = value;
    }

}
