package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Author;
import za.ac.cput.service.impl.AuthorServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/author/")
@Slf4j
public class AuthorController {
    private AuthorServiceImpl authorService;

    @Autowired
    AuthorController(AuthorServiceImpl authorService){
        this.authorService = authorService;
    }

    @PostMapping("save_author")
    public ResponseEntity<Author> create(@Valid @RequestBody Author saveAuthor){
        try{
            Author newAuthor = this.authorService.create(saveAuthor);
            return  ResponseEntity.ok(newAuthor);
        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST   , exception.getMessage());
        }
    }

    @PutMapping("update_author")
    public ResponseEntity<Author> update(@Valid @RequestBody Author updateAuthor){
        try{
            Author updatedAuthor = this.authorService.update(updateAuthor);
            return ResponseEntity.ok(updatedAuthor);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping("deleteAuthor/{authorId}")
    public ResponseEntity<Author> delete(@PathVariable String authorId){
        this.authorService.delete(authorId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAllAuthors")
    public List<Author> getAll(){
        return authorService.getAll();
    }


}
