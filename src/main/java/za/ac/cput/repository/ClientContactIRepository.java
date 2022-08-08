package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.ClientContact;

public interface ClientContactIRepository extends JpaRepository<ClientContact,String> {

    public ClientContactIRepository findClientContactByClientId(String clientId);
}
