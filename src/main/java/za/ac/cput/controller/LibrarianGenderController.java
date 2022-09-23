package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianGender;
import za.ac.cput.service.impl.LibrarianGenderIservice;

import javax.validation.Valid;
import java.util.List;
/*
 Ongezwa Gwaza
 211272183
        */
@RestController
@RequestMapping("librarymanagementsystem/librariangender/")
@Slf4j
public class LibrarianGenderController {

    private final LibrarianGenderIservice librariangenderIService;

    @Autowired
    public LibrarianGenderController(LibrarianGenderIservice librariangenderIService) {
        this.librariangenderIService = librariangenderIService;
    }

    @PostMapping("save_LibrarianGender")
    public ResponseEntity<LibrarianGender> create(@Valid @RequestBody LibrarianGender saveLibrarianGender) {
        log.info("Save request: ", saveLibrarianGender);
        try {

            LibrarianGender librariangender = this.librariangenderIService.create(saveLibrarianGender);
            return ResponseEntity.ok(librariangender);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());

        }

    }

    @GetMapping("readLibrarianGender/{librariangenderId}")
    public ResponseEntity<LibrarianGender> read(@PathVariable String librariangenderId) {
        log.info("Read request: {}", librariangenderId);
        try {
            LibrarianGender getLibrarianGender = this.librariangenderIService.read(librariangenderId);
            return ResponseEntity.ok(getLibrarianGender);


        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
    @DeleteMapping("deleteLibrarianGender/{librariangenderId}")
    public ResponseEntity<LibrarianGender> delete(@PathVariable String librariangenderId){
        log.info("Delete:",librariangenderId);

        this.librariangenderIService.delete(librariangenderId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("getAll_LibrarianGender")
    public ResponseEntity<List<LibrarianGender>> getAll(){
        List<LibrarianGender> librariangenderList = this.librariangenderIService.getAll();
        return ResponseEntity.ok(librariangenderList);
    }
}


