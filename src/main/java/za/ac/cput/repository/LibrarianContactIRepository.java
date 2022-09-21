package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianContact;

import java.util.List;

@Repository
public interface LibrarianContactIRepository extends JpaRepository<LibrarianContact,String> {

    List<LibrarianContact> findLibrarianContactByLibrarian(Librarian librarian);


}
