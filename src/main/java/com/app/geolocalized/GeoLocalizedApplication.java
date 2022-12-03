package com.app.geolocalized;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GeoLocalizedApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoLocalizedApplication.class, args);
	}

}
