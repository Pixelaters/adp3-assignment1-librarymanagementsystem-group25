package za.ac.cput.factory;

/* BookFactoryTest.java
Test class for the Book
Author: Ongezwa Gwaza (211272183)
Date: 31 March 2022
*/

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Library;
import za.ac.cput.entity.Book;
import za.ac.cput.entity.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookFactoryTest {
    private static Supplier supplier;

    @BeforeAll
    public static void setUp() throws Exception {
        Library library = new Library.Builder()
                .setLibraryId("123")
                .setAddress("101 10th street")
                .setLocation("Polokwane")
                .setName("City Library")
                .build();

        supplier = new Supplier.SupplierBuilder("123")
                .nameOfSupplier("Baroda")
                .cityWhereSupplierIsLocated("Jo'burg")
                .library(library)
                .build();
    }

    @Test
    @DisplayName("Test Creation of a new book")
    public void createNewBookTest() {
        Book book = BookFactory.create("1", "Programming 101", "Beetle books", "yes", supplier);
        assertNotNull(book);
        System.out.println("Test passed : New book created");

    }

    @Test
    @DisplayName("Test Creation of a new book with missing attributes")
    public void createBookWithMissingDetails() {
        Book book = new Book.BookBuilder("123")
                .nameOfBook("Algorithms and Data structures")
                .publishedBy("Daniel Yang")
                .build();
        assertNotNull(book);
        System.out.println("Test Passed: Book created");

    }

    @Test
    @DisplayName("Test Details of created book")
    public void testBookDetails() throws Exception {
        Book book = BookFactory.create("1", "Programming 101", "Beetle books", "yes", supplier);
        assertEquals("1", book.getBookCode());
        assertEquals("Programming 101", book.getName());
        assertEquals("yes", book.getAvailable());
        assertEquals(supplier, book.getSupplierId());
        System.out.println("Test passed : Details are equal");

    }

    @Test
    @DisplayName("Test Creation of a new book with missing attributes")
    public void copyDetailsShouldBeTheSame() {
        Book book = BookFactory.create("1", "Programming 101", "Beetle books", "yes", supplier);
        Book bookCopy = new Book().copy(book);

        supplier.setName("More books ");
        assertEquals(
                book.getSupplierId().getName(),
                bookCopy.getSupplierId().getName());
        System.out.println("Test passed : copy Details are equal");

    }
}
