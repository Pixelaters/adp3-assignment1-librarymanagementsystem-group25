package za.ac.cput.factory;
/**
 * LibraryAccountFactory.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 27 March 2022
 */
import za.ac.cput.entity.LibraryAccount;


import java.util.UUID;
public class LibraryAccountFactory {

    public static String generateLibraryAccountID(){
        return UUID.randomUUID().toString();

    }

    public static LibraryAccount addLibraryAccount(String account_ID, String transaction_ID, int customer_ID){
        LibraryAccount newLibraryAccount = new LibraryAccount.LibraryAccountBuilder()
                .setAccount_ID(account_ID)
                .setTransaction_ID(transaction_ID)
                .setCustomer_ID(customer_ID)
                .build();

        return newLibraryAccount;


    }
    
}
