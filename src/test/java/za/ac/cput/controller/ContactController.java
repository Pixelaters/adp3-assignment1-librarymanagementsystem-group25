package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContactController {
    @LocalServerPort
    private int portNumber;
    @Autowired
    private ContactController contactController;
    @Autowired private TestRestTemplate restTemplate;
    private Contact contact,updatedContact;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(contactController);

        this.contact = ContactFactory.createContact("1","GooseBumps@bainscorp.com", "0833806387", "0833806387");

        this.updatedContact = new Contact.Builder().copy(contact)
                .setCell("0298213083")
                .build();

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/contact/";
    }

    @Test
    void a_create() {
        String url = urlBase + "saveContact";
        System.out.println(url);

        ResponseEntity<Contact> contactResponseEntity = this.restTemplate
                .postForEntity(url,this.contact,Contact.class);
        System.out.println(contactResponseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,contactResponseEntity.getStatusCode()),
                () -> assertNotNull(contactResponseEntity.getBody())
        );

        System.out.println("Contact saved!");

    }

    //this test method needs fixing
    @Test
    void b_read() {
        String url = urlBase + "readBook/" + contact.getContactId();
        System.out.println(url);

        ResponseEntity<Contact> contactResponseEntity = this.restTemplate
                .getForEntity(url,Contact.class);
        System.out.println(contactResponseEntity);
        //System.out.println(Arrays.asList(Objects.requireNonNull(clientResponseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,contactResponseEntity.getStatusCode()),
                () -> assertNotNull(contactResponseEntity.getBody())

        );

    }

    @Test
    void c_update() {
        String url = urlBase + "update_book";
        System.out.println(url);

        ResponseEntity<Contact> bookResponseEntity = this.restTemplate
                .postForEntity(url,this.updatedContact,Contact.class);
        System.out.println(bookResponseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,bookResponseEntity.getStatusCode()),
                () -> assertNotNull(bookResponseEntity.getBody())
        );

        System.out.println("Contact details updated");
    }

    @Test
    void d_delete() {
        String url = urlBase + "deleteContact/" + updatedContact.getContactId();
        System.out.println(url);

        this.restTemplate.delete(url);

        assertAll(
                () -> assertSame("1",updatedContact.getContactId()),
                () -> assertNotNull(updatedContact.getCell())

        );

        System.out.println("Delete success!");

    }

    @Test
    void e_getAll() {
        String url = urlBase + "getAllContacts";
        System.out.println(url);

        ResponseEntity<Contact[]> responseEntity = this.restTemplate
                .getForEntity(url,Contact[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0),
                () -> assertNotNull(responseEntity)
        );

    }

    //come back to this test.It doesn't work 100%.
    @Test
    void f_findById() {
        String url = urlBase + "findContactById";
        System.out.println(url);

        ResponseEntity<Contact[]> responseEntity = this.restTemplate
                .getForEntity(url,Contact[].class);
        //System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity)
        );



    }
}
