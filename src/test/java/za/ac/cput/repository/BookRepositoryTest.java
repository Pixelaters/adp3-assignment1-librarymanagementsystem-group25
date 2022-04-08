package za.ac.cput.repository;
/* BookRepositoryTest.java
Repository test class for the Book
Author: Ongezwa Gwaza (211272183)
Date: 4 April 2022
*/

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Book;
import za.ac.cput.entity.Library;
import za.ac.cput.entity.Supplier;


import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class BookRepositoryTest {
    private static BookRepository bookRepository = BookRepository.getInstance();
    private static Supplier supplier;
    private static Book testBook;
    private static Book book2,book3,book4;

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

        testBook = new Book.BookBuilder("1")
                .nameOfBook("Algorithms and Data Structures")
                .supplierOfBook(supplier)
                .isBookAvailable("yes")
                .publishedBy("Daniel Yang")
                .build();

        //create book instances
        Supplier supplier2 = supplier.copy(supplier);
        supplier2.setName("Mech books");
        book2 = new Book.BookBuilder("2")
                .nameOfBook("Introduction to Programming")
                .supplierOfBook(supplier2)
                .publishedBy("Tony Chapel")
                .isBookAvailable("unavailable")
                .build();
        Supplier supplier3 = supplier.copy(supplier);
        supplier3.setName("Cyber Books");
         book3 = new Book.BookBuilder("3")
                .nameOfBook("Network for Dummies")
                .supplierOfBook(supplier3)
                .publishedBy("Michael Murray")
                .isBookAvailable("available")
                .build();
        Supplier supplier4 = supplier.copy(supplier);
        supplier4.setName("Bill Books");
        book4 = new Book.BookBuilder("4")
                .nameOfBook("Introduction to Programming")
                .supplierOfBook(supplier2)
                .publishedBy("Tony Chapel")
                .isBookAvailable("unavailable")
                .build();
    }

    @AfterEach
    public void cleanUpEach() throws Exception {
        bookRepository.deleteAll();

    }

    @Test
    @DisplayName("Test get all when database is empty")
    public void getAll_if_database_isempty() {

        Set<Book> books = bookRepository.getAll();
        System.out.println(books);
        Boolean booksIsEmpty = books.isEmpty();
        assertTrue(booksIsEmpty,"Database is empty as there are not items in the database");
        System.out.println("Test passed : Database is empty");

    }
    @Test
    @DisplayName("Test persistence of book in the database")
    public void createBook_success() {
        Book book = bookRepository.create(testBook);
        assertNotNull(book, "The saved book should not be null");
        assertEquals(book.getBookCode(),testBook.getBookCode(), "The saved bookCode should be equal to the bookCode of supplied book");
        assertEquals(book.getName(),testBook.getName(), "The names of the saved book and supplied book should be equal");
        assertEquals(book.getPublisher(),testBook.getPublisher(), "The publisher fields should be equal");
        assertEquals(book.getSupplierId(),testBook.getSupplierId(), "The suppliers of the book should be the same");
        assertEquals(book.getAvailable(),testBook.getAvailable(), "The availability status should be the equal");
        System.out.println("Test passed: Book created and saved");

    }
    @Test
    @DisplayName("List all the books in the database")
    public void getAll_when_database_has_values() {

        //save the books to database
        System.out.println(bookRepository.getAll());
        bookRepository.create(book2);
        bookRepository.create(book3);
        bookRepository.create(book4);

        Set<Book> books = bookRepository.getAll();
        assertEquals(3,books.size(),"The number of elements in the database should be equal to the number of items added");
        System.out.println("Test passed : All books listed");

    }
    @Test
    @DisplayName("Get one book by bookCode")
    public void read_should_find_book_by_bookCode() {

        bookRepository.create(testBook);
        bookRepository.create(book2);
        bookRepository.create(book3);
        Book foundBook = bookRepository.read(testBook.getBookCode());
        assertEquals(foundBook,testBook,"The book found in the database should be equal to the book added");
        System.out.println("Test passed : One book read from database");
    }
    @Test
    @DisplayName("Get one book by book name")
    public void getBookByName_success() {
        //save books
        bookRepository.create(testBook);
        bookRepository.create(book2);
        bookRepository.create(book3);
        //get book by name
        Book foundBook = bookRepository.getBookByName(testBook.getName());
        assertEquals(foundBook,testBook,"The book found in the database should be equal to the book added");
        System.out.println("Test passed : Book found by name");
    }

    @Test
    @DisplayName("Get one book by publisher")
    public void getBookByPublisher_success() {
        //save books
        bookRepository.create(testBook);
        bookRepository.create(book2);
        bookRepository.create(book3);
        //get book by publisher
        Book foundBook = bookRepository.getBookByPublisher(testBook.getPublisher());
        assertEquals(foundBook,testBook,"The book found in the database should be equal to the book added");
        System.out.println("Test passed : Book Found by publisher");
    }

    @Test
    @DisplayName("Get one book by the supplier")
    public void getBookBySupplier_success() {
        //save books
        bookRepository.create(testBook);
        bookRepository.create(book2);
        bookRepository.create(book3);
        //get book by supplier
        Book foundBook = bookRepository.getBookBySupplier(testBook.getSupplierId());
        assertEquals(foundBook,testBook,"The book found in the database should be equal to the book added");
        System.out.println("Test passed : Book found by Supplier");
    }
    @Test
    @DisplayName("Delete book by bookCode")
    public void delete() {
        //save books
        bookRepository.create(testBook);
        bookRepository.create(book2);
        bookRepository.create(book3);
        //delete book
        Boolean bookDeleted = bookRepository.delete(testBook.getBookCode());
        assertTrue(bookDeleted,testBook.getName() + " has been deleted successfully");
        System.out.println("Test passed : Books successfully deleted");
        //test deleting a book not in database
        Boolean itemDeleted = bookRepository.delete("6");
        assertFalse(itemDeleted,testBook.getBookCode() + " is not available");
        System.out.println("Test passed : Book not deleted as it is not available");

        //test if the other books are still available
        Set<Book> books = bookRepository.getAll();
        Boolean book2isPresent = books.contains(book2);
        Boolean book3isPresent = books.contains(book3);
        assertTrue(book2isPresent,book2.getName() + " was not deleted");
        assertTrue(book3isPresent,book3.getName() + " was not deleted");
        System.out.println("Test passed : Books not deleted");

    }
    @Test
    public void update() {
        //save books
        Book book = bookRepository.create(testBook);
        Book bookBeforeUpdate = book4.copy(book4);
        System.out.println(bookBeforeUpdate);
        Book savedBook = bookRepository.create(bookBeforeUpdate);

        //update savedBook
        savedBook.setName("Programming 101");
        savedBook.setPublisher("Best Books");
        Book updatedBook = bookRepository.update(savedBook);

        //check if saved book has been updated
        assertEquals(updatedBook.getBookCode(),savedBook.getBookCode(),"BookCodes should be equal");
        assertEquals(updatedBook.getName(),savedBook.getName(),"Names should be equal");
        assertEquals(updatedBook.getPublisher(),savedBook.getPublisher(),"Publishers should be equal");
        System.out.println("Test passed : Book updated");

        //check if original book i.e book4 is different from updated book
        assertNotEquals("Introduction to Programming",updatedBook.getName(),"Final updated Book name should be different from original book ");
        assertNotEquals("Tony Chapel",updatedBook.getName(),"Final updated Book publisher should be different from original book ");
        assertEquals(book,testBook,"Book not updated");


    }


}
