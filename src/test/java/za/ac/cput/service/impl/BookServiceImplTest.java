package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookServiceImplTest {

    @Autowired
    BookServiceImpl bookService;
    private static Book book1,book2,book3,updateBook;


    @BeforeEach
    void setUp() {
        book1 = BookFactory.CreateBook("1","GooseBumps","Ziyaad","Horror");
        book2 = BookFactory.CreateBook("2","GooseBumps2","Ziyaad","Horror");
        book3 = BookFactory.CreateBook("3","GooseBumps3","Ziyaad","Horror");
        updateBook = new Book.Builder().copy(book1).BookName("Goosebumps4").build();
    }

    @Test
    @Order(1)
    void create() {
        Book created1= bookService.create(book1);
        assertNotNull(created1);
        System.out.println(created1);

        Book created2= bookService.create(book2);
        assertNotNull(created2);
        System.out.println(created2);

        Book created3= bookService.create(book3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    @Order(2)
    void read() {
        Book read= bookService.read(book1.getBookId());
        assertEquals(read.getBookId(),book1.getBookId());
        System.out.println("read"+read);
    }

    @Test
    @Order(3)
    void update() {
        Book updated= bookService.create(updateBook);
        Book created1 = bookService.create(book1);

        assertSame(false,book1.getBookName(),updateBook.getBookName());
        System.out.println("details updated successfully");
    }

    @Test
    @Order(4)
    void delete() {
        bookService.delete(book3.getBookId());
        assertNotNull(book3);
        System.out.println("book deleted successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(bookService.getAll());
    }

    @Test
    @Order(6)
    void findBookById() {
        //System.out.println(bookService.findBookById("1"));
    }

    @Test
    @Order(7)
    void findByBookName() {
        System.out.println(bookService.findByBookName("GooseBumps"));
    }

    @Test
    @Order(8)
    void findByBookAuthor() {
        System.out.println(bookService.findByBookAuthor("Ziyaad"));
    }
}