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

package com.prototype.ot.microservices.spectralservice.services;

import com.prototype.ot.microservices.spectralservice.model.SpectralLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SpectralService {

    private BufferedReader bufferedReader;

    public SpectralService() {
    }

    public ArrayList<ArrayList<Double>> getSpectrum(int octile) {
        ArrayList<ArrayList<Double>> data = new ArrayList<>();
        ArrayList<Double> item;
        String line;
        try {
            this.loadFileResource(String.format("/spectral-data/SKY.SPE000%d.trim",
                                                octile));
            while ((line = this.bufferedReader.readLine()) != null) {
                item = new ArrayList<>();
                String[] items = line.split(" ");
                for (String i : items) {
                    item.add(Double.parseDouble(i));
                }
                data.add(item);
            }
            this.bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    // CSV ORDER line_id : species_id : s_name_noparens : chemical_name : orderedfreq : resolved_QNs : sijmu2 :
    // lovas_int : E_up_K : planet : ism_hotcore : ism_diffusecloud : comet : ism_darkcloud : extragalactic :
    // agb_ppn_pn : top20
    public ArrayList<SpectralLine> getSplatalogue() {
        ArrayList<SpectralLine> catalogue = new ArrayList<>();
        String row;
        try {
            this.loadFileResource("/spectral-data/splatalogue.csv");
            while ((row = this.bufferedReader.readLine()) != null) {
                SpectralLine line = SpectralLine.createFromSplatalogue(row);
                if (!line.getChemical_name().equals("UNIDENTIFIED")) {
                    catalogue.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalogue;
    }

    private void loadFileResource(String resourcePath) {
        this.bufferedReader = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream(resourcePath)
                ));
    }
}

