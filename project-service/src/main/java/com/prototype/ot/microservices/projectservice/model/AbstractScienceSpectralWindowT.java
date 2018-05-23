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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A base, abstract, spectral window for science use. A concrete instance will define one spectral window, and many are allowed to fully define a rx/corr setup.
 * 
 * <p>Java class for AbstractScienceSpectralWindowT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractScienceSpectralWindowT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AdvancedWindowSetup" type="{Alma/ObsPrep/ObsProject}AdvancedWindowSetupT" minOccurs="0"/>
 *         &lt;element name="ExpectedSpectralLine" type="{Alma/ObsPrep/ObsProject}ExpectedSpectralLineT" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractScienceSpectralWindowT", namespace = "Alma/ObsPrep/ObsProject", propOrder = {
    "index",
    "advancedWindowSetup",
    "expectedSpectralLine"
})
@XmlSeeAlso({
    SpectralScanT.class,
    ScienceSpectralWindowT.class
})
public abstract class AbstractScienceSpectralWindowT {

    @XmlElement(defaultValue = "0")
    protected int index;
    @XmlElement(name = "AdvancedWindowSetup")
    protected AdvancedWindowSetupT advancedWindowSetup;
    @XmlElement(name = "ExpectedSpectralLine")
    protected List<ExpectedSpectralLineT> expectedSpectralLine;

    /**
     * Gets the value of the index property.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Gets the value of the advancedWindowSetup property.
     * 
     * @return
     *     possible object is
     *     {@link AdvancedWindowSetupT }
     *     
     */
    public AdvancedWindowSetupT getAdvancedWindowSetup() {
        return advancedWindowSetup;
    }

    /**
     * Sets the value of the advancedWindowSetup property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdvancedWindowSetupT }
     *     
     */
    public void setAdvancedWindowSetup(AdvancedWindowSetupT value) {
        this.advancedWindowSetup = value;
    }

    /**
     * Gets the value of the expectedSpectralLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expectedSpectralLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpectedSpectralLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExpectedSpectralLineT }
     * 
     * 
     */
    public List<ExpectedSpectralLineT> getExpectedSpectralLine() {
        if (expectedSpectralLine == null) {
            expectedSpectralLine = new ArrayList<ExpectedSpectralLineT>();
        }
        return this.expectedSpectralLine;
    }

}
