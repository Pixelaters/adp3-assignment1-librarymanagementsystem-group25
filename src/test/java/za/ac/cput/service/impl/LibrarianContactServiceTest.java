package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ClientContact;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.LibrarianContact;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.LibrarianFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.repository.LibrarianContactIRepository;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)

class LibrarianContactServiceTest {
    @Mock

    private LibrarianContactIRepository librarianContactIRepository;

    LibrarianContactService librarianContactService;

    public static LibrarianContact librarianContact,updateLibrariancontact;

    @BeforeEach
    void setUp() {
        librarianContactService = new LibrarianContactService(librarianContactIRepository);

        librarianContact = new LibrarianContact.Builder().Librarian(
                LibrarianFactory.createLibrarian("394","librarian","Amanda","","Booi")).
        Contact(ContactFactory.createContact("2354","meann@gmail.com","03456977","Bob")).build();

        updateLibrariancontact = new LibrarianContact.Builder().copy(librarianContact).Librarian(LibrarianFactory.createLibrarian
           (librarianContact.getLibrarian().getStaffId(),librarianContact.getLibrarian().getPosition(),
               librarianContact.getLibrarian().getName().getFirstName(),librarianContact.getLibrarian().getName().getMiddleName(),
                        librarianContact.getLibrarian().getName().getLastName())).
                Contact(ContactFactory.createContact("346","bling@gmail.com","0789543295","Lois")).build();


    }

    @Test
    void a_create() {
        librarianContactService.create(librarianContact);

        assertAll(
                () -> assertNotNull(librarianContact),
                () -> assertSame("394",librarianContact.getLibrarian().getStaffId()),
                () -> assertSame("2354",librarianContact.getContact().getContactId())
        );
        System.out.println("contact saved");


    }

    @Test
    void b_read() {
        librarianContactService.read(librarianContact.getLibrarian().getStaffId());
         assertNotNull(librarianContact);

        System.out.println(librarianContact);
          }

    @Test
    void c_update() {
        librarianContactService.update(updateLibrariancontact);

        assertAll(
                () -> assertNotSame(librarianContact.getContact().getContactId(),updateLibrariancontact.getContact().getContactId()),
                () -> assertNotSame(librarianContact.getContact().getEmail(),updateLibrariancontact.getContact().getEmail()),
                () -> assertNotSame(librarianContact.getContact().getCell(),updateLibrariancontact.getContact().getCell()),
                () -> assertNotSame(librarianContact.getContact().getNextOfKin(),updateLibrariancontact.getContact().getNextOfKin())
        );

        System.out.println("updated");
        System.out.println(updateLibrariancontact.toString());

    }

    @Test
    void e_delete() {
        librarianContactService.delete(updateLibrariancontact.getLibrarian().getStaffId());
         assertNotNull(updateLibrariancontact);

        System.out.println("contact deleted");

    }

    @Test
    void getAll() {
        librarianContactService.getAll();

        assertAll(
                () -> Assertions.assertNotNull(librarianContactService.getAll())
        );
        System.out.println(librarianContactService.getAll());
    }

}