package com.prototype.ot.microservices.spectralservice.resources;

import com.prototype.ot.microservices.spectralservice.services.SpectralService;
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
        return ResponseEntity.ok(this.spectralService.getSplatalogue());
    }

    @GetMapping(path = "/spectrum/{octile}")
    public ResponseEntity getSpectrum(@PathVariable int octile) {
        return ResponseEntity.ok(this.spectralService.getSpectrum(octile));
    }

}
