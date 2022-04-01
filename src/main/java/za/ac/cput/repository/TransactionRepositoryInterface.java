package za.ac.cput.repository;
/**
 * TransactionRepositoryInterface.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 01 April 2022
 */
import za.ac.cput.entity.Transaction;
import java.util.Set;

public interface TransactionRepositoryInterface extends IRepository<Transaction, String> {

    public Set<Transaction> getAll();
}
