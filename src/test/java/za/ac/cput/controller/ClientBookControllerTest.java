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
import za.ac.cput.domain.ClientBook;
import za.ac.cput.factory.BookFactory;
import za.ac.cput.factory.ClientBookFactory;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.factory.NameFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientBookControllerTest {
    @LocalServerPort private String portNumber;

    @Autowired private ClientBookController clientBookController;
    @Autowired private TestRestTemplate restTemplate;
    private ClientBook clientBook, updateClientBook;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(clientBookController);

        this.clientBook = ClientBookFactory.createClientBook(ClientFactory.createClient("1",
                NameFactory.createName("Breyton","Sean","Ernstzen"),true),
                BookFactory.CreateBook("ZZ1","Finding Gobby","James Franke","fiction"));

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/clientBook/";
    }

    @Test
    void a_create() {
        String url = urlBase + "save_clientbook";
        System.out.println(url);

        ResponseEntity<ClientBook> responseEntity = this.restTemplate
                .postForEntity(url,this.clientBook,ClientBook.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

        System.out.println("Client book saved");
    }

    @Test
    void b_read() {
        String url = urlBase + "read_clientBook/" + clientBook.getClient().getClientId();
        System.out.println(url);

        ResponseEntity<ClientBook> responseEntity = this.restTemplate
                .getForEntity(url,ClientBook.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())

        );
    }

    @Test
    void c_update() {
        String url = urlBase + "update_clientbook";
        System.out.println(url);

        ResponseEntity<ClientBook> responseEntity = this.restTemplate
                .postForEntity(url,this.updateClientBook, ClientBook.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertNotNull(responseEntity),
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

        System.out.println("Client book details updated");
    }

    @Test
    void d_delete() {
        String url = urlBase + "delete_clientbook/" + updateClientBook.getClient().getClientId();
        System.out.println(url);

        this.restTemplate.delete(url);

        assertAll(
                () -> assertSame("1",updateClientBook.getClient().getClientId())
        );

        System.out.println("Client book deleted");

    }

    @Test
    void e_getAll() {
        String url = urlBase + "getAll_clientbooks";
        System.out.println(url);

        ResponseEntity<ClientBook[]> responseEntity = this.restTemplate
                .getForEntity(url,ClientBook[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0),
                () -> assertNotNull(responseEntity)
        );
    }
}