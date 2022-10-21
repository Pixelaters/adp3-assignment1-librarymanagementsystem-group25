package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.ContactIService;
import za.ac.cput.service.impl.ContactServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/contact/")
@Slf4j
public class ContactController {
    private final ContactServiceImpl contactService;

    @Autowired
    ContactController(ContactServiceImpl contactService){
        this.contactService = contactService;
    }

    @PostMapping("save_contact")
    public ResponseEntity<Contact> create(@Valid @RequestBody Contact saveContact){
        log.info("Save request: {}", saveContact);

        try{
            Contact newContact = this.contactService.create(saveContact);
            return  ResponseEntity.ok(newContact);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @PutMapping("update_contact")
    public ResponseEntity<Contact> update(@Valid @RequestBody Contact updateContact){
        try{
            Contact updatedContact = this.contactService.update(updateContact);
            return ResponseEntity.ok(updatedContact);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping("deleteContact/{contactId}")
    public ResponseEntity<Contact> delete(@PathVariable String contactId){
        log.info("Delete request: {}", contactId);

        this.contactService.delete(contactId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("getAllContacts")
    public List<Contact> getAll(){
        return contactService.getAll().stream().toList();
    }

    @GetMapping("findByCell/{cell}")
    public Contact findByName(@PathVariable String cell){
        return contactService.findByCell(cell);
    }

    @GetMapping("findByEmail/{email}")
    public List<Contact> findByEmail(@PathVariable String email){
        return contactService.findByEmail(email);

    }

    @GetMapping("findByContactId/{contactId}")
    public Contact findByContactId(@PathVariable String contactId){
        return contactService.findByContactId(contactId);
    }





}

