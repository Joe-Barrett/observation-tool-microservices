//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 04:31:38 PM BST 
//


package com.prototype.ot.microservices.projectservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Indicates that the target should be used for polarisation calibration, with the goals specified.
 * 
 * <p>Java class for PolarizationCalParametersT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PolarizationCalParametersT">
 *   &lt;complexContent>
 *     &lt;extension base="{Alma/ObsPrep/SchedBlock}CalibratorParametersT">
 *       &lt;sequence>
 *         &lt;element name="desiredPolAccuracy" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolarizationCalParametersT", propOrder = {
    "desiredPolAccuracy"
})
public class PolarizationCalParametersT
    extends CalibratorParametersT
{

    protected double desiredPolAccuracy;

    /**
     * Gets the value of the desiredPolAccuracy property.
     * 
     */
    public double getDesiredPolAccuracy() {
        return desiredPolAccuracy;
    }

    /**
     * Sets the value of the desiredPolAccuracy property.
     * 
     */
    public void setDesiredPolAccuracy(double value) {
        this.desiredPolAccuracy = value;
    }

}
