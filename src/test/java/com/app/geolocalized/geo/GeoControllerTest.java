package com.app.geolocalized.geo;

import com.app.geolocalized.testUtils.TestUtils;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GeoControllerTest {

    @LocalServerPort
    private int port = 8080;

    @PostConstruct
    public void init() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @Test
    public void whenAuthIsNotOK_thenReturn401() {
        RestAssured.basePath = "/geolocalized/add";
        JsonObject body = TestUtils
                .createJSONBodyWithGeoLocalizationData("12345", 505430, 1423412);

        Response response = RestAssured
                .given()
                .body(body.toString()).contentType("application/json")
                .auth().basic("user123", "password123")
                .post().andReturn();

        assertEquals(HttpStatus.UNAUTHORIZED.value(), response.getStatusCode());
    }

    @Test
    public void whenAuthIsOKAndAddLocalizationIsSuccessful_thenReturn201() {
        RestAssured.basePath = "/geolocalized/add";
        JsonObject body = TestUtils
                .createJSONBodyWithGeoLocalizationData("12345", 505430, 1423412);

        Response response = RestAssured
                .given()
                .body(body.toString()).contentType("application/json")
                .auth().basic("user", "password")
                .post().andReturn();

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenAuthIsOKAndAddLocalizationHaveNotJsonContentType_thenReturn415() {
        RestAssured.basePath = "/geolocalized/add";

        Response response = RestAssured
                .given()
                .body("").contentType("text/plain")
                .auth().basic("user", "password")
                .post().andReturn();

        assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), response.getStatusCode());
    }

    @Test
    public void whenAuthIsOKAndAddLocalizationHaveMalformedJson_thenReturn403() {
        RestAssured.basePath = "/geolocalized/add";
        String malformedJson = "{'deviceId': abcd,}";

        Response response = RestAssured
                .given()
                .body(malformedJson).contentType("application/json")
                .auth().basic("user", "password")
                .post().andReturn();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    @Test
    public void whenAuthIsOKAndAddLocalizationHaveErrorsInFields_thenReturn403() {
        RestAssured.basePath = "/geolocalized/add";

        JsonObject body = TestUtils
                .createJSONBodyWithGeoLocalizationData("", -1111505430, 1111423412);

        HashMap<String, String> errors = new HashMap<>();
        errors.put("latitude", "Latitude cannot be greater than 90 degree South");
        errors.put("deviceId", "DeviceId must be provided");
        errors.put("longitude", "Longitude cannot be greater than 180 degree East");

        String expectedResponse = TestUtils.createJsonFromStrings(errors).toString();

        Response response = RestAssured
                .given()
                .body(body.toString()).contentType("application/json")
                .auth().basic("user", "password")
                .post().andReturn();

        assertEquals(expectedResponse, response.getBody().print());

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }
}
