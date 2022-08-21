package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.service.ClientBookIdService;
import za.ac.cput.domain.ClientBookId;
import za.ac.cput.service.impl.ClientBookIdServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library-management/clientBookId")
public class ClientBookIdController {


    private ClientBookIdServiceImpl clientBookIdService;

    @Autowired
    ClientBookIdController(ClientBookIdServiceImpl clientBookIdService){
        this.clientBookIdService = clientBookIdService;
    }

    @PostMapping("/save_clientBookId")
    public ResponseEntity<ClientBookId> create(@Valid @RequestBody ClientBookId save){

        try{
            ClientBookId newClientBookId = this.clientBookIdService.create(save);
            return ResponseEntity.ok(newClientBookId);
        }catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , exception.getMessage());
        }
    }

    @PostMapping("/update_clientBookId")
    public ResponseEntity<ClientBookId> update(@Valid @RequestBody ClientBookId update){
        try{
            ClientBookId updatedClientBookId = this.clientBookIdService.update(update);
            return ResponseEntity.ok(updatedClientBookId);
        }catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , exception.getMessage());
        }
    }

    @DeleteMapping("/delete_clientBookId/{id}")
    public ResponseEntity<ClientBookId> delete(@PathVariable String id){

        this.clientBookIdService.delete((id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllClientBookId")
    public List<ClientBookId> getAll() {
        return clientBookIdService.getAll().stream().toList();
    }



}
