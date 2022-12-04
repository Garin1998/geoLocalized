package com.app.geolocalized.handler.jpa;


import com.app.geolocalized.model.entity.GeoLocalizationData;

/**
 * Interface which is used for using methods implemented in {@link BaseGeoLocalizationDataRepositoryHandler Class}
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since JDK 17
 */
public interface GeoLocalizationDataRepositoryHandler {

    /**
     * Add information about localization to storage, which was sent from device.
     *
     * @param geoLocalizationData Object of {@link GeoLocalizationData Class}
     *
     * @return String with information about deviceID and timestamp in hh:mm:ss format when information are stored.
     */
    String registerGeoLocalization(GeoLocalizationData geoLocalizationData);
}
