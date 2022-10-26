package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.Genre;
import za.ac.cput.service.impl.AuthorServiceImpl;
import za.ac.cput.service.impl.GenreServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/genre/")
@Slf4j
public class GenreController {
    private GenreServiceImpl genreService;

    @Autowired
    GenreController(GenreServiceImpl genreService){
        this.genreService = genreService;
    }

    @PostMapping("save")
    public ResponseEntity<Genre> create(@Valid @RequestBody Genre saveGenre){
        try{
            Genre newGenre = this.genreService.create(saveGenre);
            return  ResponseEntity.ok(newGenre);
        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST   , exception.getMessage());
        }
    }

    @PutMapping("update")
    public ResponseEntity<Genre> update(@Valid @RequestBody Genre updateGenre){
        try{
            Genre updatedGenre = this.genreService.update(updateGenre);
            return ResponseEntity.ok(updatedGenre);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping("delete/{genreId}")
    public ResponseEntity<Genre> delete(@PathVariable String genreId){
        this.genreService.delete(genreId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll")
    public List<Genre> getAll(){
        return genreService.getAll();
    }
}
