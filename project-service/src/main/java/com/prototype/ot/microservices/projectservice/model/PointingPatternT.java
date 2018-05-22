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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An observing pattern made up of a series of discrete pointings. There are two types, offset and absolute patterns. Note that a single pointing is of this type - simply one point is defined.
 * 
 * <p>Java class for PointingPatternT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PointingPatternT">
 *   &lt;complexContent>
 *     &lt;extension base="{Alma/ObsPrep/SchedBlock}FieldPatternT">
 *       &lt;sequence>
 *         &lt;element name="phaseCenterCoordinates" type="{Alma/ValueTypes}SkyCoordinatesT" maxOccurs="unbounded"/>
 *         &lt;element name="isMosaic" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PointingPatternT", propOrder = {
    "phaseCenterCoordinates",
    "isMosaic"
})
public class PointingPatternT
    extends FieldPatternT
{

    @XmlElement(required = true)
    protected List<SkyCoordinatesT> phaseCenterCoordinates;
    @XmlElement(defaultValue = "false")
    protected boolean isMosaic;

    /**
     * Gets the value of the phaseCenterCoordinates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phaseCenterCoordinates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhaseCenterCoordinates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SkyCoordinatesT }
     * 
     * 
     */
    public List<SkyCoordinatesT> getPhaseCenterCoordinates() {
        if (phaseCenterCoordinates == null) {
            phaseCenterCoordinates = new ArrayList<SkyCoordinatesT>();
        }
        return this.phaseCenterCoordinates;
    }

    /**
     * Gets the value of the isMosaic property.
     * 
     */
    public boolean isIsMosaic() {
        return isMosaic;
    }

    /**
     * Sets the value of the isMosaic property.
     * 
     */
    public void setIsMosaic(boolean value) {
        this.isMosaic = value;
    }

}
