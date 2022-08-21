package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Contact;

import java.util.List;

@Repository
public interface ContactIRepository extends JpaRepository<Contact, String> {
    public Contact findByCell(String cell);
    public List<Contact> findByEmail(String email);
    public Contact findByContactId(String contactId);
}
