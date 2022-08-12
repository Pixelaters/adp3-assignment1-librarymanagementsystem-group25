package za.ac.cput.repository;
/*
    Breyton Ernstzen (217203027)
    ADP3
    Capstone project
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Client;

@Repository
public interface ClientIRepository extends JpaRepository<Client,String> {

    Client findClientById(String id);
}
