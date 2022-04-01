package za.ac.cput.repository;
/**
 * TransactionRepository.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 01 April 2022
 */
import za.ac.cput.entity.Transaction;

import java.util.HashSet;
import java.util.Set;

public class TransactionRepository implements TransactionRepositoryInterface {
    private static TransactionRepository tR = null;
    private Set<Transaction> tRDB = null;

    private TransactionRepository(){
        tRDB = new HashSet<Transaction>();
    }

    public static TransactionRepository getInstance(){
        if (tR == null) {
            tR = new TransactionRepository();

        }
        return tR;
    }

    @Override
    public Transaction create(Transaction t) {
        boolean success = tRDB.add(t);
        if (!success)
        return null;
        return t;
    }

    @Override
    public Transaction read(String transaction_ID) {
        for (Transaction t:tRDB) {
            if (t.getTransaction_ID().equals(transaction_ID))
                return t;
        }
        return null;
    }

    @Override
    public Transaction update(Transaction t) {
        Transaction oldTransaction = read(t.getTransaction_ID());
        if (oldTransaction != null){
            tRDB.remove(oldTransaction);
            tRDB.add(t);
            return t;
        }


        return null;
    }

    @Override
    public boolean delete(String Transaction_ID) {
        Transaction deleteTransaction = read(Transaction_ID);
        if (deleteTransaction == null)
        return false;
        tRDB.remove(deleteTransaction);
        return true;
    }

    @Override
    public Set<Transaction> getAll() {
        return tRDB;
    }
}
