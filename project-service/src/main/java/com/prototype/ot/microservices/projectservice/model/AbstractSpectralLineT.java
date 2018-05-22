//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 04:31:38 PM BST 
//


package com.prototype.ot.microservices.projectservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Brief description of a spectral line. Used by SpectralWindow to indicate which line(s) are expected in that window.
 * 
 * <p>Java class for AbstractSpectralLineT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractSpectralLineT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="restFrequency" type="{Alma/ValueTypes}FrequencyT"/>
 *         &lt;element name="transition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="spatalogId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractSpectralLineT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "restFrequency",
    "transition",
    "spatalogId",
    "description"
})
@XmlSeeAlso({
    ExpectedSpectralLineT.class,
    OverlaidSpectralLineT.class
})
public abstract class AbstractSpectralLineT {

    @XmlElement(required = true)
    protected FrequencyT restFrequency;
    @XmlElement(required = true)
    protected String transition;
    @XmlElement(required = true)
    protected String spatalogId;
    @XmlElement(required = true)
    protected String description;

    /**
     * Gets the value of the restFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyT }
     *     
     */
    public FrequencyT getRestFrequency() {
        return restFrequency;
    }

    /**
     * Sets the value of the restFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyT }
     *     
     */
    public void setRestFrequency(FrequencyT value) {
        this.restFrequency = value;
    }

    /**
     * Gets the value of the transition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransition() {
        return transition;
    }

    /**
     * Sets the value of the transition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransition(String value) {
        this.transition = value;
    }

    /**
     * Gets the value of the spatalogId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpatalogId() {
        return spatalogId;
    }

    /**
     * Sets the value of the spatalogId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpatalogId(String value) {
        this.spatalogId = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
