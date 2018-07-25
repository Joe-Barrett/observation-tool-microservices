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
 * Specialisation describing Pointing Calibration parameters. (For local pointing as part of observing)
 * 
 * <p>Java class for PointingCalParametersT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PointingCalParametersT">
 *   &lt;complexContent>
 *     &lt;extension base="{Alma/ObsPrep/SchedBlock}CalibratorParametersT">
 *       &lt;sequence>
 *         &lt;element name="desiredAccuracy" type="{Alma/ValueTypes}AngleT"/>
 *         &lt;element name="maximumElapsedTime" type="{Alma/ValueTypes}TimeT"/>
 *         &lt;element name="excursion" type="{Alma/ValueTypes}AngleT"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pointingMethod" default="FIVE_POINT">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="THREE_POINT"/>
 *             &lt;enumeration value="FOUR_POINT"/>
 *             &lt;enumeration value="FIVE_POINT"/>
 *             &lt;enumeration value="CROSS"/>
 *             &lt;enumeration value="CIRCLE"/>
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
@XmlType(name = "PointingCalParametersT", propOrder = {
    "desiredAccuracy",
    "maximumElapsedTime",
    "excursion"
})
public class PointingCalParametersT
    extends CalibratorParametersT
{

    @XmlElement(required = true)
    private AngleT desiredAccuracy;
    @XmlElement(required = true)
    private TimeT maximumElapsedTime;
    @XmlElement(required = true)
    private AngleT excursion;
    @XmlAttribute(name = "pointingMethod")
    private String pointingMethod;

    /**
     * Gets the value of the desiredAccuracy property.
     * 
     * @return
     *     possible object is
     *     {@link AngleT }
     *     
     */
    public AngleT getDesiredAccuracy() {
        return desiredAccuracy;
    }

    /**
     * Sets the value of the desiredAccuracy property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleT }
     *     
     */
    public void setDesiredAccuracy(AngleT value) {
        this.desiredAccuracy = value;
    }

    /**
     * Gets the value of the maximumElapsedTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeT }
     *     
     */
    public TimeT getMaximumElapsedTime() {
        return maximumElapsedTime;
    }

    /**
     * Sets the value of the maximumElapsedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeT }
     *     
     */
    public void setMaximumElapsedTime(TimeT value) {
        this.maximumElapsedTime = value;
    }

    /**
     * Gets the value of the excursion property.
     * 
     * @return
     *     possible object is
     *     {@link AngleT }
     *     
     */
    public AngleT getExcursion() {
        return excursion;
    }

    /**
     * Sets the value of the excursion property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleT }
     *     
     */
    public void setExcursion(AngleT value) {
        this.excursion = value;
    }

    /**
     * Gets the value of the pointingMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPointingMethod() {
        if (pointingMethod == null) {
            return "FIVE_POINT";
        } else {
            return pointingMethod;
        }
    }

    /**
     * Sets the value of the pointingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPointingMethod(String value) {
        this.pointingMethod = value;
    }

}