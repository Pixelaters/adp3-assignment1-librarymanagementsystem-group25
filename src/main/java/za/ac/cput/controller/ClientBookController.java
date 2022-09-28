package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBook;
import za.ac.cput.service.ClientBookIService;
import za.ac.cput.service.impl.ClientBookImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/clientBook/")
@Slf4j
public class ClientBookController {
    private final ClientBookIService clientBookIService;

    @Autowired
    public ClientBookController(ClientBookIService clientBookIService) {
        this.clientBookIService = clientBookIService;
    }

    @PostMapping("save_clientbook")
    public ResponseEntity<ClientBook> create(@Valid @RequestBody ClientBook clientBook){
        log.info("Save request: {}",clientBook);

        try{
            ClientBook save_clientBook = this.clientBookIService.create(clientBook);
            return ResponseEntity.ok(save_clientBook);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }

    @GetMapping("read_clientBook/{clientId}")
    public ResponseEntity<ClientBook> read(@PathVariable String clientId){
        log.info("Read request: {}", clientId);

        try{
            ClientBook read_ClientBook = this.clientBookIService.read(clientId);
            return ResponseEntity.ok(read_ClientBook);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }

    @PostMapping("update_clientbook")
    public ResponseEntity<ClientBook> update(@Valid @RequestBody ClientBook clientBook){
        log.info("Update request: {}",clientBook);

        try{
            ClientBook update_ClientBook = this.clientBookIService.update(clientBook);
            return ResponseEntity.ok(update_ClientBook);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping("delete_clientbook/{clientId}")
    public ResponseEntity<ClientBook> delete(@PathVariable String clientId){
        log.info("Delete request: {}", clientId);

        this.clientBookIService.delete(clientId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll_clientbooks")
    public ResponseEntity<List<ClientBook>> getAll(){
        List<ClientBook> clientBooks = this.clientBookIService.getAll();
        return ResponseEntity.ok(clientBooks);
    }

    @GetMapping("findClientBookByClient/{client}")
    public ResponseEntity<List<ClientBook>> findClientBookByClient(@PathVariable Client client){
        log.info("Find Request: {}",client);

        List<ClientBook> findClientBook = this.clientBookIService.findClientBookByClient(client);
        return ResponseEntity.ok(findClientBook);
        }

}
