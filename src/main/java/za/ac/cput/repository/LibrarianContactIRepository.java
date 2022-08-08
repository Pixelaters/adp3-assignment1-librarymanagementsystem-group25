package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.LibrarianContact;

@Repository
public interface LibrarianContactIRepository extends JpaRepository<LibrarianContact,String> {

    public LibrarianContactIRepository findLibrarianContactByLibrarianId(String librarianId);


}
