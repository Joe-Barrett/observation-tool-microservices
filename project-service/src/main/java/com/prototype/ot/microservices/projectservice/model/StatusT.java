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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReadyTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="State">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Approved"/>
 *             &lt;enumeration value="Broken"/>
 *             &lt;enumeration value="Canceled"/>
 *             &lt;enumeration value="Deleted"/>
 *             &lt;enumeration value="FullyObserved"/>
 *             &lt;enumeration value="PartiallyObserved"/>
 *             &lt;enumeration value="Phase2Submitted"/>
 *             &lt;enumeration value="PipelineError"/>
 *             &lt;enumeration value="Processed"/>
 *             &lt;enumeration value="Ready"/>
 *             &lt;enumeration value="Repaired"/>
 *             &lt;enumeration value="Running"/>
 *             &lt;enumeration value="ObservingTimedOut"/>
 *             &lt;enumeration value="ToBeRepaired"/>
 *             &lt;enumeration value="Verified"/>
 *             &lt;enumeration value="AnyState"/>
 *             &lt;enumeration value="Phase1Submitted"/>
 *             &lt;enumeration value="NewPhase1"/>
 *             &lt;enumeration value="NewPhase2"/>
 *             &lt;enumeration value="ObservingTerminated"/>
 *             &lt;enumeration value="ObservingAborted"/>
 *             &lt;enumeration value="ObservingFailed"/>
 *             &lt;enumeration value="VerificationFailure"/>
 *             &lt;enumeration value="Suspended"/>
 *             &lt;enumeration value="Rejected"/>
 *             &lt;enumeration value="CSVReady"/>
 *             &lt;enumeration value="CSVRunning"/>
 *             &lt;enumeration value="CSVSuspended"/>
 *             &lt;enumeration value="Completed"/>
 *             &lt;enumeration value="Delivered"/>
 *             &lt;enumeration value="InProgress"/>
 *             &lt;enumeration value="PipelineProcessing"/>
 *             &lt;enumeration value="ReadyForProcessing"/>
 *             &lt;enumeration value="ReadyToDeliver"/>
 *             &lt;enumeration value="CalibratorCheck"/>
 *             &lt;enumeration value="QA2InProgress"/>
 *             &lt;enumeration value="ManualProcessing"/>
 *             &lt;enumeration value="ReprocessingRequired"/>
 *             &lt;enumeration value="Waiting"/>
 *             &lt;enumeration value="QA3InProgress"/>
 *             &lt;enumeration value="PartiallyCompleted"/>
 *             &lt;enumeration value="NotObserved"/>
 *             &lt;enumeration value="ProcessingProblem"/>
 *             &lt;enumeration value="Processing"/>
 *             &lt;enumeration value="ReadyForReview"/>
 *             &lt;enumeration value="Reviewing"/>
 *             &lt;enumeration value="DeliveryInProgress"/>
 *             &lt;enumeration value="DoNotObserve"/>
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
@XmlType(name = "StatusT", namespace = "Alma/ValueTypes", propOrder = {
    "readyTime",
    "startTime",
    "endTime"
})
public class StatusT {

    @XmlElement(name = "ReadyTime", required = true)
    private String readyTime;
    @XmlElement(name = "StartTime", required = true)
    private String startTime;
    @XmlElement(name = "EndTime", required = true)
    private String endTime;
    @XmlAttribute(name = "State")
    private String state;

    /**
     * Gets the value of the readyTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadyTime() {
        return readyTime;
    }

    /**
     * Sets the value of the readyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadyTime(String value) {
        this.readyTime = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

}
