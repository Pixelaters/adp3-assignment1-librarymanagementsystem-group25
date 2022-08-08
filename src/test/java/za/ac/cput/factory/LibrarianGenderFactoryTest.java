
/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianGender;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianGenderFactoryTest {

    @Test
    void testLibrarianGender() {// all value are provided
        LibrarianGender librarianGender = LibrarianGenderFactory.createLibrariangender("5555", "36525");
        assertNotNull(librarianGender);
        System.out.println(librarianGender);
    }
    @Test
    void testwithoutlibrarianId(){
        LibrarianGender librarianGender = LibrarianGenderFactory.createLibrariangender("", "36525");
        assertNotNull(librarianGender);
        System.out.println(librarianGender);


    }
    @Test
    void testwithoutgenderId(){

        LibrarianGender librarianGender = LibrarianGenderFactory.createLibrariangender("99999", "");
        assertNotNull(librarianGender);
        System.out.println(librarianGender);
    }
}