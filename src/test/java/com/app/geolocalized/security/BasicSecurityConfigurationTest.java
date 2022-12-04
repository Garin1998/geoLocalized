package com.app.geolocalized.security;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicSecurityConfigurationTest {
    @LocalServerPort
    private int port = 8080;

    @PostConstruct
    public void init() {
        RestAssured.baseURI = "http://localhost:" + port;
        RestAssured.basePath = "/geolocalized";
    }

    @Test
    public void givenAuthenticated_whenCallingCheckMethod_thenReturn200() {

        Response actualResponse = RestAssured.given().auth().basic("user", "password").get().andReturn();
        assertEquals(HttpStatus.OK.value(), actualResponse.getStatusCode());
    }

    @Test
    public void givenUnauthenticated_whenCallingCheckMethod_thenReturn401() {
        Response actualResponse = RestAssured.given().auth().basic("user123", "password123").get().andReturn();
        assertEquals(HttpStatus.UNAUTHORIZED.value(), actualResponse.getStatusCode());
    }
}
