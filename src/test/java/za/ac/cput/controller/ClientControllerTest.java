package za.ac.cput.controller;
/*
    Breyton Ernstzen (217203027)
    ADP372S
    Capstone Project
 */
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
import za.ac.cput.domain.Client;
import za.ac.cput.factory.BookFactory;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientControllerTest {
    @LocalServerPort
    private int portNumber;
    @Autowired
    private ClientController clientController;
    @Autowired
    private TestRestTemplate restTemplate;

    private Client client1,client2;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(clientController);

        this.client1 = ClientFactory.createClient("1", NameFactory.createName("Breyton","Sean",
                "Ernstzen"), BookFactory.CreateBook("AA20","Finding Gobby","Anne Lange",
                        "fiction"),true);

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/client/";

//        this.client2 = ClientFactory.createClient("2",NameFactory.createName("Ziyaad","Petersen"),
//                BookFactory.CreateBook("PXL1","Pixelated World","Kevin Franks","science-fiction"),
//                true);
    }

    @Test
    void a_create() {
        String url = urlBase + "save_client";
        System.out.println(url);

        ResponseEntity<Client> responseEntity = this.restTemplate
                .postForEntity(url,this.client1,Client.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
        System.out.println("Client inserted successfully");

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

    @Test
    void f_findById() {
    }
}