/*
Nondumiso Gaga(220430853)
08/08/2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.LibrarianContact;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianContactFactoryTest {
    @Test
    void testLibrarianContact(){//all values are provided

        LibrarianContact librarianContact = LibrarianContactFactory.createLibrariancontact("3456","1234");
        assertNotNull(librarianContact);

    }
    @Test
    void withoutClientId(){
        LibrarianContact librarianContact = LibrarianContactFactory.createLibrariancontact("","1234");
        assertNotNull(librarianContact);


    }
    @Test
    void withoutBoth(){
        LibrarianContact librarianContact = LibrarianContactFactory.createLibrariancontact("","");
        assertNotNull(librarianContact);

    }


}