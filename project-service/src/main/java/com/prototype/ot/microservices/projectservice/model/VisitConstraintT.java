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
 * Describes the setup for a long term monitoring type observation, i.e. returning to observe a target on a medium term cadance, e.g. every month.
 * 
 * <p>Java class for VisitConstraintT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VisitConstraintT">
 *   &lt;complexContent>
 *     &lt;extension base="{Alma/ObsPrep/ObsProject}AbstractTimingConstraintsT">
 *       &lt;sequence>
 *         &lt;element name="visitId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="previousVisitId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="requiredDelay" type="{Alma/ValueTypes}TimeT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisitConstraintT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "visitId",
    "previousVisitId",
    "requiredDelay"
})
public class VisitConstraintT
    extends AbstractTimingConstraintsT
{

    @XmlElement(defaultValue = "0")
    protected int visitId;
    @XmlElement(defaultValue = "0")
    protected Integer previousVisitId;
    protected TimeT requiredDelay;

    /**
     * Gets the value of the visitId property.
     * 
     */
    public int getVisitId() {
        return visitId;
    }

    /**
     * Sets the value of the visitId property.
     * 
     */
    public void setVisitId(int value) {
        this.visitId = value;
    }

    /**
     * Gets the value of the previousVisitId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPreviousVisitId() {
        return previousVisitId;
    }

    /**
     * Sets the value of the previousVisitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPreviousVisitId(Integer value) {
        this.previousVisitId = value;
    }

    /**
     * Gets the value of the requiredDelay property.
     * 
     * @return
     *     possible object is
     *     {@link TimeT }
     *     
     */
    public TimeT getRequiredDelay() {
        return requiredDelay;
    }

    /**
     * Sets the value of the requiredDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeT }
     *     
     */
    public void setRequiredDelay(TimeT value) {
        this.requiredDelay = value;
    }

}
