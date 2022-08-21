package za.ac.cput.controller;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Controller: LibrarianAddressControllerTest
 * Date: 2022/08/21
 * */
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
import za.ac.cput.domain.LibrarianAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.LibrarianAddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.class)
class LibrarianAddressControllerTest {

    @LocalServerPort
    private int portNumber;

    @Autowired
    private LibrarianAddressController librarianAddressController;

    @Autowired
    private TestRestTemplate restTemplate;

    private LibrarianAddress librarianAddress;

    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(librarianAddressController);

        this.librarianAddress = LibrarianAddressFactory.createLibrarianAddress("2",
                AddressFactory.createAddress("","","89","Raeece",8989,
                        CityFactory.createCity("12","CPT","Mitchells Plain")));

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagement/librarianAddress/";
    }

    @Test
    void a_create() {
        String url = urlBase + "save_librarian";
        System.out.println(url);

        ResponseEntity<LibrarianAddress> responseEntity = this.restTemplate
                .postForEntity(url,this.librarianAddress, LibrarianAddress.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
        System.out.println("New librarian address created successfully");
    }

    @Test
    void b_read() {
        String url = urlBase + "read/" + librarianAddress.getLibrarianId();
        ResponseEntity<LibrarianAddress> responseEntity = this.restTemplate.getForEntity(url, LibrarianAddress.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Test
    void c_update() {
        String url = urlBase + "update/" + librarianAddress.getLibrarianId();
        ResponseEntity<LibrarianAddress> responseEntity = this.restTemplate
                .getForEntity(url, LibrarianAddress.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Test
    void e_delete() {
        String url = urlBase + "delete/" + librarianAddress.getLibrarianId();
        this.restTemplate.delete(url);

        assertNull(url);
    }

    @Test
    void d_getAll() {
        String url = urlBase + "getAll_LibrarianAddresses";
        System.out.println(url);

        ResponseEntity<LibrarianAddress[]> responseEntity = this.restTemplate.getForEntity(url,LibrarianAddress[].class);
        System.out.println(Arrays.asList(responseEntity.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0)
        );
    }
}