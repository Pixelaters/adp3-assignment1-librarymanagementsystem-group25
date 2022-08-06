package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ClientAddress;

@Repository
public interface ClientAddressIRepository extends JpaRepository<ClientAddress,String> {

}
