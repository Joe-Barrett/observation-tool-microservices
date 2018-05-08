package com.prototype.ot.microservices.spectralservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpectralResource {

    private SpectralService spectralService;

    public SpectralResource() {
        this.spectralService = new SpectralService();
    }

    @GetMapping(path = "/splatalogue")
    public ResponseEntity getSplatalogue() {
        
    }

    @GetMapping(path = "/{octile}")
    public ResponseEntity getSpectrum(@PathVariable int octile) {

    }

}
