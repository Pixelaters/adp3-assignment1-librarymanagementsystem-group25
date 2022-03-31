package za.ac.cput.factory;
/**
 * TransactionFactory.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 27 March 2022
 */
import za.ac.cput.entity.Transaction;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
public class TransactionFactory {

    public static String generateTransactionID(){
        return UUID.randomUUID().toString();
    }

    public static Transaction addTransaction(String transaction_ID, LocalDate date, String details){
         Transaction newTransaction = new Transaction.TransactionBuilder()
                 .setTransaction_ID(transaction_ID)
                 .setDate(date)
                 .setDetails(details)
                 .build();

         return newTransaction;


    }
}
