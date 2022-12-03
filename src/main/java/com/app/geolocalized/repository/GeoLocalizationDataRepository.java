package com.app.geolocalized.repository;

import com.app.geolocalized.model.entity.GeoLocalizationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoLocalizationDataRepository extends JpaRepository<GeoLocalizationData, Long> {
}
