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
 * <p>Java class for ObsReview complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObsReview">
 *   &lt;complexContent>
 *     &lt;extension base="{Alma/ObsPrep/ObsProject}ObsPhaseT">
 *       &lt;sequence>
 *         &lt;element name="ObsReviewEntity" type="{Alma/ObsPrep/ObsReview}ObsReviewEntityT"/>
 *         &lt;element name="ObsProjectRef" type="{Alma/ObsPrep/ObsProject}ObsProjectRefT"/>
 *       &lt;/sequence>
 *       &lt;attribute name="schemaVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="13" />
 *       &lt;attribute name="revision" type="{http://www.w3.org/2001/XMLSchema}string" default="24" />
 *       &lt;attribute name="almatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="APDM::ObsReview" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObsReview", namespace = "Alma/ObsPrep/ObsReview", propOrder = {
    "obsReviewEntity",
    "obsProjectRef"
})
public class ObsReview
    extends ObsPhaseT
{

    @XmlElement(name = "ObsReviewEntity", required = true)
    private ObsReviewEntityT obsReviewEntity;
    @XmlElement(name = "ObsProjectRef", required = true)
    private ObsProjectRefT obsProjectRef;
    @XmlAttribute(name = "schemaVersion", required = true)
    private String schemaVersion;
    @XmlAttribute(name = "revision")
    private String revision;
    @XmlAttribute(name = "almatype", required = true)
    private String almatype;

    /**
     * Gets the value of the obsReviewEntity property.
     * 
     * @return
     *     possible object is
     *     {@link ObsReviewEntityT }
     *     
     */
    public ObsReviewEntityT getObsReviewEntity() {
        return obsReviewEntity;
    }

    /**
     * Sets the value of the obsReviewEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObsReviewEntityT }
     *     
     */
    public void setObsReviewEntity(ObsReviewEntityT value) {
        this.obsReviewEntity = value;
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
            return "APDM::ObsReview";
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
