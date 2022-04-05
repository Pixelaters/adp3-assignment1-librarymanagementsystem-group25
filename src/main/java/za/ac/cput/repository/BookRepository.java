package za.ac.cput.repository;

/* BookRepository.java
Repository interface for the Book
Author: Ongezwa Gwaza (211272183)
Date: 4 April 2022
*/

import za.ac.cput.entity.Book;
import za.ac.cput.entity.Supplier;

import java.util.HashSet;
import java.util.Set;

public class BookRepository implements BookRepositoryInterface{
    //initialise variables and database
    private static BookRepository bookRepository = null;
    private Set<Book> booksDB = null;

    private BookRepository(){
        booksDB = new HashSet<Book>();
    }

    /*
    Check if a repository instance is already created.
    Create one if non is created
    Uses the singleton pattern
    */
    public static BookRepository getInstance(){

        if(bookRepository == null){
            bookRepository = new BookRepository();
        }

        return bookRepository;
    }

    //adds a new book to the database
    @Override
    public Book create(Book book) {
        boolean bookAdded = booksDB.add(book);
//        if bookAdded is added return the book otherwise return null
        return bookAdded ? book : null;
    }

    //Gets a book from the Database using the bookCode
    @Override
    public Book read(String bookCode) {

        //iterate  through the book list and return the book whose bookCode equals the input
        for(Book book: booksDB){
            if(book.getBookCode().equals(bookCode))
                return book;
        }
        //book not found
        return null;
    }


    //Update a book in the Database
    @Override
    public Book update(Book book) {
        //Start by getting the book from the database
        Book oldBook = read(book.getBookCode());

        if(oldBook != null) {
            //if the book is in the database
            //remove old book
            //add the new book
            booksDB.remove(oldBook);
            booksDB.add(book);
            return book; //return the updated book
        }
        return null;
    }

    //Delete book by bookCode
    @Override
    public boolean delete(String bookCode) {
        //Start by getting the book from the database using the bookCode
        Book bookToDelete = read(bookCode);

        //if book is not available in database return false;
        if(bookToDelete == null)
            return false;
        /*
        if book is available remove/delete it
        if book was present and has been removed
        the  remove() method will return true otherwise it will return false
        */
        return booksDB.remove(bookToDelete);
    }

    //list all the books in the Database
    @Override
    public Set<Book> getAll() {
        return booksDB;
    }

    //Gets a book from the Database using the name of the book
    @Override
    public Book getBookByName(String name) {
        //iterate  through the book list and return the book with the given name
        for(Book book: booksDB){
            if(book.getName().equals(name))
                return book;
        }
        //book not found
        return null;
    }

    //Gets a book from the Database using the publisher of the book
    @Override
    public Book getBookByPublisher(String publisher) {
        //iterate  through the book list and return the book with the given publisher
        for(Book book: booksDB){
            if(book.getPublisher().equals(publisher))
                return book;
        }
        //book not found
        return null;
    }

    //Gets a book from the Database using the supplier of the book
    @Override
    public Book getBookBySupplier(Supplier supplier) {
        //iterate  through the book list and return the book with the given supplier
        for(Book book: booksDB){
            if(book.getSupplierId().equals(supplier))
                return book;
        }
        //book not found
        return null;
    }
}
