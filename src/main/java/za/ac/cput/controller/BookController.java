package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Book;
import za.ac.cput.service.impl.BookServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/books/")
@Slf4j
public class BookController {
    private BookServiceImpl bookService;

    @Autowired
    BookController(BookServiceImpl bookService){
        this.bookService = bookService;
    }


    @PostMapping("save_book")
    public ResponseEntity<Book> create(@Valid @RequestBody Book saveBook){
        log.info("Save request: {}", saveBook);

        try{
            Book newBook = this.bookService.create(saveBook);
            return  ResponseEntity.ok(newBook);
        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST   , exception.getMessage());
        }
    }

    @PostMapping("update_book")
    public ResponseEntity<Book> update(@Valid @RequestBody Book updateBook){
        try{
            Book updatedBook = this.bookService.update(updateBook);
            return ResponseEntity.ok(updatedBook);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping("deleteBook/{bookId}")
    public ResponseEntity<Book> delete(@PathVariable String bookId){
        log.info("Delete request: {}", bookId);

        this.bookService.delete((bookId));
        return ResponseEntity.noContent().build();
    }


    @GetMapping("getAllBooks")
    public List<Book> getAll(){
        return bookService.getAll().stream().toList();
    }

    @GetMapping("findByName/{name}")
    public List<Book> findByName(@PathVariable String name){
        return bookService.findByBookName(name);
    }

    @GetMapping("findByAuthor/{author}")
        public List<Book> findByBookAuthor(@PathVariable String author){
            return bookService.findByBookAuthor(author);

    }

    @GetMapping("findByBookId/{bookId}")
    public List<Book> findByBookId(@PathVariable String bookId){
        return bookService.findBookById(bookId);
    }





}
