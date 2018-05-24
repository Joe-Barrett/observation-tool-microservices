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
 * Contains an attribute holding the actual observing procedure to be used, in the form of a python script name or a complete python script. For standard modes this will be pre-selected as the name of the standard script.
 * 
 * <p>Java class for ObsProcedureT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObsProcedureT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="obsProcScript" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObsProcedureT", propOrder = {
    "obsProcScript"
})
public class ObsProcedureT {

    @XmlElement(required = true)
    private String obsProcScript;

    /**
     * Gets the value of the obsProcScript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObsProcScript() {
        return obsProcScript;
    }

    /**
     * Sets the value of the obsProcScript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObsProcScript(String value) {
        this.obsProcScript = value;
    }

}
