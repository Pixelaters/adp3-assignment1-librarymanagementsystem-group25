package za.ac.cput.repository;
/*
    Breyton Ernstzen (217203027)
    ADP3
    Capstone project
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientAddress;

@Repository
public interface ClientAddressIRepository extends JpaRepository<ClientAddress,String> {

    ClientAddress findClientAddressByClientId(String clientId);
}
