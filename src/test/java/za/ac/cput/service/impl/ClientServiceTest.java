/*
    Breyton Ernstzen (217203027)
    ADP3
    Capstone Project
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Client;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.repository.ClientIRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientServiceTest {
    @Mock
    ClientIRepository clientIRepository;

    @Autowired
    ClientService clientService;

    private static Client client1, updateClient1;

    @BeforeEach
    void setUp() {
        clientService = new ClientService(clientIRepository);

        client1 = new Client.Builder()
                .id("1")
                .name(NameFactory.createName("Breyton","Sean","Ernstzen"))
                .isRented(true)
                .build();

        updateClient1 = new Client.Builder().copy(client1)
                .isRented(false)
                .build();

    }

    @Test
    void a_create() {
        clientService.create(client1);

        assertAll(
                () -> assertNotNull(client1),
                () -> assertSame("1",client1.getClientId()),
                () -> assertTrue(client1.isRented())
        );

        System.out.println("Client saved successfully");
        System.out.println();
        //System.out.println(client1.toString());

    }

    @Test
    void b_read() {
        clientService.read(client1.getClientId());

        assertAll(
                () -> assertNotNull(client1)
        );

        System.out.println(client1);
        System.out.println();
    }

    @Test
    void c_update() {
        clientService.create(updateClient1);

        assertAll(
                () -> assertNotSame(client1.isRented(),updateClient1.isRented()),
                () -> assertSame(false,updateClient1.isRented()),
                () -> assertFalse(updateClient1.isRented()),
                () -> assertSame("1",updateClient1.getClientId())
        );

        System.out.println("Details updated");
        System.out.println(updateClient1.toString());
        System.out.println();
    }

    @Test
    void f_delete() {
       clientService.delete(updateClient1.getClientId());

        assertAll(
                () -> assertNotNull(updateClient1),
                () -> assertSame("Breyton",client1.getName().getFirstName()),
                () -> assertSame("Sean",client1.getName().getMiddleName()),
                () -> assertSame("Ernstzen",client1.getName().getLastName())
        );

        System.out.println("Delete success.");
        System.out.println();
    }

    @Test
    void e_getAll() {
        System.out.println(clientService.getAll());

        assertAll(
                () -> assertNotNull(clientService.getAll())
        );

        System.out.println();

    }

    @Test
    void d_findClientById() {
        clientService.findClientById("1");

        assertAll(
                () -> assertNotNull(updateClient1)
        );

        System.out.println(clientService.findClientById("1"));
    }
}