package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Book;
import za.ac.cput.repository.BookIRepository;
import za.ac.cput.service.BookIService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookIService {
    private final BookIRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookIRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book create(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book read(String id) {
        return this.bookRepository.findById(id).orElse(null);
    }


    @Override
    public Book update(Book book) {
        return this.bookRepository.save(book);
    }

    public Book updateBookAvailability(String bookId){
        Book bookToUpdate = bookRepository.getOne(bookId);
        bookToUpdate.setIsRented("Not Available");
        return bookRepository.save(bookToUpdate);
    }


    //Discuss with group if we should make delete return a boolean or void.
    @Override
    public void delete(String id) {
        if (this.bookRepository.existsById(id)) {
            this.bookRepository.deleteById(id);
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Could not find Id specified");
        }


    }

    @Override
    public Set<Book> getAll() {
        return this.bookRepository.findAll().stream().collect(Collectors.toSet());
    }

    public List<Book> findBookById(String bookId){
        List<Book> subSet= this.bookRepository.findByBookId(bookId);

        System.out.println(subSet);
        List<Book> bookList= new ArrayList<>();
        for (Book b: subSet){
            bookList.add(b); //I know this is broken, I'll be asking sir a question about this on monday, "How to pass in a Book object instead of just the name"

        }
        return bookList;

    }

    public List<Book> findByBookName(String bookName) {
        List<Book> subSet = this.bookRepository.findByBookName(bookName);

        System.out.println(subSet);
        List<Book> bookNameList = new ArrayList<>();
        for (Book b : subSet) {
            bookNameList.add(b); //I know this is broken, I'll be asking sir a question about this on monday, "How to pass in a Book object instead of just the name"

        }

        return bookNameList;

    }

    public List<Book> findByBookAuthor(String author) {
        List<Book> subSet = this.bookRepository.findByAuthor(author);

        System.out.println(subSet);
        List<Book> bookList = new ArrayList<>();
        for (Book b : subSet) {
            bookList.add(b);

        }

        return bookList;

    }

    public List<Book> findByIsRented(String isRented){
        List<Book> subSet= this.bookRepository.findByIsRented(isRented);

        System.out.println(subSet);
        List<Book> bookList = new ArrayList<>();
        for (Book b: subSet){
            bookList.add(b);
        }
        return bookList;
    }
}