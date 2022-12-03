package com.app.geolocalized.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class GeoLocalizationData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long LogID;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @NotBlank(message = "DeviceId must be provided")
    private String deviceId;

    @Min(value = -90000000, message = "Latitude cannot be greater than 90 degree South")
    @Max(value = 90000000, message = "Latitude cannot be greater than 90 degree North")
    private int latitude;

    @Min(value = -180000000, message = "Longitude cannot be greater than 180 degree West")
    @Max(value = 180000000, message = "Longitude cannot be greater than 180 degree East")
    private int longitude;
}
