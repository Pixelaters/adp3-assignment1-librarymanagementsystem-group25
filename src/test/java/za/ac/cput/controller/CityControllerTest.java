package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.City;
import za.ac.cput.factory.CityFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Controller: CityControllerTest
 * Date: 2022/08/21
 * */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.class)
class CityControllerTest {

    @LocalServerPort
    private int portNumber;

    @Autowired
    private CityController cityController;

    @Autowired
    private TestRestTemplate restTemplate;

    private City city;

    private String urlBase;

    @BeforeEach
    void setUp(){
        assertNotNull(cityController);

        this.city = CityFactory.createCity("12","CPT","Mitchells Plain");

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementssystem/city/";

    }

    @Test
    void a_create() {
        String url = urlBase + "save_city";
        System.out.println(url);

        ResponseEntity<City> responseEntity = this.restTemplate.postForEntity(url,this.city, City.class);
        System.out.println(responseEntity);

        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

        System.out.println("City added successfully!!!!");
    }

    @Test
    void b_read() {
        String url = urlBase + "read/" + city.getId();
        ResponseEntity<City> responseEntity = this.restTemplate
                .getForEntity(url,City.class);

       assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
       assertNotNull(responseEntity.getBody());
    }

    @Test
    void c_update() {
        String url = urlBase + "update/" + city.getId();
        ResponseEntity<City> responseEntity = this.restTemplate
                .getForEntity(url,City.class);

        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void e_delete() {
        String url = urlBase + "delete/" + city.getId();
        this.restTemplate.delete(url);

        assertNull(url);
    }

    @Test
    void getAll() {
        String url = urlBase + "getAllCities";
        System.out.println(url);

        ResponseEntity<City[]> responseEntity = this.restTemplate.getForEntity(url,City[].class);
        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0)
        );
    }
}