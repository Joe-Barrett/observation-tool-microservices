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
 * Container for the collections of Executive Fractions.
 * 
 * <p>Java class for TimeAllocationBreakdownT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeAllocationBreakdownT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExecutiveFraction" type="{Alma/ObsPrep/ObsProposal}ExecutiveFractionT" maxOccurs="6" minOccurs="6"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeAllocationBreakdownT", namespace = "Alma/ObsPrep/ObsProposal", propOrder = {
    "executiveFraction"
})
public class TimeAllocationBreakdownT {

    @XmlElement(name = "ExecutiveFraction", required = true)
    private List<ExecutiveFractionT> executiveFraction;

    /**
     * Gets the value of the executiveFraction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the executiveFraction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExecutiveFraction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExecutiveFractionT }
     * 
     * 
     */
    public List<ExecutiveFractionT> getExecutiveFraction() {
        if (executiveFraction == null) {
            executiveFraction = new ArrayList<>();
        }
        return this.executiveFraction;
    }

}
