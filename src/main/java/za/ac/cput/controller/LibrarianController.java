package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.Name;
import za.ac.cput.service.impl.LibrarianIservice;
import za.ac.cput.service.impl.LibrarianService;

import javax.validation.Valid;
import java.util.List;
/*
 Ongezwa Gwaza
 211272183
        */
@RestController
@RequestMapping("librarymanagementsystem/librarian/")
@Slf4j
public class LibrarianController {
    private final LibrarianService librarianService;

    @Autowired
    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @PostMapping("save_Librarian")
    public ResponseEntity<Librarian> create(@Valid @RequestBody Librarian saveLibrarian) {
        log.info("Save request: {}", saveLibrarian);
        try {

            Librarian librarian = this.librarianService.create(saveLibrarian);
            return ResponseEntity.ok(librarian);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());

        }

    }

    @GetMapping("readLibrarian/{librarianId}")
    public ResponseEntity<Librarian> read(@PathVariable String librarianId) {
        log.info("Read request: {}", librarianId);
        try {
            Librarian getLibrarian = this.librarianService.read(librarianId);
            return ResponseEntity.ok(getLibrarian);


        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
    @DeleteMapping("deleteLibrarian/{librarianId}")
    public ResponseEntity<Librarian> delete(@PathVariable String librarianId){
        log.info("Delete request: {}",librarianId);

        this.librarianService.delete(librarianId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("getAll_Librarian")
    public ResponseEntity<List<Librarian>> getAll(){
        List<Librarian> librarianList = this.librarianService.getAll();
        return ResponseEntity.ok(librarianList);
    }

    @GetMapping("findByPosition/{position}")
    public List<Librarian> findByPosition(@PathVariable String position){
        return  librarianService.findLibrarianByPosition(position);


    }
    @GetMapping("findByName/{name}")
    public List<Librarian> findLibrarianByName(@PathVariable Name name){
        return librarianService.findLibrarianByName(name);
    }
}

