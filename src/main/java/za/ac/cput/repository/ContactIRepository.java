package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Contact;

import java.util.List;

public interface ContactIRepository extends JpaRepository<Contact, String> {
    public Contact findByCell(String cell);
    public List<Contact> findByEmail(String email);
    public Contact findByContactId(String contactId);
}
