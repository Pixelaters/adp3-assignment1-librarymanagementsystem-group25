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
import za.ac.cput.domain.Client;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ContactControllerTest {
    @LocalServerPort private String portNumber;

    @Autowired private ClientController contactController;
    @Autowired private TestRestTemplate restTemplate;
    private Contact contact,updatedContact;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(contactController);

        this.contact = ContactFactory.createContact("C1","abc@gmail.com","0713514210","0634048406");
        this.updatedContact = new Contact.Builder().copy(contact)
                .setContactId(contact.getContactId())
                .setEmail(contact.getEmail())
                .setCell("0818424491")
                .setNextOfKin(contact.getNextOfKin())
                .build();

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/contact/";

    }

    @Test
    void a_create() {
        String url = urlBase + "save_contact";
        System.out.println(url);

        ResponseEntity<Contact> responseEntity = this.restTemplate
                .postForEntity(url,this.contact,Contact.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

        System.out.println("Contact saved!");
    }

    @Test
    void b_update() {
        String url  = urlBase + "update_contact";
        System.out.println(url);

        ResponseEntity<Contact> responseEntity = this.restTemplate
                .postForEntity(url,this.updatedContact,Contact.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

        System.out.println("Contact updated!");
    }

    @Test
    void h_delete() {
        String url = urlBase + "deleteContact/" + updatedContact.getContactId();
        System.out.println(url);

        this.restTemplate.delete(url);

        assertAll(
                () -> assertSame("C1",updatedContact.getContactId()),
                () -> assertNotSame("1",updatedContact.getContactId())
        );
        System.out.println("Delete success");

    }

    @Test
    void c_getAll() {
        String url = urlBase + "getAllContacts";
        System.out.println(url);

        ResponseEntity<Contact[]> responseEntity = this.restTemplate
                .getForEntity(url,Contact[].class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertFalse(responseEntity.getBody().length == 0),
                () -> assertNotNull(responseEntity)
        );
        System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));
    }

    @Test
    void d_findByName() {
        String url = urlBase + "findByCell/" + updatedContact.getContactId();
        System.out.println(url);

        ResponseEntity<Contact[]> responseEntity = this.restTemplate
                .getForEntity(url,Contact[].class);
        //System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity)
        );

        System.out.println(updatedContact.getCell());
    }

    @Test
    void e_findByEmail() {
        String url = urlBase + "findByEmail/" + updatedContact.getContactId();
        System.out.println(url);

        ResponseEntity<Contact[]> responseEntity = this.restTemplate
                .getForEntity(url,Contact[].class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity)
        );

        System.out.println(updatedContact.getEmail());
    }

    @Test
    void g_findByContactId() {
        String url = urlBase + "findByContactId/" + updatedContact.getContactId();
        System.out.println(url);

        ResponseEntity<Contact> responseEntity = this.restTemplate
                .getForEntity(url,Contact.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity)
        );

        System.out.println(updatedContact.getContactId());
    }
}