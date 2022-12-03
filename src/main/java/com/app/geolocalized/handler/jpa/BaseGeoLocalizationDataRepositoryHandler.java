package com.app.geolocalized.handler.jpa;

import com.app.geolocalized.model.entity.GeoLocalizationData;
import com.app.geolocalized.repository.GeoLocalizationDataRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

@Service
@Getter
public class BaseGeoLocalizationDataRepositoryHandler implements GeoLocalizationDataRepositoryHandler {

    private final GeoLocalizationDataRepository geoLocalizationDataRepository;

    public BaseGeoLocalizationDataRepositoryHandler(GeoLocalizationDataRepository geoLocalizationDataRepository) {
        this.geoLocalizationDataRepository = geoLocalizationDataRepository;
    }

    @Override
    public String registerGeoLocalization(GeoLocalizationData geoLocalizationData) {
        geoLocalizationDataRepository.save(geoLocalizationData);
        StringJoiner stringJoiner = new StringJoiner(" ");
        return stringJoiner
                .add("Localization of device")
                .add(geoLocalizationData.getDeviceId())
                .add("has been registered at")
                .add(
                        geoLocalizationData.getTimestamp().getHour()
                        + ":" + geoLocalizationData.getTimestamp().getMinute()
                        + ":" + geoLocalizationData.getTimestamp().getSecond()
                )
                .toString();
    }
}
