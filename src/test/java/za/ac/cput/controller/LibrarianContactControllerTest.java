package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.LibrarianContact;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.LibrarianContactFactory;
import za.ac.cput.factory.LibrarianFactory;


import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LibrarianContactControllerTest {
    @LocalServerPort
    private int portNumber;
    @Autowired
    private LibrarianContactController librarianContactController;
    @Autowired
    private TestRestTemplate restTemplate;

    private LibrarianContact librarianContact,updatelibrarianContact;
    private String urlbase;

    @BeforeEach
    void setUp(){
        assertNotNull(librarianContact);
        this.librarianContact= LibrarianContactFactory.createContact(LibrarianFactory.createLibrarian("345","librarian",
                "Lois","","Bricks"),
                ContactFactory.createContact("2345","business@gmail.com","021456556","Logan"));

        this.urlbase= "http:/localhost:" + this.portNumber+"/librarymanagementsystem/librariancontact/";


    }

    @Test
    void create() {
        String url = urlbase + "save_librarianContact/";
        System.out.println(url);

        ResponseEntity<LibrarianContact> responseEntity = this.restTemplate.postForEntity(url,this.librarianContact,LibrarianContact.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
        System.out.println("contact created");


    }

    @Test
    void read() {
        String url = urlbase +"read_librarianContact/" + librarianContact.getLibrarian().getStaffId();
        System.out.println(url);

        ResponseEntity<LibrarianContact> responseEntity= this.restTemplate.getForEntity(url,LibrarianContact.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );


    }

    @Test
    void update() {
        String url = urlbase + "update_librarianContact";
        System.out.println(url);

        ResponseEntity<LibrarianContact> responseEntity = this.restTemplate.postForEntity(url,updatelibrarianContact,LibrarianContact.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertNotNull(responseEntity),
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
        System.out.println("contact updated");
    }

    @Test
    void delete() {
        String url = urlbase +"delete_librarianContact/" + updatelibrarianContact.getLibrarian().getStaffId();
        System.out.println(url);

        this.restTemplate.delete(url);
         assertSame("456",updatelibrarianContact.getLibrarian().getStaffId());

        System.out.println("contact deleted");

    }

    @Test
    void getAll() {
        String url = urlbase +"getLibrariancontact/";
        System.out.println(url);

        ResponseEntity<LibrarianContact[]> response = this.restTemplate.getForEntity(url,LibrarianContact[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertTrue(response.getBody().length==0),
                () -> assertNotNull(response)
        );
    }
}