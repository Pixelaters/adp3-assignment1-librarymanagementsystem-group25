package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@SpringBootTest
class BookServiceImplTest {

    @Autowired
    BookServiceImpl bookService;
    private static Book book1,book2,updateBook;

    @BeforeEach
    void setUp() {
        book1 = BookFactory.CreateBook("A2","Finding Gobby", "Anne Banks", "Morris Franks",
                "Mike ten Hag", "false", "science","fiction",
                "not for the weak heart","yes","https://myimage.com");

        book2 = BookFactory.CreateBook("A1","The last air-bender", "Grace Garfield", "Freddy Waynes",
                "Timo Thomas", "horror", "mystery","fiction",
                "giving goosebumps","yes","https://myimage1.com");

        updateBook =  BookFactory.CreateBook("ZZ2","Home Alone","Ziyaad","James Benson",
                "Leon","comedy", "action","drama","for laughter","yes", "https://myimage.com" );
    }

    @Test
    void a_create() {
        bookService.create(book1);
        assertNotNull(book1);
        assertSame("A2",book1.getBookId());
        assertNotSame("ZZ2",book2.getBookId());
        assertNotSame(book1.getBookId(),book2.getBookId());
        System.out.println(book1);

        bookService.create(book2);
        assertNotNull(book2);
        assertSame("A2",book1.getBookId());
        assertNotSame("ZZ2",book2.getBookId());
        assertNotSame(book1.getBookId(),book2.getBookId());
        System.out.println(book2);

        System.out.println("Books created");

    }

    @Test
    void b_read() {
        bookService.read(book1.getBookId());

        assertNotNull(book1);
        assertSame("A2",book1.getBookId());
        assertNotSame("ZZ2",book2.getBookId());
        assertNotSame(book1.getBookId(),book2.getBookId());
        System.out.println(book1);

        bookService.create(book2);
        assertNotNull(book2);
        assertSame("A2",book1.getBookId());
        assertNotSame("ZZ2",book2.getBookId());
        assertNotSame(book1.getBookId(),book2.getBookId());
        System.out.println(book2);

        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }

    @Test
    void c_update() {
        bookService.update(updateBook);

        assertNotNull(updateBook);
        assertNotSame("A2",updateBook.getBookId());
        assertNotSame("ZZ2",book2.getBookId());
        assertNotSame(updateBook.getBookId(),book2.getBookId());

        System.out.println("Updated");
    }

    @Test
    void d_delete() {
        bookService.delete(updateBook.getBookId());

        assertNotNull(updateBook);
        assertNotSame("A2",updateBook.getBookId());
        assertNotSame("ZZ2",book2.getBookId());
        assertNotSame(updateBook.getBookId(),book2.getBookId());

        System.out.println("Book deleted");

    }

    @Test
    void e_getAll() {
        bookService.getAll();

        assertNotNull(bookService.getAll());

    }

    @Test
    void f_findBookById() {

        assertAll(
                () -> assertNotNull(book1.getBookId()),
                () -> assertNotNull(book2.getBookId())
        );

        System.out.println(book1.getBookId());
        System.out.println(book2.getBookId());
    }

    @Test
    void g_findByBookName() {

        assertAll(
                () -> assertNotNull(book1.getBookName()),
                () -> assertNotNull(book2.getBookName())
        );

    }

    @Test
    void h_findByBookAuthor() {

        assertAll(
                () -> assertNotNull(book1.getAuthor()),
                () -> assertNotNull(book1.getAuthor2()),
                () -> assertNotNull(book1.getAuthor3())
        );
    }
}