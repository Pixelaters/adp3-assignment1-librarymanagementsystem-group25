package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Library;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryFactoryTest {

    @Test
    public void addLibraryTest(){
        Library library = LibraryFactory.createLibrary(  9050, "Parkwood" , "Cape Town" , "25 Bird Street");

        assertNotNull(library);
        System.out.println("Library added");


    }

    @Test
    public void showLibrary(){
        Library testViewLibrary = LibraryFactory.createLibrary(  9050, "Parkwood" , "Cape Town" , "25 Bird Street");
        System.out.println(testViewLibrary.toString());
        assertNotNull(testViewLibrary);
    }

    @Test
    public void testObjectIdentity(){

        Library testViewLibrary1 = LibraryFactory.createLibrary(  9050, "Parkwood" , "Cape Town" , "25 Bird Street");
        Library testViewLibrary2 = LibraryFactory.createLibrary( 9051, "Greenwood" , "Pretoria" , "25 Mountain Street");
        Library testViewLibrary3 =testViewLibrary1;

        assertSame(testViewLibrary1,testViewLibrary2);
        assertNotSame(testViewLibrary2, testViewLibrary3);
        assertNotSame(testViewLibrary3, testViewLibrary1);
        assertNotSame(testViewLibrary1, testViewLibrary2);
        System.out.println("Library Updated");

    }

    @Test
    public void testObjectEquality(){

        Library testViewLibrary1 = LibraryFactory.createLibrary(9050, "Parkwood" , "Cape Town" , "25 Bird Street");
        Library testViewLibrary2 = LibraryFactory.createLibrary(9051, "Greenwood" , "Pretoria" , "25 Mountain Street");
        Library testViewLibrary3 = testViewLibrary1;
        Library testViewLibrary4 = testViewLibrary3;

        assertEquals(testViewLibrary1,testViewLibrary4);
        assertEquals(testViewLibrary2,testViewLibrary3);
        System.out.println("Library Updated");

    }

    @Test

    public void fail(String message){

    }
}
