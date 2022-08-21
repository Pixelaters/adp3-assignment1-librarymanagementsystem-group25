package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import za.ac.cput.domain.ClientBook;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientBookControllerTest {
    @LocalServerPort private String portNumber;

    @Autowired private ClientBookController clientBookController;
    //@Autowired private TestRestTemplate restTemplate;
    private ClientBook clientBook, updateClientBook;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(clientBookController);
    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}