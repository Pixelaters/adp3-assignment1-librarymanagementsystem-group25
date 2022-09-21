/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianGender;

import java.util.List;

public interface LibrarianGenderRepository extends JpaRepository<LibrarianGender,String> {

    List<LibrarianGender> findLibrarianGenderByLibrarian(Librarian librarian);
}
