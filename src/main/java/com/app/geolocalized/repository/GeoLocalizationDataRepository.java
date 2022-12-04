package com.app.geolocalized.repository;

import com.app.geolocalized.model.entity.GeoLocalizationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for providing access to ORM via Spring Data for {@link GeoLocalizationData repository}.
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since JDK 17
 */
@Repository
public interface GeoLocalizationDataRepository extends JpaRepository<GeoLocalizationData, Long> {
}
