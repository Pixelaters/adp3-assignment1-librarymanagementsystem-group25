package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ClientContact;
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

    private static ClientContact Clientcontact ,updatecontact;

    @BeforeEach
    void setUp() {
        clientContactService = new ClientContactService(clientContactIRepository);

        Clientcontact = new ClientContact.Builder().Client(ClientFactory.createClient("6",
                        NameFactory.createName("Bob", " ", "James"), true)).
                Contact(ContactFactory.createContact("89", "pink@gmail.com", "0453988623", "0842345467")).build();

        updatecontact = new ClientContact.Builder().copy(Clientcontact)
                .Client(ClientFactory.createClient(Clientcontact.getClient().getClientId(),
                        NameFactory.createName(Clientcontact.getClient().getName().getFirstName(),
                                Clientcontact.getClient().getName().getMiddleName(),
                                Clientcontact.getClient().getName().getLastName()),Clientcontact.getClient().isRented()))
                .Contact(ContactFactory.createContact("7","cool32@gmail.com","0874562345","0673243456"))
                .build();
    }


    @Test
    void a_create() {
        clientContactService.create(Clientcontact);
        assertAll(
                () -> assertNotNull(Clientcontact),
                () -> assertSame("6",Clientcontact.getClient().getClientId()),
                () -> assertSame("89",Clientcontact.getContact().getContactId()),
                () -> assertSame(true,Clientcontact.getClient().isRented())
        );
        System.out.println("created");

    }

    @Test
    void b_read() {
        clientContactService.read(Clientcontact.getClient().getClientId());
        assertNotNull(Clientcontact);
        System.out.println(Clientcontact);
    }

    @Test
    void c_update() {
        clientContactService.update(updatecontact);

        assertAll(
                () -> assertNotSame(Clientcontact.getContact().getContactId(),updatecontact.getContact().getContactId()),
                () -> assertNotSame(Clientcontact.getContact().getEmail(),updatecontact.getContact().getEmail()),
                () -> assertNotSame(Clientcontact.getContact().getCell(),updatecontact.getContact().getCell()),
                () -> assertNotSame(Clientcontact.getContact().getNextOfKin(),updatecontact.getContact().getNextOfKin())
        );
        System.out.println("contact updated");
        System.out.println(updatecontact.toString());


    }

    @Test
    void e_delete() {
        clientContactService.delete(updatecontact.getClient().getClientId());

        assertNotNull(updatecontact);

    }

    @Test
    void d_getAll() {
       clientContactService.getAll();

        assertAll(
                () -> assertNotNull(clientContactService.getAll())
        );
        System.out.println(clientContactService.getAll());
    }


}