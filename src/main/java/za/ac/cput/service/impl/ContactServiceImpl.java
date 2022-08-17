package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactIRepository;
import za.ac.cput.service.ContactIService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactIService {
    private final ContactIRepository contactIRepository;

    @Autowired
    public ContactServiceImpl(ContactIRepository contactIRepository){
        this.contactIRepository = contactIRepository;
    }



    @Override
    public Contact create(Contact contact) {
       return this.contactIRepository.save(contact);
    }

    @Override
    public Contact read(String id) {
        return this.contactIRepository.findById(id).orElse(null);
    }

    //not yet implemented
    @Override
    public Contact update(Contact contact) {
        return this.contactIRepository.save(contact);
    }



    @Override
    public void delete(String id) {
        if (this.contactIRepository.existsById(id)){
            this.contactIRepository.deleteById(id);
            System.out.println("Successfully deleted");
        }else{
            System.out.println("Could not find Id specified");
        }

    }

    @Override
    public Set<Contact> getAll() {
        return this.contactIRepository.findAll().stream().collect(Collectors.toSet());
    }

    public Contact findByCell(String cell){
        Contact contact= this.contactIRepository.findByCell(cell);
        System.out.println(contact);
        return contact;
    }

    public List<Contact> findByEmail(String email){
        List<Contact> subSet= this.contactIRepository.findByEmail(email);
        System.out.println(subSet);
        List<Contact> contactList= new ArrayList<>();
        for (Contact c: subSet){
            contactList.add(c);
        }
        return contactList;
    }

    public Contact findByContactId(String contactId){
        Contact contact= this.contactIRepository.findByContactId(contactId);
        System.out.println(contact);
        return contact;
    }


}
