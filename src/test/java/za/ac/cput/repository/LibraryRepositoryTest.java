package za.ac.cput.repository;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;



import za.ac.cput.entity.Library;


import za.ac.cput.factory.LibraryFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)

 class LibraryRepositoryTest {

    private static LibraryRepository libraryRepository = LibraryRepository.getInstance();
    private static Library library_a = LibraryFactory.createLibrary(9050 , "Parkwood" , "Cape Town" , "25 Bird Street");

    private static Library library_b = LibraryFactory.createLibrary(9051, "Darkwood" , "Pretoria" , "25 Eagle Street");


    @Test
    void a_CreateLibraryTest() {

        Library newLibrary1 = libraryRepository.create(library_a);
        Library newLibrary2 = libraryRepository.create(library_b);
        Library newLibrary3 = newLibrary1;
        Library newLibrary4 = newLibrary2;

        assertNotNull(newLibrary1);
        assertNotNull(newLibrary2);
        assertEquals(newLibrary1,newLibrary3);
        assertEquals(newLibrary2,newLibrary4);
        assertNotSame(library_a,library_b);
        assertSame(library_a,newLibrary1);
        assertSame(library_b,newLibrary2);
        assertSame(library_a.isAddress(),library_b.isAddress());
        assertEquals(library_a.isLocation(),library_b.isLocation());

        System.out.println(" Location  added...");
        System.out.println();
    }

    @Test
    void b_ReadLibraryTest() {

        Library readLibrary =  libraryRepository.read( library_a.getLibraryId());
        Library anotherLibrary = readLibrary;

        assertNotNull(readLibrary);
        assertSame( library_a,readLibrary);
        assertSame( library_a.isAddress() , readLibrary.isAddress());
        assertSame( library_a.isLocation() , readLibrary.isLocation());
        assertNotSame(library_b,readLibrary);
        assertEquals(library_a,readLibrary);

        System.out.println("The Library data is reading");
        System.out.println(libraryRepository.read("9050"));
        System.out.println();
    }

    @Test
    void c_UpdateLibraryTest() {


        Library updateLibrary = (Library) new Library.Builder()
                .setLibraryId(library_b.getLibraryId())
                .setLocation(library_b.getLocation())
                .setName(library_b.getName())
                .setAddress(library_b.getAddress())
                .build();


        assertNotNull(updateLibrary);
        assertNotSame(library_b,updateLibrary);
        assertNotSame(library_b.getLibraryId() ,updateLibrary.getLibraryId());
        assertNotSame(library_b.getName() , updateLibrary.getName());
        assertNotSame(library_b.getLocation() , updateLibrary.getLocation());
        assertNotSame(library_b.getAddress() , updateLibrary.getAddress() );


        System.out.println(library_b.getLibraryId() + "Updated Sucessfully");
        System.out.println(libraryRepository.update(updateLibrary));
        System.out.println();

    }

    @Test
    void e_DeleteComputer() {

        boolean success = LibraryRepository.getInstance().delete(library_b.getLibraryId());
        assertNotNull(success);

        System.out.println("Delete Success" + success);
        System.out.println();
    }

    @Test
    void d_getAllTest() {

        System.out.println("Getting all Libraries");
        System.out.println(libraryRepository.getAll()  );
        System.out.println();
    }
}
