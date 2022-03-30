package za.ac.cput.factory;
/**
 * LibraryAccountFactory.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 27 March 2022
 */
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.LibraryAccount;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

class LibraryAccountTest {

    @Test
    public void addLibraryAccountTest(){
        //test to add a new Library Account
        LibraryAccount testNewLibraryAccount = LibraryAccountFactory.addLibraryAccount("007","done", 11);
        System.out.println("LibraryAccount Successfully added...");
        assertNotNull(testNewLibraryAccount);

    }

    @Test
    public void showLibraryAccountTest(){
        //test for account validation and displaying results
        LibraryAccount testDisplayLibraryAccount = LibraryAccountFactory.addLibraryAccount("007","done", 11);
        System.out.println("LibraryAccount Successfully added...");
        assertNotNull(testDisplayLibraryAccount);

    }

    @Test
    public void testAccountIdentity(){
        //test Library Account identity
        LibraryAccount testDisplayLibraryAccount1 = LibraryAccountFactory.addLibraryAccount("132", "523" ,11);
        LibraryAccount testDisplayLibraryAccount2 = LibraryAccountFactory.addLibraryAccount("120", "23" ,13);
        LibraryAccount testDisplayLibraryAccount3 = testDisplayLibraryAccount1;

            assertSame(testDisplayLibraryAccount1,testDisplayLibraryAccount3);
            assertNotSame(testDisplayLibraryAccount2,testDisplayLibraryAccount1);
            assertNotSame(testDisplayLibraryAccount3,testDisplayLibraryAccount2);
            System.out.println("Tests passed!...");
    }

    @Test
    public void testAccountEquality(){
        //test Library Account equality
        LibraryAccount testDisplayLibraryAccount1 = LibraryAccountFactory.addLibraryAccount("132", "523" ,11);
        LibraryAccount testDisplayLibraryAccount2 = LibraryAccountFactory.addLibraryAccount("120", "23" ,13);
        LibraryAccount testDisplayLibraryAccount3 = testDisplayLibraryAccount1;
        LibraryAccount testDisplayLibraryAccount4 = testDisplayLibraryAccount2;

        assertEquals(testDisplayLibraryAccount1,testDisplayLibraryAccount3);
        assertEquals(testDisplayLibraryAccount2,testDisplayLibraryAccount4);
        System.out.println("Tests passed!...");
    }

    @Test
    //Disabled
    public void unsuccessful(String msg){
        System.out.println("There was an error in processing.Please retry...");
    }
}
