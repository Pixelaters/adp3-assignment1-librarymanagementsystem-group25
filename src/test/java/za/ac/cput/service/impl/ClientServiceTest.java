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
import za.ac.cput.domain.Client;
import za.ac.cput.factory.BookFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.repository.ClientIRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientServiceTest {
    @Mock
    private ClientIRepository testClientIRepository;

    ClientService clientService;

    private static Client client1, updateClient1;

    @BeforeEach
    void setUp() {
        clientService = new ClientService(testClientIRepository);

        client1 = new Client.Builder()
                .id("1")
                .name(NameFactory.createName("Breyton","Sean","Ernstzen"))
                .book(BookFactory.CreateBook("AZ1","Finding Gobby","Ralf Witzel","fiction"))
                .isRented(true)
                .build();

        updateClient1 = new Client.Builder().copy(client1)
                .isRented(false)
                .build();

    }

    @Test
    void a_create() {
        testClientIRepository.save(client1);

        assertAll(
                () -> assertNotNull(client1),
                () -> assertSame("1",client1.getId()),
                () -> assertSame("AZ1",client1.getBook().getBookId()),
                () -> assertTrue(client1.isRented())
        );

        System.out.println("Client saved successfully");
        System.out.println();
        //System.out.println(client1.toString());

    }

    @Test
    void b_read() {
        testClientIRepository.getReferenceById(client1.getId());

        assertAll(
                () -> assertNotNull(client1)
        );

        System.out.println(client1);
        System.out.println();
    }

    @Test
    void c_update() {
        testClientIRepository.save(updateClient1);

        assertAll(
                () -> assertNotSame(client1.isRented(),updateClient1.isRented()),
                () -> assertSame(false,updateClient1.isRented()),
                () -> assertFalse(updateClient1.isRented()),
                () -> assertSame("1",updateClient1.getId())
        );

        System.out.println("Details updated");
        System.out.println(updateClient1.toString());
        System.out.println();
    }

    @Test
    void d_delete() {
        testClientIRepository.deleteById(updateClient1.getId());

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
        System.out.println(testClientIRepository.findAll());

        assertAll(
                () -> assertNotNull(testClientIRepository.findAll())
        );

        System.out.println();

    }

    @Test
    void f_findClientById() {
        testClientIRepository.findClientById(updateClient1.getId());

        assertAll(
                () -> assertNotNull(updateClient1)
        );

        System.out.println("Client id: " + updateClient1.getId());
    }
}