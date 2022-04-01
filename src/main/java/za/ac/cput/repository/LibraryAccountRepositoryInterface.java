package za.ac.cput.repository;
/**
 * LibraryAccountRepositoryInterface.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 01 April 2022
 */
import za.ac.cput.entity.LibraryAccount;
import java.util.Set;

public interface LibraryAccountRepositoryInterface extends IRepository<LibraryAccount, String> {

    public Set<LibraryAccount> getAll();


}
