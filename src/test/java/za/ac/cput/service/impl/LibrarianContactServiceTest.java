package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ClientContact;
import za.ac.cput.domain.LibrarianContact;
import za.ac.cput.repository.LibrarianContactIRepository;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)

class LibrarianContactServiceTest {
    @Mock

    private LibrarianContactIRepository librarianContactIRepository;

    @Autowired
   LibrarianContactService librarianContactService;

    private static LibrarianContact contact1 ,contact2;

    @BeforeEach
    void setUp() {
        librarianContactService = new LibrarianContactService(librarianContactIRepository);

        contact1 = new LibrarianContact.Builder().ContactId("566").LibrarianId("67433").createLibrarianC();

        contact2 = new LibrarianContact.Builder().ContactId("756").Copy(contact1).createLibrarianC();

    }

    @Test
    void a_create() {
        librarianContactService.create(contact1);
        assertNotNull(contact1);
        System.out.println("saved successfully");
    }

    @Test
    void b_read() {
        librarianContactService.read(contact1.getContactId());
        assertNotNull(contact1);
        System.out.println(contact1);
    }

    @Test
    void c_update() {
        librarianContactService.create(contact2);
        assertNotSame(contact1.getContactId(),contact2.getContactId());

        assertSame("756",contact2.getContactId());

        System.out.println("updated");
    }

    @Test
    void e_delete() {
        librarianContactService.delete(contact2.getContactId());
        assertAll(
                () -> Assertions.assertNotNull(contact2),
                () -> assertSame("566",contact1.getContactId()),
                () -> assertSame("67433",contact1.getLibrarianId())
        );
        System.out.println("Deleted successfully");
    }

    @Test
    void getAll() {
        System.out.println(librarianContactService.getAll());

        assertAll(
                () -> Assertions.assertNotNull(librarianContactService.getAll())
        );
    }
}