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
 * General definition of a crosspattern that can be used to geometrically define a cross scan pattern.
 * 
 * <p>Java class for CrossPatternT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CrossPatternT">
 *   &lt;complexContent>
 *     &lt;extension base="{Alma/ObsPrep/SchedBlock}FieldPatternT">
 *       &lt;sequence>
 *         &lt;element name="patternCenterCoordinates" type="{Alma/ValueTypes}SkyCoordinatesT"/>
 *         &lt;element name="longitudeLength" type="{Alma/ValueTypes}AngleT"/>
 *         &lt;element name="latitudeLength" type="{Alma/ValueTypes}AngleT"/>
 *         &lt;element name="scanVelocity" type="{Alma/ValueTypes}AngularVelocityT"/>
 *         &lt;element name="orientation" type="{Alma/ValueTypes}AngleT"/>
 *       &lt;/sequence>
 *       &lt;attribute name="initialScanDirection" default="longitude">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="longitude"/>
 *             &lt;enumeration value="latitude"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CrossPatternT", propOrder = {
    "patternCenterCoordinates",
    "longitudeLength",
    "latitudeLength",
    "scanVelocity",
    "orientation"
})
public class CrossPatternT
    extends FieldPatternT
{

    @XmlElement(required = true)
    private SkyCoordinatesT patternCenterCoordinates;
    @XmlElement(required = true)
    private AngleT longitudeLength;
    @XmlElement(required = true)
    private AngleT latitudeLength;
    @XmlElement(required = true)
    private AngularVelocityT scanVelocity;
    @XmlElement(required = true)
    private AngleT orientation;
    @XmlAttribute(name = "initialScanDirection")
    private String initialScanDirection;

    /**
     * Gets the value of the patternCenterCoordinates property.
     * 
     * @return
     *     possible object is
     *     {@link SkyCoordinatesT }
     *     
     */
    public SkyCoordinatesT getPatternCenterCoordinates() {
        return patternCenterCoordinates;
    }

    /**
     * Sets the value of the patternCenterCoordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkyCoordinatesT }
     *     
     */
    public void setPatternCenterCoordinates(SkyCoordinatesT value) {
        this.patternCenterCoordinates = value;
    }

    /**
     * Gets the value of the longitudeLength property.
     * 
     * @return
     *     possible object is
     *     {@link AngleT }
     *     
     */
    public AngleT getLongitudeLength() {
        return longitudeLength;
    }

    /**
     * Sets the value of the longitudeLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleT }
     *     
     */
    public void setLongitudeLength(AngleT value) {
        this.longitudeLength = value;
    }

    /**
     * Gets the value of the latitudeLength property.
     * 
     * @return
     *     possible object is
     *     {@link AngleT }
     *     
     */
    public AngleT getLatitudeLength() {
        return latitudeLength;
    }

    /**
     * Sets the value of the latitudeLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleT }
     *     
     */
    public void setLatitudeLength(AngleT value) {
        this.latitudeLength = value;
    }

    /**
     * Gets the value of the scanVelocity property.
     * 
     * @return
     *     possible object is
     *     {@link AngularVelocityT }
     *     
     */
    public AngularVelocityT getScanVelocity() {
        return scanVelocity;
    }

    /**
     * Sets the value of the scanVelocity property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngularVelocityT }
     *     
     */
    public void setScanVelocity(AngularVelocityT value) {
        this.scanVelocity = value;
    }

    /**
     * Gets the value of the orientation property.
     * 
     * @return
     *     possible object is
     *     {@link AngleT }
     *     
     */
    public AngleT getOrientation() {
        return orientation;
    }

    /**
     * Sets the value of the orientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleT }
     *     
     */
    public void setOrientation(AngleT value) {
        this.orientation = value;
    }

    /**
     * Gets the value of the initialScanDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialScanDirection() {
        if (initialScanDirection == null) {
            return "longitude";
        } else {
            return initialScanDirection;
        }
    }

    /**
     * Sets the value of the initialScanDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialScanDirection(String value) {
        this.initialScanDirection = value;
    }

}
