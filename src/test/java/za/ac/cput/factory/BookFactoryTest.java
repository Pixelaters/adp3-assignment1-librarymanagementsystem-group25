package za.ac.cput.factory;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
@TestMethodOrder(MethodOrderer.class)
class BookFactoryTest {


    @Test
    @Order(1)
    void a_createBook() {

        Book book = BookFactory.CreateBook("A1","Goosebumps", "CantRemember", "Horror", "description","false", "https://something.jpg");
        assertNotNull(book);
        System.out.println(book);
    }


    @Test
    @Order(2)
    void b_createBookWithError() {

        Book book = BookFactory.CreateBook("A2","", "CantRemember", "Horror","description", "false", "https://something.jpg");
        assertNotNull(book);
        System.out.println(book);
    }

    @Test
    @Order(3)
    void c_createBookWithError2() {

        Book book = BookFactory.CreateBook("A2","Goosebumps", "", "Horror", "description","false", "https://something.jpg");
        assertNotNull(book);
        System.out.println(book);
    }

    @Test
    @Order(4)
    void d_createBookWithError3() {

        Book book = BookFactory.CreateBook("A2","Goosebumps", "CantRemember", "", "description","false", "https://something.jpg");
        assertNotNull(book);
        System.out.println(book);
    }

}