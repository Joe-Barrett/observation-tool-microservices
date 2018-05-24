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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * This abstract class is the root for all instrument specifications. It allows them to be treated in a common way at a very basic level.
 * 
 * <p>Java class for AbstractInstrumentSpecT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractInstrumentSpecT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="entityPartId" type="{Alma/CommonEntity}EntityPartIdT" />
 *       &lt;attribute name="almatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="APDM::AbstractInstrumentSpec" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractInstrumentSpecT", propOrder = {
    "name"
})
@XmlSeeAlso({
    OpticalCameraSpecT.class,
    SpectralSpecT.class
})
public abstract class AbstractInstrumentSpecT {

    @XmlElement(required = true)
    private String name;
    @XmlAttribute(name = "entityPartId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String entityPartId;
    @XmlAttribute(name = "almatype", required = true)
    private String almatype;

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
            return "APDM::AbstractInstrumentSpec";
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

}
