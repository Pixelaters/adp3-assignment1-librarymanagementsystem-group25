package za.ac.cput.factory;
/*

        * TransactionFactory.java
        * Raeece Samuels (217283764)
        * ADP3 - Assignment1: Group 25
        * Date: 27 March 2022
        */

import org.junit.jupiter.api.*;

import za.ac.cput.entity.Transaction;



import static org.junit.jupiter.api.Assertions.*;
public class TransactionTest {

    @Test
    public void addTransaction(){
        //test to add a new transaction
        Transaction testNewTransaction = TransactionFactory.addTransaction("217",java.time.LocalDate.now(), "123");
        System.out.println("Transaction successfully processed...");
        assertNotNull(testNewTransaction);
    }

    @Test
    public void showTransaction(){
        //test to show transaction
        Transaction testNewDisplayTransaction = TransactionFactory.addTransaction("217",java.time.LocalDate.now(), "123");
        System.out.println("Transaction successfully processed...");
        assertNotNull(testNewDisplayTransaction);
    }

    @Test
    public void testTransactionIdentity(){
        //testing Identity of Transaction
        Transaction testTransactionDisplay1 = TransactionFactory.addTransaction("218",java.time.LocalDate.now(),"2017");
        Transaction testTransactionDisplay2 = TransactionFactory.addTransaction("200",java.time.LocalDate.now(),"21");
        Transaction testTransactionDisplay3 = testTransactionDisplay1;

        assertSame(testTransactionDisplay1,testTransactionDisplay3);
        assertNotSame(testTransactionDisplay2,testTransactionDisplay1);
        assertNotSame(testTransactionDisplay3,testTransactionDisplay2);
        System.out.println("Tests successfully passed!...");
    }

    @Test
    public void testAccountEquality(){
        //test Transaction equality
        Transaction testTransactionDisplay1 = TransactionFactory.addTransaction("280",java.time.LocalDate.now(),"201");
        Transaction testTransactionDisplay2 = TransactionFactory.addTransaction("195",java.time.LocalDate.now(),"55");
        Transaction testTransactionDisplay3 = testTransactionDisplay1;
        Transaction testTransactionDisplay4 = testTransactionDisplay2;

        assertEquals(testTransactionDisplay1,testTransactionDisplay3);
        assertEquals(testTransactionDisplay2,testTransactionDisplay4);
        System.out.println("Tests successfully passed!...");
    }

    @Test
    //Disabled
    public void unsuccessful(String msg){
        System.out.println("There was an error in processing.Please retry...");
    }
}


