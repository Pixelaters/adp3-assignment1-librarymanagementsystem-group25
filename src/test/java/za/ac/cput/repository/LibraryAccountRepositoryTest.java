package za.ac.cput.repository;
/**
 * LibraryAccountRepositoryTest.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 01 April 2022
 */
import org.junit.jupiter.api.*;
import za.ac.cput.entity.LibraryAccount;
import za.ac.cput.factory.LibraryAccountFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class LibraryAccountRepositoryTest {
    private static LibraryAccountRepository lar = LibraryAccountRepository.getInstance();
    private static LibraryAccount accountA = LibraryAccountFactory.addLibraryAccount("217", "1234", 11);

    @Test
    void aCreateLibraryAccountTest(){
        LibraryAccount la1 = LibraryAccountRepository.getInstance().create(accountA);
        LibraryAccount la2 = la1;
        LibraryAccount accountB = LibraryAccountFactory.addLibraryAccount("a", "456", 98);

        assertEquals(accountA.getAccount_ID(),la1.getAccount_ID());
        assertSame(accountB.getAccount_ID(),la1.getAccount_ID());
        assertNotSame(la1.getAccount_ID(),accountB.getAccount_ID());
        assertNotSame(la2.getTransaction_ID(),accountB.getTransaction_ID());
        assertSame(la1,la2);
        assertNotSame(la1,la2);
        assertNotNull(accountA);
        assertNotNull(la2);
        assertNotNull(accountB);
        System.out.println("Library Account/s has been added...");
        System.out.println();
    }

    @Test
    void bReadLibraryAccountTest(){
        LibraryAccount showla1 = LibraryAccountRepository.getInstance().read(accountA.getAccount_ID());
        LibraryAccount showla2 = showla1;
        LibraryAccount showla3 = LibraryAccountFactory.addLibraryAccount("152", "856", 11);

        assertNotNull(showla1);
        assertNotNull(showla3);
        assertNotSame(showla1.getAccount_ID(),showla3.getAccount_ID());
        assertNotSame(showla1,showla3);
        assertSame(showla1.getAccount_ID(),accountA.getAccount_ID());
        assertSame(showla1,showla2);
        assertEquals(accountA.getCustomer_ID(),showla1.getCustomer_ID());


        System.out.println("Reading through Library Accounts...");
        System.out.println(LibraryAccountRepository.getInstance().read("a"));
        System.out.println();
    }

    @Test
    void cUpdateLibraryAccountTest(){
        LibraryAccount updateLa1 = new LibraryAccount.LibraryAccountBuilder().copy(accountA)
                .setAccount_ID("195")
                .setTransaction_ID("312")
                .build();
        LibraryAccount identicalAccount = updateLa1;

        assertNotNull(updateLa1);
        assertNotNull(identicalAccount);
        assertSame(updateLa1,identicalAccount);
        assertEquals(accountA.getAccount_ID(),updateLa1.getAccount_ID());
        assertNotSame(accountA,updateLa1);
        assertNotSame(accountA.getTransaction_ID(),updateLa1.getTransaction_ID());
        assertNotSame(accountA.getAccount_ID(),updateLa1.getAccount_ID());

        System.out.println("Library Account details updated...");
        System.out.println(LibraryAccountRepository.getInstance().update(updateLa1));
        System.out.println();

    }

    @Test
    void fDeleteLibraryAccountTest(){
        boolean success = LibraryAccountRepository.getInstance().delete((accountA.getAccount_ID()));
        assertNotNull(success);
        assertNotSame(accountA,success);
        System.out.println("Delete success? " + success);
        System.out.println();
    }

    @Test
    void d_getAllTest(){
        System.out.println("Getting all results: ");
        assertNotNull(LibraryAccountRepository.getInstance().getAll());
        System.out.println(LibraryAccountRepository.getInstance().getAll());
        System.out.println();
    }



}
