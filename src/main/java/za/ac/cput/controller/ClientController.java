package za.ac.cput.controller;
/*
    Breyton Ernstzen (217203027)
    ADP372S
    Capstone Project
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Client;
import za.ac.cput.service.impl.ClientIService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/client/")
@Slf4j
public class ClientController {
    private final ClientIService clientIService;

    @Autowired
    ClientController(ClientIService clientIService) {
        this.clientIService = clientIService;
    }

    @PostMapping("save_client")
    public ResponseEntity<Client> create(@Valid @RequestBody Client saveClient){
        log.info("Save request: {}", saveClient);

        try{
            Client newClient = this.clientIService.create(saveClient);
            return ResponseEntity.ok(newClient);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }

    @GetMapping("readClient/{clientId}")
    public ResponseEntity<Client> read(@PathVariable String clientId){
        log.info("Read request: {}", clientId);

        try{
            Client readClient = this.clientIService.read(clientId);
            return ResponseEntity.ok(readClient);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }

    }

    //works same as the save/create method
    @PostMapping("update_client")
    public ResponseEntity<Client> update(@Valid @RequestBody Client updateClient){

        try{
            Client updatedClient = this.clientIService.update(updateClient);
            return ResponseEntity.ok(updatedClient);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }

    @DeleteMapping("deleteClient/{clientId}")
    public ResponseEntity<Client> delete(@PathVariable String clientId){
        log.info("Delete request: {}",clientId);

        this.clientIService.delete(clientId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("getAll_clients")
    public ResponseEntity<List<Client>> getAll(){
        List<Client> clientList = this.clientIService.getAll();
        return ResponseEntity.ok(clientList);

    }

    //this may be the wrong way *
    @GetMapping("find_ClientBy_Id/{clientId}")
    public List<Client> findById(@PathVariable String clientId){
        return (List<Client>) clientIService.findClientById(clientId);
    }

}
