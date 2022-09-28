/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.Name;

import java.util.List;

@Repository
public interface  LibrarianRepository extends JpaRepository<Librarian,String> {
    List<Librarian> findLibrarianByStaffId(String staffId);
    List<Librarian> findLibrarianByPosition(String position);
    List<Librarian> findLibrarianByName(Name name);

}
