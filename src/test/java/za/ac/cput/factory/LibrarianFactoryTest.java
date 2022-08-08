
/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Librarian;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianFactoryTest {
    @Test
    void testLibrarian(){// all value are provided
        Librarian librarian = LibrarianFactory.createLibrarian("5694","labrarian","Ongezwa","Ongie","Gwaza");
        assertNotNull(librarian);
        System.out.println(librarian);


        }
        @Test
        void testwithoutstaffId(){
            Librarian librarian = LibrarianFactory.createLibrarian("","labrarian","Ongezwa","Ongie","Gwaza");
            assertNotNull(librarian);

        }
@Test
    void testwithoutpostion(){

    Librarian librarian = LibrarianFactory.createLibrarian("56858","","Ongezwa","Ongie","Gwaza");
    assertNotNull(librarian);
}
@Test
void testwithoutfirstName()   {

    Librarian librarian = LibrarianFactory.createLibrarian("56858","","","Ongie","Gwaza");
    assertNotNull(librarian);

}
@Test
void testwithoutmiddleName(){
    Librarian librarian = LibrarianFactory.createLibrarian("56858","","Ongezwa","","Gwaza");
    assertNotNull(librarian);

}
@Test
    void testwithoutlastName(){
    Librarian librarian = LibrarianFactory.createLibrarian("56858","","Ongezwa","Ongie","");
    assertNotNull(librarian);

}
}