package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ClientContact;
import za.ac.cput.repository.ClientContactIRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)


class ClientContactServiceTest {

    @Mock

    private ClientContactIRepository clientContactIRepository;

    @Autowired
    ClientContactService clientContactService;

    private static ClientContact contact1 ,contact2;

    @BeforeEach
    void setUp() {
        clientContactService = new ClientContactService(clientContactIRepository);

        contact1 = new ClientContact.Builder().ContactId("324").ClientId("4569").createClientCont();

        contact2 = new ClientContact.Builder().ContactId("424").Copy(contact1).createClientCont();
    }


    @Test
    void a_create() {
        clientContactService.create(contact1);
        assertNotNull(contact1);
        System.out.println("Contact created successfully!");

    }

    @Test
    void b_read() {
        clientContactService.read(contact1.getContactId());
        assertNotNull(contact1);
        System.out.println(contact1);
    }

    @Test
    void c_update() {
        clientContactService.create(contact2);


                assertNotSame(contact1.getContactId(),contact2.getContactId());

                assertSame("424",contact2.getContactId());
        System.out.println("contact id updated");
        System.out.println(contact2.toString());

    }

    @Test
    void e_delete() {
        clientContactService.delete(contact2.getContactId());
        assertAll(
                () -> assertNotNull(contact2),
                () -> assertSame("324",contact1.getContactId()),
                () -> assertSame("4569",contact1.getClientId())
        );
        System.out.println("Deleted successfully");
    }

    @Test
    void d_getAll() {
        System.out.println(clientContactService.getAll());

        assertAll(
                () -> assertNotNull(clientContactService.getAll())
        );
    }
}