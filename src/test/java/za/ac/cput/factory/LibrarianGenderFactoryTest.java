
/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianGender;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianGenderFactoryTest {
    static Librarian librarian;
    static Gender gender;
     @BeforeAll
     static void setUp(){
          librarian = LibrarianFactory.createLibrarian("5694","labrarian","Ongezwa","Ongie","Gwaza");
          gender = GenderFactory.createGender("f","female","girls and woman");

     }

    @Test
    void testLibrarianGender() {// all value are provided
        LibrarianGender librarianGender = LibrarianGenderFactory.createLibrariangender(librarian, gender);
        assertNotNull(librarianGender);
        System.out.println(librarianGender);
    }
    @Test
    void testwithoutlibrarian(){
        LibrarianGender librarianGender = LibrarianGenderFactory.createLibrariangender(null, gender);
        assertNotNull(librarianGender);
        System.out.println(librarianGender);


    }
    @Test
    void testwithoutgender(){

        LibrarianGender librarianGender = LibrarianGenderFactory.createLibrariangender(librarian, null);
        assertNotNull(librarianGender);
        System.out.println(librarianGender);
    }
}