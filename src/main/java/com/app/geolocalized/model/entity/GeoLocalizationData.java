package com.app.geolocalized.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Class, which contains entries for geo localization data.
 * Simple entry provide device's ID, its latitude, longitude and timestamp about when data was sent.
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since 17
 */
@Entity
@Getter
@Setter
public class GeoLocalizationData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long LogID;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @NotBlank(message = "DeviceId must be provided")
    private String deviceId;

    @Range(min = -90000000L, max = 90000000L, message = "Latitude must be between 90 South and 90 North degrees")
    @NotNull(message = "Latitude must be provided")
    private String latitude;

    @Range(min = -180000000L, max = 180000000L, message = "Longitude must be between 180 West and 180 East degrees")
    @NotNull(message = "Longitude must be provided")
    private String longitude;


    public String toString() {
        return "GeoLocalizationData(LogID="
                + this.getLogID()
                + ", timestamp=" + this.getTimestamp()
                + ", deviceId=" + this.getDeviceId()
                + ", latitude=" + "****"
                + ", longitude=" + "****"
                + ")";
    }
}
