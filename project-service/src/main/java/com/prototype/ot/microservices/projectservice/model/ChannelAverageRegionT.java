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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * The user can select up to 10 sets of contiguous channels (a ChannelAverageRegion) which contribute to the channel average result. Note that these parameters are based on effective channels. That is, startChannel must be a zero based index within the effective range of spectral channels and the number of channels is interpreted based on the spectral resolution (band-width per channel) before any spectral averaging (spectralAveragingFactor) has been applied.
 * 
 * <p>Java class for ChannelAverageRegionT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChannelAverageRegionT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="startChannel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberChannels" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChannelAverageRegionT", propOrder = {
    "startChannel",
    "numberChannels"
})
public class ChannelAverageRegionT {

    private int startChannel;
    private int numberChannels;

    /**
     * Gets the value of the startChannel property.
     * 
     */
    public int getStartChannel() {
        return startChannel;
    }

    /**
     * Sets the value of the startChannel property.
     * 
     */
    public void setStartChannel(int value) {
        this.startChannel = value;
    }

    /**
     * Gets the value of the numberChannels property.
     * 
     */
    public int getNumberChannels() {
        return numberChannels;
    }

    /**
     * Sets the value of the numberChannels property.
     * 
     */
    public void setNumberChannels(int value) {
        this.numberChannels = value;
    }

}
