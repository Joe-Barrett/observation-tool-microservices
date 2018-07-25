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
 * Contains the time fraction of this project to be charged to a particular exectutive
 * 
 * <p>Java class for ExecutiveFractionT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExecutiveFractionT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timeFraction" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="OTHER"/>
 *             &lt;enumeration value="CL"/>
 *             &lt;enumeration value="EA"/>
 *             &lt;enumeration value="EU"/>
 *             &lt;enumeration value="NA"/>
 *             &lt;enumeration value="NA_EA"/>
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
@XmlType(name = "ExecutiveFractionT", namespace = "Alma/ObsPrep/ObsProposal", propOrder = {
    "timeFraction"
})
public class ExecutiveFractionT {

    @XmlElement(defaultValue = "0.0")
    private double timeFraction;
    @XmlAttribute(name = "name")
    private String name;

    /**
     * Gets the value of the timeFraction property.
     * 
     */
    public double getTimeFraction() {
        return timeFraction;
    }

    /**
     * Sets the value of the timeFraction property.
     * 
     */
    public void setTimeFraction(double value) {
        this.timeFraction = value;
    }

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

}