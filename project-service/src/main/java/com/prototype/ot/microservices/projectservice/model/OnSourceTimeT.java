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
 * <p>Java class for OnSourceTimeT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OnSourceTimeT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="intent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="time" type="{Alma/ValueTypes}TimeT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OnSourceTimeT", namespace = "Alma/Scheduling/SBStatus", propOrder = {
    "intent",
    "time"
})
public class OnSourceTimeT {

    @XmlElement(required = true)
    protected String intent;
    @XmlElement(required = true)
    protected TimeT time;

    /**
     * Gets the value of the intent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntent() {
        return intent;
    }

    /**
     * Sets the value of the intent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntent(String value) {
        this.intent = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link TimeT }
     *     
     */
    public TimeT getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeT }
     *     
     */
    public void setTime(TimeT value) {
        this.time = value;
    }

}
