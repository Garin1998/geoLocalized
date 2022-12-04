package com.app.geolocalized.controller;

import com.app.geolocalized.handler.jpa.GeoLocalizationDataRepositoryHandler;
import com.app.geolocalized.model.entity.GeoLocalizationData;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Class which is used as controller for REST service for repositories.
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since JDK 17
 */
@RestController
@RequestMapping("/geolocalized")
@Getter
public class GeoController {

    private final GeoLocalizationDataRepositoryHandler geoLocalizationDataRepositoryHandler;

    public GeoController(GeoLocalizationDataRepositoryHandler geoLocalizationDataRepositoryHandler) {
        this.geoLocalizationDataRepositoryHandler = geoLocalizationDataRepositoryHandler;
    }

    /**
     * Handle HTTP request method POST on /geolocalized/add path, which save Geo localization data in JSON format to database
     * and produce message.
     *
     * @param geoLocalizationData Object of {@link GeoLocalizationData Class}.
     * @return String with information about deviceID and timestamp in hh:mm:ss format when information are stored.
     */
    @PostMapping(value = "/add", consumes = "application/json", produces = "text/plain")
    @ResponseStatus(HttpStatus.CREATED)
    public String addLocalization(@RequestBody @Valid GeoLocalizationData geoLocalizationData) {
        return geoLocalizationDataRepositoryHandler.registerGeoLocalization(geoLocalizationData);
    }

    /**
     * Handle HTTP request method POST on base path. Used only for unit testing purpose in authentication process.
     * @return Object of {@link String Class} with message.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String check() {
        return "home";
    }
}
