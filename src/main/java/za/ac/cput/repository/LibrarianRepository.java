/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Librarian;

import java.util.List;

@Repository
public interface  LibrarianRepository extends JpaRepository<Librarian,String> {
    public List<Librarian> findLibrarianByStaffId(String staffId);
    public List<Librarian> findLibrarianByPosition(String position);
    public List<Librarian> findLibrarianByName(String name);

}
