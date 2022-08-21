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
import za.ac.cput.factory.ClientBookFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientBookControllerTest {
    @LocalServerPort private String portNumber;
    @Autowired private ClientBookController clientBookController;
    @Autowired private TestRestTemplate testRestTemplate;

    private ClientBook clientBook, updateClientBook;
    private String urlBase;



    @BeforeEach
    void setUp() {
        assertNotNull(clientBookController);

        this.clientBook = ClientBookFactory.createClientBook("1","A1");

        this.updateClientBook = new ClientBook.Builder().copy(clientBook)
                .bookId("ZZ3")
                .build();

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/clientBook/";
    }

    @Test
    void a_create() {
        String url = urlBase + "save_clientbook";
        System.out.println(url);

        ResponseEntity<ClientBook> responseEntity = this.testRestTemplate
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
        String url = urlBase + "read_clientBook/" + clientBook.getClientId();
        System.out.println(url);

        ResponseEntity<ClientBook> responseEntity = this.testRestTemplate
                .getForEntity(url,ClientBook.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

    }

    @Test
    void update() {
        String url = urlBase + "update_clientbook";
        System.out.println(url);

        ResponseEntity<ClientBook> responseEntity = this.testRestTemplate.
                postForEntity(url,this.updateClientBook,ClientBook.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

        System.out.println("Client book details updated");

    }

    @Test
    void delete() {
        String url = urlBase + "delete_clientbook/" + updateClientBook.getClientId();
        System.out.println(url);

        this.testRestTemplate.delete(url);

        assertAll(
                () -> assertSame("1",updateClientBook.getClientId()),
                () -> assertNotNull(updateClientBook.getClientId()),
                () -> assertNotNull(updateClientBook.getBookId())
        );

        System.out.println("Delete success");
    }

    @Test
    void getAll() {
        String url = urlBase + "getAll_clientbooks";
        System.out.println(url);

        ResponseEntity<ClientBook[]> responseEntity = this.testRestTemplate
                .getForEntity(url,ClientBook[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0),
                () -> assertNotNull(responseEntity)
        );

    }
}