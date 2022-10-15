package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.factory.NameFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientControllerTest {
    @LocalServerPort private int portNumber;
    @Autowired private ClientController clientController;
    @Autowired private TestRestTemplate restTemplate;
    private Client client,updatedClient;
    private String urlBase;

    public static String USERNAME = "user";
    public static String PASSWORD = "password";

    @BeforeEach
    void setUp() {
        assertNotNull(clientController);

        this.client = ClientFactory.createClient("1", NameFactory.createName("Breyton","Sean",
                "Ernstzen"));

        this.updatedClient = ClientFactory.createClient("2", NameFactory.createName("Breyton","Sean",
                "Ernstzen"));

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/client/";
    }

    @Test
    void a_create() {
        String url = urlBase + "save_client";
        System.out.println(url);

        ResponseEntity<Client> clientResponseEntity = this.restTemplate
                .postForEntity(url,this.client,Client.class);
        System.out.println(clientResponseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,clientResponseEntity.getStatusCode()),
                () -> assertNotNull(clientResponseEntity.getBody())
        );

        System.out.println("Client saved!");

    }

    //this test method needs fixing
    @Test
    void b_read() {
        String url = urlBase + "readClient/" + client.getClientId();
        System.out.println(url);

        ResponseEntity<Client> clientResponseEntity = this.restTemplate
                .getForEntity(url,Client.class);
        System.out.println(clientResponseEntity);
        //System.out.println(Arrays.asList(Objects.requireNonNull(clientResponseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,clientResponseEntity.getStatusCode()),
                () -> assertNotNull(clientResponseEntity.getBody())

        );

    }

    @Test
    void c_update() {
        String url = urlBase + "update_client";
        System.out.println(url);

        ResponseEntity<Client> clientResponseEntity = this.restTemplate
                .postForEntity(url,this.updatedClient,Client.class);
        System.out.println(clientResponseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,clientResponseEntity.getStatusCode()),
                () -> assertNotNull(clientResponseEntity.getBody())
        );

        System.out.println("Client details updated");
    }

    @Test
    void d_delete() {
        String url = urlBase + "deleteClient/" + updatedClient.getClientId();
        System.out.println(url);

        this.restTemplate.delete(url);

        assertAll(
                () -> assertSame("1",updatedClient.getClientId()),
                () -> assertNotNull(updatedClient.getName())

        );

        System.out.println("Delete success!");

    }

    @Test
    void e_getAll() {
        String url = urlBase + "getAll_clients";
        System.out.println(url);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);

        ResponseEntity<String> responseEntity = this.restTemplate
                .withBasicAuth(USERNAME,PASSWORD)
                .exchange(url, HttpMethod.GET,entity,String.class);
        //System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()),
                () -> assertNotNull(responseEntity)
        );

        System.out.println("Show all");
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());

    }

    //come back to this test.It doesn't work 100%.
    @Test
    void f_findById() {
        String url = urlBase + "find_ClientBy_Id";
        System.out.println(url);

        ResponseEntity<Client[]> responseEntity = this.restTemplate
                .getForEntity(url,Client[].class);
        //System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity)
        );



    }
}