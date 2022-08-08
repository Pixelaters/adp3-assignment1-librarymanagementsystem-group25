/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Librarian;

@Repository
public interface  LibrarianRepository extends JpaRepository<Librarian,String> {
    public LibrarianRepository findLibrarianByStaffId(String staffId);

}
