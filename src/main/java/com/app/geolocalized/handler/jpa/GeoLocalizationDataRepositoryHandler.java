package com.app.geolocalized.handler.jpa;


import com.app.geolocalized.model.entity.GeoLocalizationData;

public interface GeoLocalizationDataRepositoryHandler {
    String registerGeoLocalization(GeoLocalizationData geoLocalizationData);
}
