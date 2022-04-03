package za.ac.cput.repository;
/**
 * TransactionRepositoryTest.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 01 April 2022
 */
import org.junit.jupiter.api.*;
import za.ac.cput.entity.Transaction;
import za.ac.cput.factory.TransactionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class TransactionRepositoryTest {
    private static TransactionRepository tr1 = TransactionRepository.getInstance();
    private static Transaction transaction1 = TransactionFactory.addTransaction("217", "1234", "33");

    @Test
    void aCreateTransactionTest(){
        Transaction t1 = TransactionRepository.getInstance().create(transaction1);
        Transaction t2 = t1;
        Transaction transaction2 = TransactionFactory.addTransaction("a", "456", "98");

        assertEquals(transaction1.getTransaction_ID(),t1.getTransaction_ID());
        assertSame(transaction2.getTransaction_ID(),t1.getTransaction_ID());
        assertNotSame(t1.getTransaction_ID(),transaction2.getTransaction_ID());
        assertNotSame(t2.getDate(),transaction2.getDate());
        assertSame(t1,t2);
        assertNotSame(t1,t2);
        assertNotNull(transaction1);
        assertNotNull(t2);
        assertNotNull(transaction2);
        System.out.println("Transaction/s has been added...");
        System.out.println();
    }

    @Test
    void bReadTransactionTest(){
        Transaction showt1 = TransactionRepository.getInstance().read(transaction1.getTransaction_ID());
        Transaction showt2 = showt1;
        Transaction showt3 = TransactionFactory.addTransaction("152", "856", "11");

        assertNotNull(showt1);
        assertNotNull(showt3);
        assertNotSame(showt1.getTransaction_ID(),showt3.getTransaction_ID());
        assertNotSame(showt1,showt3);
        assertSame(showt1.getDate(),transaction1.getDate());
        assertSame(showt1,showt2);
        assertEquals(transaction1.getDetails(),showt1.getDetails());


        System.out.println("Reading through Transactions...");
        System.out.println(TransactionRepository.getInstance().read("152"));
        System.out.println();
    }

    @Test
    void cUpdateTransactionTest(){
        Transaction updatet1 = new Transaction.TransactionBuilder().copy(transaction1)
                .setTransaction_ID("195")
                .setDate("12 September 2022")
                .setDetails("Update")
                .build();
        Transaction identicalTransaction = updatet1;

        assertNotNull(updatet1);
        assertNotNull(identicalTransaction);
        assertSame(updatet1,identicalTransaction);
        assertEquals(transaction1.getTransaction_ID(),updatet1.getTransaction_ID());
        assertNotSame(transaction1,updatet1);
        assertNotSame(transaction1.getDate(),updatet1.getDate());
        assertNotSame(transaction1.getTransaction_ID(),updatet1.getTransaction_ID());

        System.out.println("Transactions details updated...");
        System.out.println(TransactionRepository.getInstance().update(updatet1));
        System.out.println();

    }

    @Test
    void fDeleteTransactionTest(){
        boolean success = TransactionRepository.getInstance().delete((transaction1.getTransaction_ID()));
        assertNotNull(success);
        assertNotSame(transaction1,success);
        System.out.println("Delete success? " + success);
        System.out.println();
    }

    @Test
    void d_getAllTest(){
        System.out.println("Getting all results: ");
        assertNotNull(TransactionRepository.getInstance().getAll());
        System.out.println(TransactionRepository.getInstance().getAll());
        System.out.println();
    }



}
