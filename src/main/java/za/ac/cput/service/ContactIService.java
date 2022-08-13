package za.ac.cput.service;

import za.ac.cput.domain.Contact;

import java.util.Set;

public interface ContactIService extends IService<Contact, String> {
    public Set<Contact> getAll();
}
