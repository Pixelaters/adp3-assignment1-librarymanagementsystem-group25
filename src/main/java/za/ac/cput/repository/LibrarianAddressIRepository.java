package za.ac.cput.repository;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Repository: LibrarianAddressIRepository
 * Date: 2022/08/06
 * */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.LibrarianAddress;

@Repository
public interface LibrarianAddressIRepository extends JpaRepository<LibrarianAddress, String> {
}
