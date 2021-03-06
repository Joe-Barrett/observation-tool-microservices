/*
 * ALMA - Atacama Large Millimeter Array
 * Copyright (c) UKATC - UK Astronomy Technology Centre, Science and Technology Facilities Council, 2018
 * (in the framework of the ALMA collaboration).
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 04:31:38 PM BST 
//


package com.prototype.ot.microservices.projectservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Abstract spectral window class with the common attributes.
 * 
 * <p>Java class for AbstractSpectralWindowT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractSpectralWindowT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="centerFrequency" type="{Alma/ValueTypes}FrequencyT"/>
 *         &lt;element name="spectralAveragingFactor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="effectiveBandwidth" type="{Alma/ValueTypes}FrequencyT"/>
 *         &lt;element name="effectiveNumberOfChannels" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="associatedSpectralWindowNumberInPair" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="useThisSpectralWindow" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="desiredCenterFrequency" type="{Alma/ValueTypes}FrequencyT" minOccurs="0"/>
 *         &lt;element name="SpectralLine" type="{Alma/ObsPrep/SchedBlock}SpectralLineT" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sideBand" default="NOSB">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="LSB"/>
 *             &lt;enumeration value="USB"/>
 *             &lt;enumeration value="DSB"/>
 *             &lt;enumeration value="NOSB"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="windowFunction" default="HANNING">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="UNIFORM"/>
 *             &lt;enumeration value="HANNING"/>
 *             &lt;enumeration value="HAMMING"/>
 *             &lt;enumeration value="BARTLETT"/>
 *             &lt;enumeration value="BLACKMANN"/>
 *             &lt;enumeration value="BLACKMANN_HARRIS"/>
 *             &lt;enumeration value="WELCH"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="polnProducts" default="XX,YY">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="XX"/>
 *             &lt;enumeration value="YY"/>
 *             &lt;enumeration value="XX,YY"/>
 *             &lt;enumeration value="XX,YY,XY,YX"/>
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
@XmlType(name = "AbstractSpectralWindowT", propOrder = {
    "centerFrequency",
    "spectralAveragingFactor",
    "name",
    "effectiveBandwidth",
    "effectiveNumberOfChannels",
    "associatedSpectralWindowNumberInPair",
    "useThisSpectralWindow",
    "desiredCenterFrequency",
    "spectralLine"
})
@XmlSeeAlso({
    ACASpectralWindowT.class,
    BLSpectralWindowT.class
})
public abstract class AbstractSpectralWindowT {

    @XmlElement(required = true)
    private FrequencyT centerFrequency;
    @XmlElement(defaultValue = "1")
    private int spectralAveragingFactor;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private FrequencyT effectiveBandwidth;
    private int effectiveNumberOfChannels;
    @XmlElement(defaultValue = "0")
    private int associatedSpectralWindowNumberInPair;
    @XmlElement(defaultValue = "true")
    private boolean useThisSpectralWindow;
    private FrequencyT desiredCenterFrequency;
    @XmlElement(name = "SpectralLine")
    private List<SpectralLineT> spectralLine;
    @XmlAttribute(name = "sideBand")
    private String sideBand;
    @XmlAttribute(name = "windowFunction")
    private String windowFunction;
    @XmlAttribute(name = "polnProducts")
    private String polnProducts;

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
     * Gets the value of the spectralAveragingFactor property.
     * 
     */
    public int getSpectralAveragingFactor() {
        return spectralAveragingFactor;
    }

    /**
     * Sets the value of the spectralAveragingFactor property.
     * 
     */
    public void setSpectralAveragingFactor(int value) {
        this.spectralAveragingFactor = value;
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

    /**
     * Gets the value of the effectiveBandwidth property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyT }
     *     
     */
    public FrequencyT getEffectiveBandwidth() {
        return effectiveBandwidth;
    }

    /**
     * Sets the value of the effectiveBandwidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyT }
     *     
     */
    public void setEffectiveBandwidth(FrequencyT value) {
        this.effectiveBandwidth = value;
    }

    /**
     * Gets the value of the effectiveNumberOfChannels property.
     * 
     */
    public int getEffectiveNumberOfChannels() {
        return effectiveNumberOfChannels;
    }

    /**
     * Sets the value of the effectiveNumberOfChannels property.
     * 
     */
    public void setEffectiveNumberOfChannels(int value) {
        this.effectiveNumberOfChannels = value;
    }

    /**
     * Gets the value of the associatedSpectralWindowNumberInPair property.
     * 
     */
    public int getAssociatedSpectralWindowNumberInPair() {
        return associatedSpectralWindowNumberInPair;
    }

    /**
     * Sets the value of the associatedSpectralWindowNumberInPair property.
     * 
     */
    public void setAssociatedSpectralWindowNumberInPair(int value) {
        this.associatedSpectralWindowNumberInPair = value;
    }

    /**
     * Gets the value of the useThisSpectralWindow property.
     * 
     */
    public boolean isUseThisSpectralWindow() {
        return useThisSpectralWindow;
    }

    /**
     * Sets the value of the useThisSpectralWindow property.
     * 
     */
    public void setUseThisSpectralWindow(boolean value) {
        this.useThisSpectralWindow = value;
    }

    /**
     * Gets the value of the desiredCenterFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyT }
     *     
     */
    public FrequencyT getDesiredCenterFrequency() {
        return desiredCenterFrequency;
    }

    /**
     * Sets the value of the desiredCenterFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyT }
     *     
     */
    public void setDesiredCenterFrequency(FrequencyT value) {
        this.desiredCenterFrequency = value;
    }

    /**
     * Gets the value of the spectralLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spectralLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpectralLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpectralLineT }
     * 
     * 
     */
    public List<SpectralLineT> getSpectralLine() {
        if (spectralLine == null) {
            spectralLine = new ArrayList<>();
        }
        return this.spectralLine;
    }

    /**
     * Gets the value of the sideBand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSideBand() {
        if (sideBand == null) {
            return "NOSB";
        } else {
            return sideBand;
        }
    }

    /**
     * Sets the value of the sideBand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSideBand(String value) {
        this.sideBand = value;
    }

    /**
     * Gets the value of the windowFunction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindowFunction() {
        if (windowFunction == null) {
            return "HANNING";
        } else {
            return windowFunction;
        }
    }

    /**
     * Sets the value of the windowFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindowFunction(String value) {
        this.windowFunction = value;
    }

    /**
     * Gets the value of the polnProducts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolnProducts() {
        if (polnProducts == null) {
            return "XX,YY";
        } else {
            return polnProducts;
        }
    }

    /**
     * Sets the value of the polnProducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolnProducts(String value) {
        this.polnProducts = value;
    }

}
