//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.22 at 04:31:38 PM BST 
//


package com.prototype.ot.microservices.projectservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntTimeReferenceT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntTimeReferenceT">
 *   &lt;simpleContent>
 *     &lt;restriction base="&lt;Alma/ValueTypes>DoubleWithUnitT">
 *       &lt;attribute name="unit" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="ns"/>
 *             &lt;enumeration value="us"/>
 *             &lt;enumeration value="ms"/>
 *             &lt;enumeration value="s"/>
 *             &lt;enumeration value="min"/>
 *             &lt;enumeration value="h"/>
 *             &lt;enumeration value="d"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntTimeReferenceT", namespace = "Alma/ValueTypes")
public class IntTimeReferenceT
    extends DoubleWithUnitT
{


}
