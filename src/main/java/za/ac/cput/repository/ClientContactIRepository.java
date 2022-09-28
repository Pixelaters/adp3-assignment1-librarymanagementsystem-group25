package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.ClientContact;

import java.util.List;

public interface ClientContactIRepository extends JpaRepository<ClientContact,String> {
    ClientContact findClientContactByClientId(String clientId);
}
