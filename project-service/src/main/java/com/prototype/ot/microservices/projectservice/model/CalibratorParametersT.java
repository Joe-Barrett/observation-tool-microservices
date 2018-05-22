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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * This is a base class for the different varieties of calibrator parameters. Each of these types of calibrations are likely to be performed during normal, science, observing. These should be attached to targets to give that target an "intent" of the specific tyhpe of calibration. Multiple types of calibration may be attached to any given target.
 * 
 * <p>Java class for CalibratorParametersT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalibratorParametersT">
 *   &lt;complexContent>
 *     &lt;extension base="{Alma/ObsPrep/SchedBlock}ObservingParametersT">
 *       &lt;sequence>
 *         &lt;element name="cycleTime" type="{Alma/ValueTypes}TimeT"/>
 *         &lt;element name="defaultIntegrationTime" type="{Alma/ValueTypes}TimeT"/>
 *         &lt;element name="subScanDuration" type="{Alma/ValueTypes}TimeT"/>
 *         &lt;element name="forceAtmCal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="forceExecution" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dataOrigin" default="CHANNEL_AVERAGE_CROSS">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="TOTAL_POWER"/>
 *             &lt;enumeration value="WVR"/>
 *             &lt;enumeration value="CHANNEL_AVERAGE_AUTO"/>
 *             &lt;enumeration value="CHANNEL_AVERAGE_CROSS"/>
 *             &lt;enumeration value="FULL_RESOLUTION_AUTO"/>
 *             &lt;enumeration value="FULL_RESOLUTION_CROSS"/>
 *             &lt;enumeration value="OPTICAL_POINTING"/>
 *             &lt;enumeration value="HOLOGRAPHY"/>
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
@XmlType(name = "CalibratorParametersT", propOrder = {
    "cycleTime",
    "defaultIntegrationTime",
    "subScanDuration",
    "forceAtmCal",
    "forceExecution"
})
@XmlSeeAlso({
    PointingCalParametersT.class,
    PhaseCalParametersT.class,
    DelayCalParametersT.class,
    FocusCalParametersT.class,
    AmplitudeCalParametersT.class,
    CheckSourceCalParametersT.class,
    PolarizationCalParametersT.class,
    AtmosphericCalParametersT.class,
    SidebandRatioCalParametersT.class,
    BandpassCalParametersT.class
})
public abstract class CalibratorParametersT
    extends ObservingParametersT
{

    @XmlElement(required = true)
    protected TimeT cycleTime;
    @XmlElement(required = true)
    protected TimeT defaultIntegrationTime;
    @XmlElement(required = true)
    protected TimeT subScanDuration;
    @XmlElement(defaultValue = "false")
    protected Boolean forceAtmCal;
    @XmlElement(defaultValue = "false")
    protected Boolean forceExecution;
    @XmlAttribute(name = "dataOrigin")
    protected String dataOrigin;

    /**
     * Gets the value of the cycleTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeT }
     *     
     */
    public TimeT getCycleTime() {
        return cycleTime;
    }

    /**
     * Sets the value of the cycleTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeT }
     *     
     */
    public void setCycleTime(TimeT value) {
        this.cycleTime = value;
    }

    /**
     * Gets the value of the defaultIntegrationTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeT }
     *     
     */
    public TimeT getDefaultIntegrationTime() {
        return defaultIntegrationTime;
    }

    /**
     * Sets the value of the defaultIntegrationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeT }
     *     
     */
    public void setDefaultIntegrationTime(TimeT value) {
        this.defaultIntegrationTime = value;
    }

    /**
     * Gets the value of the subScanDuration property.
     * 
     * @return
     *     possible object is
     *     {@link TimeT }
     *     
     */
    public TimeT getSubScanDuration() {
        return subScanDuration;
    }

    /**
     * Sets the value of the subScanDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeT }
     *     
     */
    public void setSubScanDuration(TimeT value) {
        this.subScanDuration = value;
    }

    /**
     * Gets the value of the forceAtmCal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForceAtmCal() {
        return forceAtmCal;
    }

    /**
     * Sets the value of the forceAtmCal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForceAtmCal(Boolean value) {
        this.forceAtmCal = value;
    }

    /**
     * Gets the value of the forceExecution property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForceExecution() {
        return forceExecution;
    }

    /**
     * Sets the value of the forceExecution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForceExecution(Boolean value) {
        this.forceExecution = value;
    }

    /**
     * Gets the value of the dataOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataOrigin() {
        if (dataOrigin == null) {
            return "CHANNEL_AVERAGE_CROSS";
        } else {
            return dataOrigin;
        }
    }

    /**
     * Sets the value of the dataOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataOrigin(String value) {
        this.dataOrigin = value;
    }

}
