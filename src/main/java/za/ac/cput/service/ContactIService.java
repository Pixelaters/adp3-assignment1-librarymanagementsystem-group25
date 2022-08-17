package za.ac.cput.service;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Contact;

import java.util.Set;


public interface ContactIService extends IService<Contact, String> {
    public Set<Contact> getAll();
}
