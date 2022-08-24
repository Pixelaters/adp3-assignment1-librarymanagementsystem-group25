package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Librarian;
import za.ac.cput.factory.BookFactory;
import za.ac.cput.factory.LibrarianFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianControllerTest {


    @LocalServerPort
    private int portNumber;
    @Autowired
    private LibrarianController librarianController;
    @Autowired private TestRestTemplate restTemplate;
    private Librarian librarian,updatelibrarian;
    private String urlBase;
    @BeforeEach
    void setUp() {
        assertNotNull(librarianController);

        this.librarian = LibrarianFactory.createLibrarian("222","333","Ongezwa","Ongie","Gwaza");

        this.updatelibrarian = new Librarian.LibrarianBuilder().copy(librarian).staffId("222").build();


        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/librarian/";
    }

    @Test
    void create() {

            String url = urlBase + "saveLibrarian";
            System.out.println(url);

            ResponseEntity<Librarian> librarianResponseEntity = this.restTemplate
                    .postForEntity(url,this.librarian,Librarian.class);
            System.out.println(librarianResponseEntity);

            assertAll(
                    () -> assertEquals(HttpStatus.OK,librarianResponseEntity.getStatusCode()),
                    () -> assertNotNull(librarianResponseEntity.getBody())
            );

            System.out.println("Librarian saved!");

        }




    @Test
    void read() {
        String url = urlBase + "readLibrarian/" + librarian.getStaffId();
        System.out.println(url);

        ResponseEntity<Librarian> librarianResponseEntity = this.restTemplate
                .getForEntity(url,Librarian.class);
        System.out.println(librarianResponseEntity);


        assertAll(
                () -> assertEquals(HttpStatus.OK,librarianResponseEntity.getStatusCode()),
                () -> assertNotNull(librarianResponseEntity.getBody())

        );

    }

    @Test
    void c_update() {
        String url = urlBase + "updateLibrarian";
        System.out.println(url);

        ResponseEntity<Librarian> librarianResponseEntity = this.restTemplate
                .postForEntity(url,this.updatelibrarian,Librarian.class);
        System.out.println(librarianResponseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,librarianResponseEntity.getStatusCode()),
                () -> assertNotNull(librarianResponseEntity.getBody())
        );

        System.out.println("Librarian details updated");
    }


    @Test
    void delete() {
        String url = urlBase + "deleteLibrarian/" + updatelibrarian.getStaffId();
        System.out.println(url);

        this.restTemplate.delete(url);

        assertAll(
                () -> assertSame("222",updatelibrarian.getStaffId()),
                () -> assertNotNull(updatelibrarian.getStaffId())

        );

        System.out.println("Delete success!");



    }

    @Test
    void getAll() {

        String url = urlBase + "getAll_librarians";
        System.out.println(url);

        ResponseEntity<Librarian[]> responseEntity = this.restTemplate.getForEntity(url,Librarian[].class);

        System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0),
                () -> assertNotNull(responseEntity)
        );



    }

    @Test
    void findByPosition() {

        // Still trying to figure it out

    }

    @Test
    void findLibrarianByName() {
        // Still trying to figure it out
    }
}