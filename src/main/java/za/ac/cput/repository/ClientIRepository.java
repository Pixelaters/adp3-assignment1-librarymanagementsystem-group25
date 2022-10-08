package za.ac.cput.repository;
/*
    Breyton Ernstzen (217203027)
    ADP3
    Capstone project
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Client;

import java.util.List;

@Repository
public interface ClientIRepository extends JpaRepository<Client,String> {


    Client findClientByClientId(String id);
    Client readClientByClientId(String clientId); // --> added on 2022/09/27
}
