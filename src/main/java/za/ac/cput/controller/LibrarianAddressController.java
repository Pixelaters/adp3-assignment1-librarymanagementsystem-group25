package za.ac.cput.controller;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Controller: LibrarianAddressController
 * Date: 2022/08/21
 * */

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.LibrarianAddress;
import za.ac.cput.service.LibrarianAddressIService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/libraryAddress")
@Slf4j
public class LibrarianAddressController {

    private final LibrarianAddressIService librarianAddressIService;

    public LibrarianAddressController(LibrarianAddressIService librarianAddressIService){
        this.librarianAddressIService = librarianAddressIService;

    }

    @PostMapping("save_LibrarianAddress")
    public ResponseEntity<LibrarianAddress> create(@Valid @RequestBody LibrarianAddress saveLibrarianAddress){
        log.info("Save request: {}",saveLibrarianAddress);

        try{
            LibrarianAddress librarianAddress = this.librarianAddressIService.create(saveLibrarianAddress);
            return ResponseEntity.ok(librarianAddress);
        }catch(IllegalArgumentException exc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exc.getMessage());
        }
    }

    @GetMapping("readLibrarianAddress/{librarianId}")
    public ResponseEntity<LibrarianAddress> read(@PathVariable String librarianId){
        log.info("Read request: {}",librarianId);

        try{
            LibrarianAddress getLibrarianAddress = this.librarianAddressIService.read(librarianId);
            return ResponseEntity.ok(getLibrarianAddress);
        }catch(IllegalArgumentException exc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());

        }

    }

    @PostMapping("update_LibrarianAddress")
    public ResponseEntity<LibrarianAddress> update(@Valid @RequestBody LibrarianAddress updateLibrarianAddress){
        log.info("Update request: {}",updateLibrarianAddress);

        try{
            LibrarianAddress update = this.librarianAddressIService.update(updateLibrarianAddress);
            return ResponseEntity.ok(update);

        }catch(IllegalArgumentException exc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());
        }
    }

    @DeleteMapping("deleteClientAddress/{librarianId}")
    public ResponseEntity<LibrarianAddress> delete(@ PathVariable String librarianId){
        log.info("Delete request: {}",librarianId);

        this.librarianAddressIService.delete(librarianId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("getAll_LibrarianAddresses")
    public ResponseEntity<List<LibrarianAddress>> getAll(){
        List<LibrarianAddress> librarianAddressList = this.librarianAddressIService.getAll();
        return ResponseEntity.ok(librarianAddressList);
    }

    @GetMapping("getLibrarianAddressBylibrarianId")
    public List<LibrarianAddress> findLibrarianAddressByLibrarianIdList(String librarianId){
        return findLibrarianAddressByLibrarianIdList(librarianId);
    }

}
