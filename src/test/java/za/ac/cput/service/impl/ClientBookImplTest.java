package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.ClientBook;
import za.ac.cput.repository.ClientBookIRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientBookImplTest {
    @Mock
    private ClientBookIRepository clientBookIRepository;

    ClientBookImpl clientBook;

    private static ClientBook clientBook1,updateClientBook;

    @BeforeEach
    void setUp() {
        clientBook = new ClientBookImpl(clientBookIRepository);

        clientBook1 = new ClientBook.Builder()
                .clientId("1")
                .bookId("A1")
                .build();

        updateClientBook = new ClientBook.Builder().copy(clientBook1)
                .bookId("ZZ3")
                .build();

    }

    @Test
    void a_create() {
        clientBook.create(clientBook1);

        assertAll(
                () -> assertNotNull(clientBook1),
                () -> assertSame("1",clientBook1.getClientId()),
                () -> assertSame("A1",clientBook1.getBookId())
        );

        System.out.println("Client book created");
        System.out.println();
    }

    @Test
    void b_read() {
        clientBook.read(clientBook1.getClientId());

        assertAll(
                () -> assertNotNull(clientBook1.getClientId()),
                () -> assertEquals("1",clientBook1.getClientId())
        );

        System.out.println(clientBook1);
        System.out.println();

    }

    @Test
    void c_update() {
        clientBook.update(updateClientBook);

        assertAll(
                () -> assertNotSame(clientBook1.getBookId(),updateClientBook.getBookId()),
                () -> assertSame("ZZ3",updateClientBook.getBookId())
        );

        System.out.println("Client book updated");
        System.out.println(updateClientBook.toString());
    }

    @Test
    void d_delete() {
        clientBook.delete(updateClientBook.getClientId());

        assertAll(
                () -> assertSame("ZZ3",updateClientBook.getBookId())
        );

        System.out.println("Client book deleted");
    }

    @Test
    void e_getAll() {
        clientBook.getAll();

        assertAll(
                () -> assertNotNull(clientBook.getAll())
        );

        System.out.println(clientBook.getAll());
        System.out.println();
    }

    @Test
    void f_findClientBooksByClientId() {
        clientBook.findClientBooksByClientId("1");

        assertAll(
                () -> assertNotNull(updateClientBook)
        );

        System.out.println(clientBook.findClientBooksByClientId("1"));

    }
}