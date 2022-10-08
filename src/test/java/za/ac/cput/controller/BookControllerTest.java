package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class BookControllerTest {

    @LocalServerPort
    private int portNumber;
    @Autowired
    private BookController bookController;
    @Autowired private TestRestTemplate restTemplate;
    private Book book,updatedBook;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(bookController);

        this.book = BookFactory.CreateBook("A1","Goosebumps", "CantRemember", "Horror","description", "false", "https://something.jpg");

        this.updatedBook = BookFactory.CreateBook("A2","Goosebumps", "CantRemember", "Horror","description", "false", "https://something.jpg");

        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/book/";
    }

    @Test
    void a_create() {
        String url = urlBase + "saveBook";
        System.out.println(url);

        ResponseEntity<Book> bookResponseEntity = this.restTemplate
                .postForEntity(url,this.book,Book.class);
        System.out.println(bookResponseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,bookResponseEntity.getStatusCode()),
                () -> assertNotNull(bookResponseEntity.getBody())
        );

        System.out.println("Book saved!");

    }

    //this test method needs fixing
    @Test
    void b_read() {
        String url = urlBase + "readBook/" + book.getBookId();
        System.out.println(url);

        ResponseEntity<Book> bookResponseEntity = this.restTemplate
                .getForEntity(url,Book.class);
        System.out.println(bookResponseEntity);
        //System.out.println(Arrays.asList(Objects.requireNonNull(clientResponseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,bookResponseEntity.getStatusCode()),
                () -> assertNotNull(bookResponseEntity.getBody())

        );

    }

    @Test
    void c_update() {
        String url = urlBase + "updateBook";
        System.out.println(url);

        ResponseEntity<Book> bookResponseEntity = this.restTemplate
                .postForEntity(url,this.updatedBook,Book.class);
        System.out.println(bookResponseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,bookResponseEntity.getStatusCode()),
                () -> assertNotNull(bookResponseEntity.getBody())
        );

        System.out.println("Book details updated");
    }

    @Test
    void d_delete() {
        String url = urlBase + "deleteBook/" + updatedBook.getBookId();
        System.out.println(url);

        this.restTemplate.delete(url);

        assertAll(
                () -> assertSame("1",updatedBook.getBookId()),
                () -> assertNotNull(updatedBook.getBookName())

        );

        System.out.println("Delete success!");

    }

    @Test
    void e_getAll() {
        String url = urlBase + "getAll_books";
        System.out.println(url);

        ResponseEntity<Book[]> responseEntity = this.restTemplate
                .getForEntity(url,Book[].class);
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
        String url = urlBase + "findBookById";
        System.out.println(url);

        ResponseEntity<Book[]> responseEntity = this.restTemplate
                .getForEntity(url,Book[].class);
        //System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity)
        );



    }
}

