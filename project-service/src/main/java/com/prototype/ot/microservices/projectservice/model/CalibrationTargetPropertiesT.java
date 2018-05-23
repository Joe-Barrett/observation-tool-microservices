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
 * <p>Java class for CalibrationTargetPropertiesT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalibrationTargetPropertiesT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="frequency" type="{Alma/ValueTypes}FrequencyT"/>
 *         &lt;element name="flux" type="{Alma/ValueTypes}FluxT"/>
 *         &lt;element name="dateOfMeasurement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalibrationTargetPropertiesT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "frequency",
    "flux",
    "dateOfMeasurement"
})
public class CalibrationTargetPropertiesT {

    @XmlElement(required = true)
    protected FrequencyT frequency;
    @XmlElement(required = true)
    protected FluxT flux;
    protected String dateOfMeasurement;

    /**
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyT }
     *     
     */
    public FrequencyT getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyT }
     *     
     */
    public void setFrequency(FrequencyT value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the flux property.
     * 
     * @return
     *     possible object is
     *     {@link FluxT }
     *     
     */
    public FluxT getFlux() {
        return flux;
    }

    /**
     * Sets the value of the flux property.
     * 
     * @param value
     *     allowed object is
     *     {@link FluxT }
     *     
     */
    public void setFlux(FluxT value) {
        this.flux = value;
    }

    /**
     * Gets the value of the dateOfMeasurement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfMeasurement() {
        return dateOfMeasurement;
    }

    /**
     * Sets the value of the dateOfMeasurement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfMeasurement(String value) {
        this.dateOfMeasurement = value;
    }

}
