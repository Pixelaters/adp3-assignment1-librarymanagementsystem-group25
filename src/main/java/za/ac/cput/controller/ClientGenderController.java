package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBookId;
import za.ac.cput.domain.ClientGender;
import za.ac.cput.service.ClientGenderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/clientgender/")
@Slf4j
public class ClientGenderController {

    private final ClientGenderService clientGenderService;

    @Autowired
    public ClientGenderController(ClientGenderService clientGenderService) {
        this.clientGenderService = clientGenderService;
    }


    @GetMapping("getAllClientGender")
    public ResponseEntity<List<ClientGender>> getAll(){
        List<ClientGender> clientGenderList = this.clientGenderService.getAll();
        return ResponseEntity.ok(clientGenderList);

    }

    @PostMapping("save_clientGender")
    public ResponseEntity<ClientGender> create(@Valid @RequestBody ClientGender saveClientGender){
        log.info("Save request: {}",saveClientGender);

        try{
            ClientGender newClientGender = this.clientGenderService.create(saveClientGender);
            return ResponseEntity.ok(newClientGender);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , exception.getMessage());
        }
    }

    @PutMapping("update_clientGender")
    public ResponseEntity<ClientGender> update(@Valid @RequestBody ClientGender updateClientGender){
        log.info("Update request: {}",updateClientGender);

        try {
            ClientGender updatedClientGender = this.clientGenderService.update(updateClientGender);
            return ResponseEntity.ok(updatedClientGender);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , exception.getMessage());
        }

    }

    @DeleteMapping("deleteClientGender/{id}")
    public ResponseEntity<ClientGender> delete(@PathVariable String id){
        log.info("Delete request: {}",id);

        this.clientGenderService.delete((id));
        return ResponseEntity.noContent().build();
    }


    @GetMapping("findClientGenderByClient/{client}")
    public List<ClientGender> findClientGenderByClient(@PathVariable Client client){
        return clientGenderService.findClientGenderByClient(client);
    }


}
