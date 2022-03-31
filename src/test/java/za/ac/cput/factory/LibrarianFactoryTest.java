package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Librarian;

import static org.junit.jupiter.api.Assertions.*;

/*
    LibrarianFactoryTest.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 29 March 2022
 */

class LibrarianFactoryTest {

    @Test
    void CreateLibrarianTest1() {
            Librarian librarian = LibrarianFactory.createLibrarian(123123, "Ziyaad", "Petersen", "33 Michigan Way", 833806377, "A50", "Libririan", true );
            assertNotNull(librarian);
        System.out.println("Librarian added");
    }

    @Test
    void AddLibrarianTest2(){
        Librarian librarian = (Librarian) new Librarian.LibrarianBuilder()
                .setStaffMember_ID(23132)
                .setFirstName("Pixel")
                .setLastName("Laters")
                .build();
        assertNotNull(librarian);
        System.out.println("Librarian added");
    }

    @Test
     void ShowLibrarianDetails(){
        Librarian librarian = LibrarianFactory.createLibrarian(123123, "Ziyaad", "Petersen",
                "33 Michigan Way", 833806377, "A50", "Libririan", true );
        System.out.println(librarian);
        assertNotNull(librarian);
    }

    @Test
    void testObjectIdentity(){
        Librarian librarian0 = LibrarianFactory.createLibrarian(123123, "Ziyaad", "Petersen",
                "33 Michigan Way", 833806377, "A50", "Libririan", true );
        //same as librarian0
        Librarian librarian1 = librarian0;
        Librarian librarian2 = LibrarianFactory.createLibrarian(123123, "Raeece", "Breyton",
                "32 BergRivier", 831231231, "J50", "Libririan", false );
        assertSame(librarian0, librarian1);


        assertNotSame(librarian0, librarian2);
        System.out.println("test passed");
    }

    @Test
    void TestObjectEquality(){
        Librarian librarian0 = LibrarianFactory.createLibrarian(123123, "Ziyaad", "Petersen",
                "33 Michigan Way", 833806377, "A50", "Libririan", true );
        Librarian librarian1 = librarian0;

        assertEquals(librarian0,librarian1);
    }

    @Test
    void fail(String failTest){

    }




}