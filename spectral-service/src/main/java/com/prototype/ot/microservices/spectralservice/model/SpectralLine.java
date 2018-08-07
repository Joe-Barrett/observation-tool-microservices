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

package com.prototype.ot.microservices.spectralservice.model;

public class SpectralLine {

    // line_id : species_id : s_name_noparens : chemical_name : orderedfreq : resolved_QNs : sijmu2 :
    // lovas_int : E_up_K : planet : ism_hotcore : ism_diffusecloud : comet : ism_darkcloud : extragalactic :
    // agb_ppn_pn : top20
    private Integer line_id;
    private Integer species_id;
    private String s_name_noparens;
    private String chemical_name;
    private Double orderedfreq;
    private String resolved_QNs;
    private Double sijmu2;
    private Double E_up_K;
    private String lovas_int;
    private Integer top20;

    private boolean planet = false;
    private boolean ism_hotcore = false;
    private boolean ism_diffusecloud = false;
    private boolean comet = false;
    private boolean ism_darkcloud = false;
    private boolean extragalactic = false;
    private boolean agb_ppn_pn = false;

    public SpectralLine() {
    }

    public static SpectralLine createFromSplatalogue(String row) {
        SpectralLine line = new SpectralLine();
        String[] entries = row.split(":");
        line.setLine_id(Integer.valueOf(entries[0]));
        line.setSpecies_id(Integer.valueOf(entries[1]));
        line.setS_name_noparens(entries[2]);
        line.setChemical_name(entries[3]);
        line.setOrderedfreq(Double.valueOf(entries[4]));
        line.setResolved_QNs(entries[5]);
        line.setSijmu2(entries[6].equals("NULL") ? null : Double.valueOf(entries[6]));
        line.setLovas_int(entries[8]);
//        line.setE_up_K(entries[7].equals("NULL") || entries[7].trim().equals("b") ? null : Double.valueOf(entries[7]));
        line.setPlanet(Boolean.parseBoolean(entries[9]));
        line.setIsm_hotcore(Boolean.parseBoolean(entries[10]));
        line.setIsm_diffusecloud(Boolean.parseBoolean(entries[11]));
        line.setComet(Boolean.parseBoolean(entries[12]));
        line.setIsm_darkcloud(Boolean.parseBoolean(entries[13]));
        line.setExtragalactic(Boolean.parseBoolean(entries[14]));
        line.setAgb_ppn_pn(Boolean.parseBoolean(entries[15]));
        line.setTop20(Integer.valueOf(entries[16]));
        return line;
    }

    public Integer getLine_id() {
        return line_id;
    }

    public void setLine_id(Integer line_id) {
        this.line_id = line_id;
    }

    public Integer getSpecies_id() {
        return species_id;
    }

    public void setSpecies_id(Integer species_id) {
        this.species_id = species_id;
    }

    public String getS_name_noparens() {
        return s_name_noparens;
    }

    public void setS_name_noparens(String s_name_noparens) {
        this.s_name_noparens = s_name_noparens;
    }

    public String getChemical_name() {
        return chemical_name;
    }

    public void setChemical_name(String chemical_name) {
        this.chemical_name = chemical_name;
    }

    public Double getOrderedfreq() {
        return orderedfreq;
    }

    public void setOrderedfreq(Double orderedfreq) {
        this.orderedfreq = orderedfreq;
    }

    public String getResolved_QNs() {
        return resolved_QNs;
    }

    public void setResolved_QNs(String resolved_QNs) {
        this.resolved_QNs = resolved_QNs;
    }

    public Double getSijmu2() {
        return sijmu2;
    }

    public void setSijmu2(Double sijmu2) {
        this.sijmu2 = sijmu2;
    }

    public Double getE_up_K() {
        return E_up_K;
    }

    public void setE_up_K(Double e_up_K) {
        E_up_K = e_up_K;
    }

    public String getLovas_int() {
        return lovas_int;
    }

    public void setLovas_int(String lovas_int) {
        this.lovas_int = lovas_int;
    }

    public Integer getTop20() {
        return top20;
    }

    public void setTop20(Integer top20) {
        this.top20 = top20;
    }

    public boolean isPlanet() {
        return planet;
    }

    public void setPlanet(boolean planet) {
        this.planet = planet;
    }

    public boolean isIsm_hotcore() {
        return ism_hotcore;
    }

    public void setIsm_hotcore(boolean ism_hotcore) {
        this.ism_hotcore = ism_hotcore;
    }

    public boolean isIsm_diffusecloud() {
        return ism_diffusecloud;
    }

    public void setIsm_diffusecloud(boolean ism_diffusecloud) {
        this.ism_diffusecloud = ism_diffusecloud;
    }

    public boolean isComet() {
        return comet;
    }

    public void setComet(boolean comet) {
        this.comet = comet;
    }

    public boolean isIsm_darkcloud() {
        return ism_darkcloud;
    }

    public void setIsm_darkcloud(boolean ism_darkcloud) {
        this.ism_darkcloud = ism_darkcloud;
    }

    public boolean isExtragalactic() {
        return extragalactic;
    }

    public void setExtragalactic(boolean extragalactic) {
        this.extragalactic = extragalactic;
    }

    public boolean isAgb_ppn_pn() {
        return agb_ppn_pn;
    }

    public void setAgb_ppn_pn(boolean agb_ppn_pn) {
        this.agb_ppn_pn = agb_ppn_pn;
    }
}
