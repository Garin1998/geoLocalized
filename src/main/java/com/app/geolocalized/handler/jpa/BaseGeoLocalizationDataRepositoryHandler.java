package com.app.geolocalized.handler.jpa;

import com.app.geolocalized.model.entity.GeoLocalizationData;
import com.app.geolocalized.repository.GeoLocalizationDataRepository;
import com.app.geolocalized.utils.BasicUtils;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * Class, which is used for implementation of {@link GeoLocalizationDataRepository interface} and handle requests for storing localization of device.
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since JDK 17
 */
@Service
@Getter
public class BaseGeoLocalizationDataRepositoryHandler implements GeoLocalizationDataRepositoryHandler {

    private final GeoLocalizationDataRepository geoLocalizationDataRepository;

    public BaseGeoLocalizationDataRepositoryHandler(GeoLocalizationDataRepository geoLocalizationDataRepository) {
        this.geoLocalizationDataRepository = geoLocalizationDataRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String registerGeoLocalization(GeoLocalizationData geoLocalizationData) {
        geoLocalizationDataRepository.save(geoLocalizationData);
        StringJoiner stringJoiner = new StringJoiner(" ");

        BasicUtils.logger.info(geoLocalizationData.toString());
        return stringJoiner.add("Localization of device").add(geoLocalizationData.getDeviceId()).add("has been registered at").add(geoLocalizationData.getTimestamp().getHour() + ":" + geoLocalizationData.getTimestamp().getMinute() + ":" + geoLocalizationData.getTimestamp().getSecond()).toString();
    }
}
