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
import javax.xml.bind.annotation.XmlType;


/**
 * PLACEHOLDER for possible DR scripts at the science goal level.
 * 
 * <p>Java class for ImagingProcedureT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImagingProcedureT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imageScript" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImagingProcedureT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "imageScript"
})
public class ImagingProcedureT {

    @XmlElement(required = true)
    private String imageScript;

    /**
     * Gets the value of the imageScript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageScript() {
        return imageScript;
    }

    /**
     * Sets the value of the imageScript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageScript(String value) {
        this.imageScript = value;
    }

}
