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
 * The parameters of a single optical pointing target
 * 
 * <p>Java class for OpticalPointingTargetParametersT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpticalPointingTargetParametersT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sourceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceCoordinates" type="{Alma/ValueTypes}SkyCoordinatesT"/>
 *         &lt;element name="pmRA" type="{Alma/ValueTypes}AngularVelocityT"/>
 *         &lt;element name="pmDec" type="{Alma/ValueTypes}AngularVelocityT"/>
 *         &lt;element name="parallax" type="{Alma/ValueTypes}AngleT"/>
 *         &lt;element name="visibleMagnitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpticalPointingTargetParametersT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "sourceName",
    "sourceCoordinates",
    "pmRA",
    "pmDec",
    "parallax",
    "visibleMagnitude"
})
public class OpticalPointingTargetParametersT {

    @XmlElement(required = true)
    private String sourceName;
    @XmlElement(required = true)
    private SkyCoordinatesT sourceCoordinates;
    @XmlElement(required = true)
    private AngularVelocityT pmRA;
    @XmlElement(required = true)
    private AngularVelocityT pmDec;
    @XmlElement(required = true)
    private AngleT parallax;
    private double visibleMagnitude;

    /**
     * Gets the value of the sourceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * Sets the value of the sourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceName(String value) {
        this.sourceName = value;
    }

    /**
     * Gets the value of the sourceCoordinates property.
     * 
     * @return
     *     possible object is
     *     {@link SkyCoordinatesT }
     *     
     */
    public SkyCoordinatesT getSourceCoordinates() {
        return sourceCoordinates;
    }

    /**
     * Sets the value of the sourceCoordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkyCoordinatesT }
     *     
     */
    public void setSourceCoordinates(SkyCoordinatesT value) {
        this.sourceCoordinates = value;
    }

    /**
     * Gets the value of the pmRA property.
     * 
     * @return
     *     possible object is
     *     {@link AngularVelocityT }
     *     
     */
    public AngularVelocityT getPmRA() {
        return pmRA;
    }

    /**
     * Sets the value of the pmRA property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngularVelocityT }
     *     
     */
    public void setPmRA(AngularVelocityT value) {
        this.pmRA = value;
    }

    /**
     * Gets the value of the pmDec property.
     * 
     * @return
     *     possible object is
     *     {@link AngularVelocityT }
     *     
     */
    public AngularVelocityT getPmDec() {
        return pmDec;
    }

    /**
     * Sets the value of the pmDec property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngularVelocityT }
     *     
     */
    public void setPmDec(AngularVelocityT value) {
        this.pmDec = value;
    }

    /**
     * Gets the value of the parallax property.
     * 
     * @return
     *     possible object is
     *     {@link AngleT }
     *     
     */
    public AngleT getParallax() {
        return parallax;
    }

    /**
     * Sets the value of the parallax property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleT }
     *     
     */
    public void setParallax(AngleT value) {
        this.parallax = value;
    }

    /**
     * Gets the value of the visibleMagnitude property.
     * 
     */
    public double getVisibleMagnitude() {
        return visibleMagnitude;
    }

    /**
     * Sets the value of the visibleMagnitude property.
     * 
     */
    public void setVisibleMagnitude(double value) {
        this.visibleMagnitude = value;
    }

}
