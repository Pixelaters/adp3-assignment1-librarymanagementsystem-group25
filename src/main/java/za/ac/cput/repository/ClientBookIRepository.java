package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBook;
import za.ac.cput.domain.ClientBookId;

import java.util.List;

@Repository
public interface ClientBookIRepository extends JpaRepository<ClientBook,ClientBook> {
    List<ClientBook> findClientBookByClients(Client client);

}
