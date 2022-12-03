package com.app.geolocalized.controller;

import com.app.geolocalized.handler.jpa.GeoLocalizationDataRepositoryHandler;
import com.app.geolocalized.model.entity.GeoLocalizationData;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/geolocalized")
@Getter
public class GeoController {

    private final GeoLocalizationDataRepositoryHandler geoLocalizationDataRepositoryHandler;

    public GeoController(GeoLocalizationDataRepositoryHandler geoLocalizationDataRepositoryHandler) {
        this.geoLocalizationDataRepositoryHandler = geoLocalizationDataRepositoryHandler;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String addLocalization(@RequestBody @Valid GeoLocalizationData geoLocalizationData) {
        return geoLocalizationDataRepositoryHandler.registerGeoLocalization(geoLocalizationData);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String check() {
        return "booba";
    }
}
