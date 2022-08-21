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
import za.ac.cput.domain.Address;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.ClientAddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientAddressControllerTest {
    @LocalServerPort private String portNumber;

    @Autowired private ClientAddressController clientAddressController;
    @Autowired private TestRestTemplate restTemplate;
    private ClientAddress clientAddress,updatedClientAddress;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(clientAddressController);

        this.clientAddress = ClientAddressFactory.createClientAddress("1", AddressFactory.createAddress("PT",
                "Weltevreden Estate","6","van Schoor Avenue",6810, CityFactory.createCity(
                        "CPT","Cape Town","Rondebosch")));

        this.updatedClientAddress = new ClientAddress.Builder().copy(clientAddress)
                .address(AddressFactory.createAddress(clientAddress.getAddress().getUnitNumber(),"Tiger Hill",
                        "52","Court Street",7306,CityFactory.createCity(
                                clientAddress.getAddress().getCity().getId(),clientAddress.getAddress().getCity().getName(),
                                "Mowbray")))
                .build();

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/clientAddress/";

    }

    @Test
    void a_create() {
        String url = urlBase + "save_ClientAddress";
        System.out.println(url);

        ResponseEntity<ClientAddress> responseEntity = this.restTemplate
                .postForEntity(url,this.clientAddress,ClientAddress.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

        System.out.println("Client address saved");

    }

    @Test
    void b_read() {


    }

    @Test
    void c_update() {
    }

    @Test
    void d_delete() {
    }

    @Test
    void e_getAll() {
    }
}