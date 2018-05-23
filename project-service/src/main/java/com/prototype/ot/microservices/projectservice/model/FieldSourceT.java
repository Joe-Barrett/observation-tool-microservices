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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Description of the source to be observed. Includes coordinates, velocity, name and a set of SourceProperties. Note: Major solar system bodies will be known by the system and can selected by name. For other moving bodies a SourceEphemeris may be specified: this should probably be its own type, but details are TBC. For now it is a String.
 * 
 * <p>Java class for FieldSourceT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FieldSourceT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sourceCoordinates" type="{Alma/ValueTypes}SkyCoordinatesT"/>
 *         &lt;element name="sourceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceVelocity" type="{Alma/ValueTypes}VelocityT"/>
 *         &lt;element name="sourceEphemeris" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pMRA" type="{Alma/ValueTypes}AngularVelocityT"/>
 *         &lt;element name="pMDec" type="{Alma/ValueTypes}AngularVelocityT"/>
 *         &lt;element name="nonSiderealMotion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="parallax" type="{Alma/ValueTypes}AngleT"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isQuery" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ephemerisFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="CrossPattern" type="{Alma/ObsPrep/SchedBlock}CrossPatternT"/>
 *           &lt;element name="FillPattern" type="{Alma/ObsPrep/SchedBlock}FillPatternT"/>
 *           &lt;element name="PointingPattern" type="{Alma/ObsPrep/SchedBlock}PointingPatternT"/>
 *           &lt;element name="RectanglePattern" type="{Alma/ObsPrep/SchedBlock}RectanglePatternT"/>
 *         &lt;/choice>
 *         &lt;element name="QuerySource" type="{Alma/ObsPrep/SchedBlock}QuerySourceT" minOccurs="0"/>
 *         &lt;element name="Reference" type="{Alma/ObsPrep/SchedBlock}ReferenceT" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="SourceProperty" type="{Alma/ObsPrep/SchedBlock}SourcePropertyT" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ImageRef" type="{Alma/Obsprep/ObsAttachment}ObsAttachmentRefT" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="entityPartId" type="{Alma/CommonEntity}EntityPartIdT" />
 *       &lt;attribute name="almatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="APDM::FieldSource" />
 *       &lt;attribute name="solarSystemObject" default="Unspecified">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Mercury"/>
 *             &lt;enumeration value="Venus"/>
 *             &lt;enumeration value="Moon"/>
 *             &lt;enumeration value="Mars"/>
 *             &lt;enumeration value="Jupiter"/>
 *             &lt;enumeration value="Saturn"/>
 *             &lt;enumeration value="Uranus"/>
 *             &lt;enumeration value="Neptune"/>
 *             &lt;enumeration value="Pluto"/>
 *             &lt;enumeration value="Sun"/>
 *             &lt;enumeration value="Ganymede"/>
 *             &lt;enumeration value="Europa"/>
 *             &lt;enumeration value="Callisto"/>
 *             &lt;enumeration value="Io"/>
 *             &lt;enumeration value="Titan"/>
 *             &lt;enumeration value="Ceres"/>
 *             &lt;enumeration value="Pallas"/>
 *             &lt;enumeration value="Juno"/>
 *             &lt;enumeration value="Vesta"/>
 *             &lt;enumeration value="Ephemeris"/>
 *             &lt;enumeration value="Unspecified"/>
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
@XmlType(name = "FieldSourceT", propOrder = {
    "sourceCoordinates",
    "sourceName",
    "sourceVelocity",
    "sourceEphemeris",
    "pmra",
    "pmDec",
    "nonSiderealMotion",
    "parallax",
    "name",
    "isQuery",
    "ephemerisFileName",
    "crossPattern",
    "fillPattern",
    "pointingPattern",
    "rectanglePattern",
    "querySource",
    "reference",
    "sourceProperty",
    "imageRef"
})
public class FieldSourceT {

    @XmlElement(required = true)
    protected SkyCoordinatesT sourceCoordinates;
    @XmlElement(required = true)
    protected String sourceName;
    @XmlElement(required = true)
    protected VelocityT sourceVelocity;
    protected String sourceEphemeris;
    @XmlElement(name = "pMRA", required = true)
    protected AngularVelocityT pmra;
    @XmlElement(name = "pMDec", required = true)
    protected AngularVelocityT pmDec;
    @XmlElement(defaultValue = "false")
    protected boolean nonSiderealMotion;
    @XmlElement(required = true)
    protected AngleT parallax;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(defaultValue = "false")
    protected boolean isQuery;
    protected String ephemerisFileName;
    @XmlElement(name = "CrossPattern")
    protected CrossPatternT crossPattern;
    @XmlElement(name = "FillPattern")
    protected FillPatternT fillPattern;
    @XmlElement(name = "PointingPattern")
    protected PointingPatternT pointingPattern;
    @XmlElement(name = "RectanglePattern")
    protected RectanglePatternT rectanglePattern;
    @XmlElement(name = "QuerySource")
    protected QuerySourceT querySource;
    @XmlElement(name = "Reference")
    protected List<ReferenceT> reference;
    @XmlElement(name = "SourceProperty")
    protected List<SourcePropertyT> sourceProperty;
    @XmlElement(name = "ImageRef")
    protected ObsAttachmentRefT imageRef;
    @XmlAttribute(name = "entityPartId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String entityPartId;
    @XmlAttribute(name = "almatype", required = true)
    protected String almatype;
    @XmlAttribute(name = "solarSystemObject")
    protected String solarSystemObject;

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
     * Gets the value of the sourceVelocity property.
     * 
     * @return
     *     possible object is
     *     {@link VelocityT }
     *     
     */
    public VelocityT getSourceVelocity() {
        return sourceVelocity;
    }

    /**
     * Sets the value of the sourceVelocity property.
     * 
     * @param value
     *     allowed object is
     *     {@link VelocityT }
     *     
     */
    public void setSourceVelocity(VelocityT value) {
        this.sourceVelocity = value;
    }

    /**
     * Gets the value of the sourceEphemeris property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceEphemeris() {
        return sourceEphemeris;
    }

    /**
     * Sets the value of the sourceEphemeris property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceEphemeris(String value) {
        this.sourceEphemeris = value;
    }

    /**
     * Gets the value of the pmra property.
     * 
     * @return
     *     possible object is
     *     {@link AngularVelocityT }
     *     
     */
    public AngularVelocityT getPMRA() {
        return pmra;
    }

    /**
     * Sets the value of the pmra property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngularVelocityT }
     *     
     */
    public void setPMRA(AngularVelocityT value) {
        this.pmra = value;
    }

    /**
     * Gets the value of the pmDec property.
     * 
     * @return
     *     possible object is
     *     {@link AngularVelocityT }
     *     
     */
    public AngularVelocityT getPMDec() {
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
    public void setPMDec(AngularVelocityT value) {
        this.pmDec = value;
    }

    /**
     * Gets the value of the nonSiderealMotion property.
     * 
     */
    public boolean isNonSiderealMotion() {
        return nonSiderealMotion;
    }

    /**
     * Sets the value of the nonSiderealMotion property.
     * 
     */
    public void setNonSiderealMotion(boolean value) {
        this.nonSiderealMotion = value;
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
     * Gets the value of the isQuery property.
     * 
     */
    public boolean isIsQuery() {
        return isQuery;
    }

    /**
     * Sets the value of the isQuery property.
     * 
     */
    public void setIsQuery(boolean value) {
        this.isQuery = value;
    }

    /**
     * Gets the value of the ephemerisFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEphemerisFileName() {
        return ephemerisFileName;
    }

    /**
     * Sets the value of the ephemerisFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEphemerisFileName(String value) {
        this.ephemerisFileName = value;
    }

    /**
     * Gets the value of the crossPattern property.
     * 
     * @return
     *     possible object is
     *     {@link CrossPatternT }
     *     
     */
    public CrossPatternT getCrossPattern() {
        return crossPattern;
    }

    /**
     * Sets the value of the crossPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossPatternT }
     *     
     */
    public void setCrossPattern(CrossPatternT value) {
        this.crossPattern = value;
    }

    /**
     * Gets the value of the fillPattern property.
     * 
     * @return
     *     possible object is
     *     {@link FillPatternT }
     *     
     */
    public FillPatternT getFillPattern() {
        return fillPattern;
    }

    /**
     * Sets the value of the fillPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link FillPatternT }
     *     
     */
    public void setFillPattern(FillPatternT value) {
        this.fillPattern = value;
    }

    /**
     * Gets the value of the pointingPattern property.
     * 
     * @return
     *     possible object is
     *     {@link PointingPatternT }
     *     
     */
    public PointingPatternT getPointingPattern() {
        return pointingPattern;
    }

    /**
     * Sets the value of the pointingPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointingPatternT }
     *     
     */
    public void setPointingPattern(PointingPatternT value) {
        this.pointingPattern = value;
    }

    /**
     * Gets the value of the rectanglePattern property.
     * 
     * @return
     *     possible object is
     *     {@link RectanglePatternT }
     *     
     */
    public RectanglePatternT getRectanglePattern() {
        return rectanglePattern;
    }

    /**
     * Sets the value of the rectanglePattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link RectanglePatternT }
     *     
     */
    public void setRectanglePattern(RectanglePatternT value) {
        this.rectanglePattern = value;
    }

    /**
     * Gets the value of the querySource property.
     * 
     * @return
     *     possible object is
     *     {@link QuerySourceT }
     *     
     */
    public QuerySourceT getQuerySource() {
        return querySource;
    }

    /**
     * Sets the value of the querySource property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuerySourceT }
     *     
     */
    public void setQuerySource(QuerySourceT value) {
        this.querySource = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceT }
     * 
     * 
     */
    public List<ReferenceT> getReference() {
        if (reference == null) {
            reference = new ArrayList<ReferenceT>();
        }
        return this.reference;
    }

    /**
     * Gets the value of the sourceProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourcePropertyT }
     * 
     * 
     */
    public List<SourcePropertyT> getSourceProperty() {
        if (sourceProperty == null) {
            sourceProperty = new ArrayList<SourcePropertyT>();
        }
        return this.sourceProperty;
    }

    /**
     * Gets the value of the imageRef property.
     * 
     * @return
     *     possible object is
     *     {@link ObsAttachmentRefT }
     *     
     */
    public ObsAttachmentRefT getImageRef() {
        return imageRef;
    }

    /**
     * Sets the value of the imageRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObsAttachmentRefT }
     *     
     */
    public void setImageRef(ObsAttachmentRefT value) {
        this.imageRef = value;
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
            return "APDM::FieldSource";
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
     * Gets the value of the solarSystemObject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSolarSystemObject() {
        if (solarSystemObject == null) {
            return "Unspecified";
        } else {
            return solarSystemObject;
        }
    }

    /**
     * Sets the value of the solarSystemObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSolarSystemObject(String value) {
        this.solarSystemObject = value;
    }

}
