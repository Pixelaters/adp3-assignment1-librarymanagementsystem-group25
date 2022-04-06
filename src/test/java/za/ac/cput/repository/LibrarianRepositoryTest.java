package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Librarian;
import za.ac.cput.factory.LibrarianFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
    LibrarianRepository.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 26 April 2022
 */

public class LibrarianRepositoryTest {
    private static final Librarian accountA = LibrarianFactory.createLibrarian(111, "Ziyaad", "Petersen", "33 Michigan Way", 833806377,"214", "Librarian", true );

    @Test
    void aCreateStaffTest(){
        Librarian st1 = LibrarianRepository.getInstance().create(accountA);
        Librarian st2 = st1;
        Librarian accountB = LibrarianFactory.createLibrarian(112, "Breyton", "Raeece", "33 Avenue", 874592332, "213", "Librarian", true);

        assertEquals(accountA.getLibrarianCode(),st1.getLibrarianCode());
        System.out.println("test 1 is equal");
        assertNotSame(accountB.getLibrarianCode(),st1.getLibrarianCode());
        System.out.println("test 2 is same");
        assertNotSame(st1.getLibrarianCode(),accountB.getLibrarianCode());
        System.out.println("test 3 is not same");
        assertNotSame(st2.getHomeAddress(),accountB.getHomeAddress());
        System.out.println("test 4 is not same");
        assertSame(st1,st2);
        System.out.println("test 5 is same");
        //assertNotSame(st1,st2); fails
        //System.out.println("test 6 is not same");
        assertNotNull(accountA);
        System.out.println("test 7 is not null");
        assertNotNull(st2);
        System.out.println("test 8 is not null");
        assertNotNull(accountB);
        System.out.println("test 9 is not null");
        System.out.println("Librarian Account/s has been added...");
        System.out.println();
    }

    @Test
    void bReadStaffTest(){
        Librarian showst = LibrarianRepository.getInstance().read(accountA.getLibrarianCode());
        Librarian showst2 = showst;
        Librarian showst3 = LibrarianFactory.createLibrarian(111, "Ziyaad", "Petersen", "33 Michigan Way", 833806377,"214", "Librarian", true);

        assertNull(showst);
        System.out.println("test 1 passed");
        assertNotNull(showst3);
        assertNotSame(showst.getLibrarianCode(),showst3.getLibrarianCode());
        assertNotSame(showst,showst3);
        assertSame(showst.getLibrarianCode(),accountA.getLibrarianCode());
        assertSame(showst,showst2);
        assertEquals(accountA.getLibrarianCode(),showst.getLibrarianCode());


        System.out.println("Processing accounts...");
        System.out.println(LibrarianRepository.getInstance().read("214"));
        System.out.println();
    }

    @Test
    void cUpdateStaffTest(){
        Librarian updateSt1 = new Librarian.LibrarianBuilder().copy(accountA)
                .setLibrarianCode("212")
                .setAvailability(false)
                .build();

        assertNotNull(updateSt1);
        assertNotNull(updateSt1);
        assertSame(updateSt1, updateSt1);
        assertNotEquals(accountA.getLibrarianCode(),updateSt1.getLibrarianCode());
        assertNotSame(accountA,updateSt1);
        assertNotSame(accountA.getHomeAddress(),updateSt1.getHomeAddress());
        assertNotSame(accountA.getLibrarianCode(),updateSt1.getLibrarianCode());
        System.out.println("Library Account details updated...");
    }

    @Test
    void fDeleteStaffTest(){
        boolean success = LibrarianRepository.getInstance().delete((accountA.getLibrarianCode()));
        assertNotNull(success);
        assertNotSame(accountA,success);
        System.out.println("Delete success? " + success);
        System.out.println();
    }

    @Test
    void d_getAllTest(){
        System.out.println("Getting all results: ");
        assertNotNull(LibrarianRepository.getInstance().getAll());
        System.out.println(LibrarianRepository.getInstance().getAll());
        System.out.println();
    }
}
