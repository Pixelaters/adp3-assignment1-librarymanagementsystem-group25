package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.LibrarianContact;
import za.ac.cput.service.impl.LibrarianContactIService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/librarianContact/")
@Slf4j
public class LibrarianContactController {

    private final LibrarianContactIService librarianContactIService;

    @Autowired
    public LibrarianContactController(LibrarianContactIService librarianContactIService) {
        this.librarianContactIService = librarianContactIService;
    }

    @PostMapping("save_LibrarianContact")
    public ResponseEntity<LibrarianContact> create(@Valid @RequestBody LibrarianContact saveLibrarianContact){
        log.info("Save request: {}" , saveLibrarianContact);

        try{
            LibrarianContact librarianContact = this.librarianContactIService.create(saveLibrarianContact);
            return ResponseEntity.ok(librarianContact);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readLibrarianContact/{contactId}")
    public ResponseEntity<LibrarianContact> read(@PathVariable String contactId){
        log.info("Read request: {}" ,contactId);

        try{
           LibrarianContact getLibrarianContact = this.librarianContactIService.read(contactId);
            return ResponseEntity.ok(getLibrarianContact);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PutMapping("update_LibrarianContact")
    public ResponseEntity<LibrarianContact> update(@Valid @RequestBody LibrarianContact updateLibrarianContact){
        log.info("update request:  {}",updateLibrarianContact);

        try{
            LibrarianContact update = this.librarianContactIService.update(updateLibrarianContact);
            return ResponseEntity.ok(update);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteLibrarianContact/{contactId}")
    public ResponseEntity<LibrarianContact> delete(@PathVariable String contactId){
        log.info("Delete request: {}",contactId);

        this.librarianContactIService.delete(contactId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll_LibrarianContacts")
    public ResponseEntity<List<LibrarianContact>> getAll(){
        List<LibrarianContact> librarianContactList = this.librarianContactIService.getAll();
        return ResponseEntity.ok(librarianContactList);
    }

    @GetMapping("findLibrarianContactByLibrarianId/{librarianId}")
    public ResponseEntity<LibrarianContact> findLibrarianContactByLibrarianId(@PathVariable String librarianId){
        log.info("Find request: {}",librarianId);

        try{
            LibrarianContact librarianContact = this.librarianContactIService.findLibrarianContactByLibrarianId(librarianId);
            return ResponseEntity.ok(librarianContact);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }

    }

}


