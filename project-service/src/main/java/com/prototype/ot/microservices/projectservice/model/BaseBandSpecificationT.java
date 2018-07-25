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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Specification of a baseband.
 * 
 * <p>Java class for BaseBandSpecificationT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseBandSpecificationT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="centerFrequency" type="{Alma/ValueTypes}FrequencyT"/>
 *         &lt;element name="frequencySwitching" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lO2Frequency" type="{Alma/ValueTypes}FrequencyT"/>
 *         &lt;element name="weighting" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="useUSB" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="use12GHzFilter" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="imageCenterFrequency" type="{Alma/ValueTypes}FrequencyT" minOccurs="0"/>
 *         &lt;element name="imageWeighting" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="entityPartId" type="{Alma/CommonEntity}EntityPartIdT" />
 *       &lt;attribute name="almatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="APDM::BaseBandSpecification" />
 *       &lt;attribute name="baseBandName" default="BB_1">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="BB_1"/>
 *             &lt;enumeration value="BB_2"/>
 *             &lt;enumeration value="BB_3"/>
 *             &lt;enumeration value="BB_4"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="sideBandPreference" default="NONE">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="USB"/>
 *             &lt;enumeration value="LSB"/>
 *             &lt;enumeration value="NONE"/>
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
@XmlType(name = "BaseBandSpecificationT", propOrder = {
    "centerFrequency",
    "frequencySwitching",
    "lo2Frequency",
    "weighting",
    "useUSB",
    "use12GHzFilter",
    "imageCenterFrequency",
    "imageWeighting"
})
public class BaseBandSpecificationT {

    @XmlElement(required = true)
    private FrequencyT centerFrequency;
    @XmlElement(defaultValue = "false")
    private boolean frequencySwitching;
    @XmlElement(name = "lO2Frequency", required = true)
    private FrequencyT lo2Frequency;
    @XmlElement(defaultValue = "100")
    private double weighting;
    @XmlElement(defaultValue = "true")
    private boolean useUSB;
    @XmlElement(defaultValue = "false")
    private boolean use12GHzFilter;
    private FrequencyT imageCenterFrequency;
    private Double imageWeighting;
    @XmlAttribute(name = "entityPartId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String entityPartId;
    @XmlAttribute(name = "almatype", required = true)
    private String almatype;
    @XmlAttribute(name = "baseBandName")
    private String baseBandName;
    @XmlAttribute(name = "sideBandPreference")
    private String sideBandPreference;

    /**
     * Gets the value of the centerFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyT }
     *     
     */
    public FrequencyT getCenterFrequency() {
        return centerFrequency;
    }

    /**
     * Sets the value of the centerFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyT }
     *     
     */
    public void setCenterFrequency(FrequencyT value) {
        this.centerFrequency = value;
    }

    /**
     * Gets the value of the frequencySwitching property.
     * 
     */
    public boolean isFrequencySwitching() {
        return frequencySwitching;
    }

    /**
     * Sets the value of the frequencySwitching property.
     * 
     */
    public void setFrequencySwitching(boolean value) {
        this.frequencySwitching = value;
    }

    /**
     * Gets the value of the lo2Frequency property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyT }
     *     
     */
    public FrequencyT getLO2Frequency() {
        return lo2Frequency;
    }

    /**
     * Sets the value of the lo2Frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyT }
     *     
     */
    public void setLO2Frequency(FrequencyT value) {
        this.lo2Frequency = value;
    }

    /**
     * Gets the value of the weighting property.
     * 
     */
    public double getWeighting() {
        return weighting;
    }

    /**
     * Sets the value of the weighting property.
     * 
     */
    public void setWeighting(double value) {
        this.weighting = value;
    }

    /**
     * Gets the value of the useUSB property.
     * 
     */
    public boolean isUseUSB() {
        return useUSB;
    }

    /**
     * Sets the value of the useUSB property.
     * 
     */
    public void setUseUSB(boolean value) {
        this.useUSB = value;
    }

    /**
     * Gets the value of the use12GHzFilter property.
     * 
     */
    public boolean isUse12GHzFilter() {
        return use12GHzFilter;
    }

    /**
     * Sets the value of the use12GHzFilter property.
     * 
     */
    public void setUse12GHzFilter(boolean value) {
        this.use12GHzFilter = value;
    }

    /**
     * Gets the value of the imageCenterFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyT }
     *     
     */
    public FrequencyT getImageCenterFrequency() {
        return imageCenterFrequency;
    }

    /**
     * Sets the value of the imageCenterFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyT }
     *     
     */
    public void setImageCenterFrequency(FrequencyT value) {
        this.imageCenterFrequency = value;
    }

    /**
     * Gets the value of the imageWeighting property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImageWeighting() {
        return imageWeighting;
    }

    /**
     * Sets the value of the imageWeighting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImageWeighting(Double value) {
        this.imageWeighting = value;
    }

    /**
     * Gets the value of the entityPartId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityPartId() {
        return entityPartId;
    }

    /**
     * Sets the value of the entityPartId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityPartId(String value) {
        this.entityPartId = value;
    }

    /**
     * Gets the value of the almatype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlmatype() {
        if (almatype == null) {
            return "APDM::BaseBandSpecification";
        } else {
            return almatype;
        }
    }

    /**
     * Sets the value of the almatype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlmatype(String value) {
        this.almatype = value;
    }

    /**
     * Gets the value of the baseBandName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseBandName() {
        if (baseBandName == null) {
            return "BB_1";
        } else {
            return baseBandName;
        }
    }

    /**
     * Sets the value of the baseBandName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseBandName(String value) {
        this.baseBandName = value;
    }

    /**
     * Gets the value of the sideBandPreference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSideBandPreference() {
        if (sideBandPreference == null) {
            return "NONE";
        } else {
            return sideBandPreference;
        }
    }

    /**
     * Sets the value of the sideBandPreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSideBandPreference(String value) {
        this.sideBandPreference = value;
    }

}