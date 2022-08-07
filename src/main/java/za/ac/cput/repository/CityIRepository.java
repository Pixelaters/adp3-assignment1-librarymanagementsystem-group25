package za.ac.cput.repository;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Repository: CityIRepository
 * Date: 2022/08/06
 * */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.City;

@Repository
public interface CityIRepository extends JpaRepository<City,String> {
}
