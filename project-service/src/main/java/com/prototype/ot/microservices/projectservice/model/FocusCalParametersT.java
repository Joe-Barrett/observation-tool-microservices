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
import javax.xml.bind.annotation.XmlType;


/**
 * Attaching this indicates that the target can be used for focus calibrations.
 * 
 * <p>Java class for FocusCalParametersT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FocusCalParametersT">
 *   &lt;complexContent>
 *     &lt;extension base="{Alma/ObsPrep/SchedBlock}CalibratorParametersT">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="AxisToAdjust" default="ZAxis">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="XAxis"/>
 *             &lt;enumeration value="YAxis"/>
 *             &lt;enumeration value="ZAxis"/>
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
@XmlType(name = "FocusCalParametersT")
public class FocusCalParametersT
    extends CalibratorParametersT
{

    @XmlAttribute(name = "AxisToAdjust")
    protected String axisToAdjust;

    /**
     * Gets the value of the axisToAdjust property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxisToAdjust() {
        if (axisToAdjust == null) {
            return "ZAxis";
        } else {
            return axisToAdjust;
        }
    }

    /**
     * Sets the value of the axisToAdjust property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxisToAdjust(String value) {
        this.axisToAdjust = value;
    }

}
