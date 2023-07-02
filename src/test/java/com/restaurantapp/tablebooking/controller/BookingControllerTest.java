package com.restaurantapp.tablebooking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingControllerTest {
    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getBookingsByDate() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/bookings/date/2023-01-01").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
    @Test
    public void getBookingsByCustomerId() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/bookings/customer/01").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}
