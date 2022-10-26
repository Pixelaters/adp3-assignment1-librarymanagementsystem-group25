package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ClientContact;
import za.ac.cput.factory.ClientContactFactory;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.NameFactory;
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

        contact1 = ClientContactFactory.createClientcontact("3456",
                ClientFactory.createClient("1", NameFactory.createName("Ben","","James")),
                ContactFactory.createContact("123456789","ben@gmail.com","0634048401","0713514211"));
        assertNotNull(contact1);

        contact2 = ClientContactFactory.createClientcontact("1011",
                ClientFactory.createClient("2",NameFactory.createName("Yan","Rodriguez","Barry")),
                ContactFactory.createContact("24681012","Yan@gmail.com","0862128401","0612151421"));
        assertNotNull(contact2);
    }

    @Test
    void a_create() {
        clientContactService.create(contact1);

        assertAll(
                () -> assertSame("3456",contact1.getClientContactId()),
                () -> assertSame("1011",contact2.getClientContactId())
        );

        System.out.println("Contact created successfully!");

    }

    @Test
    void b_read() {
        clientContactService.read(contact1.getClientContactId());
        assertNotNull(contact1);
        System.out.println(contact1);
    }

    @Test
    void c_update() {
        clientContactService.create(contact2);

        assertNotSame(contact1.getClientContactId(),contact2.getClientContactId());

        System.out.println("contact id updated");
        System.out.println(contact2.toString());

    }

    @Test
    void e_delete() {
        clientContactService.delete(contact2.getClientContactId());
        assertAll(
                () -> assertSame("3456",contact1.getClientContactId()),
                () -> assertSame("1011",contact2.getClientContactId())
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