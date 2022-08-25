package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.service.impl.ClientAddressIService;

import javax.validation.Valid;
import java.util.List;

/*
    Breyton Ernstzen (217203027)
    ADP372S
    Capstone Project
 */
@RestController
@RequestMapping("librarymanagementsystem/clientAddress/")
@Slf4j
public class ClientAddressController {
    private final ClientAddressIService clientAddressIService;

    public ClientAddressController(ClientAddressIService clientAddressIService) {
        this.clientAddressIService = clientAddressIService;
    }

    @PostMapping("save_ClientAddress")
    public ResponseEntity<ClientAddress> create(@Valid @RequestBody ClientAddress saveClientAddress){
        log.info("Save request: {}", saveClientAddress);

        try{
            ClientAddress clientAddress = this.clientAddressIService.create(saveClientAddress);
            return ResponseEntity.ok(clientAddress);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }

    @GetMapping("readClientAddress/{clientId}")
    public ResponseEntity<ClientAddress> read(@PathVariable String clientId){
        log.info("Read request: {}",clientId);

        try{
            ClientAddress getClientAddress= this.clientAddressIService.read(clientId);
            return ResponseEntity.ok(getClientAddress);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }

    @PostMapping("update_ClientAddress")
    public ResponseEntity<ClientAddress> update(@Valid @RequestBody ClientAddress updateClientAddress){
        log.info("Update request: {}",updateClientAddress);

        try{
            ClientAddress update = this.clientAddressIService.update(updateClientAddress);
            return ResponseEntity.ok(update);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping("deleteClientAddress/{clientId}")
    public ResponseEntity<ClientAddress> delete(@PathVariable String clientId){
        log.info("Delete request: {}",clientId);

        this.clientAddressIService.delete(clientId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("getAll_ClientAddresses")
    public ResponseEntity<List<ClientAddress>> getAll(){
        List<ClientAddress> clientAddressList = this.clientAddressIService.getAll();
        return ResponseEntity.ok(clientAddressList);
    }

}

