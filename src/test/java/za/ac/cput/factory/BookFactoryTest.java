package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class BookFactoryTest {
    private Book book1,book2;

    @BeforeEach
    void setUp(){
        book1 = BookFactory.CreateBook("A2","Finding Gobby", "Anne Banks", "Morris Franks",
                "Mike ten Hag", "false", "science","fiction",
                "not for the weak heart","yes","https://myimage.com");

        book2 = BookFactory.CreateBook("A1","The last air-bender", "Grace Garfield", "Freddy Waynes",
                "Timo Thomas", "horror", "mystery","fiction",
                "giving goosebumps","yes","https://myimage1.com");
    }

    @Test
    void a_createBook() {

        assertAll(
                () -> assertNotNull(book1),
                () -> assertNotNull(book2)
        );

        System.out.println("Books created");
    }


    @Test
    void b_objectIdentity() {

        assertAll(
                () -> assertSame("A2",book1.getBookId()),
                () -> assertSame("A1",book2.getBookId()),
                () -> assertNotSame(book1.getBookId(),book2.getBookId())
        );
    }

    @Test
    void c_objectEquality() {

      assertAll(
              () -> assertNotEquals(book1,book2),
              () -> assertEquals(book1.getGenre3(),book2.getGenre3()),
              () -> assertNotEquals(book1.getBookId(),book2.getBookId())
      );
    }

}