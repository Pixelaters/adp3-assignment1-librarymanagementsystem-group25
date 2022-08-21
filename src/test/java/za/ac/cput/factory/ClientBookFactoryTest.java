package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ClientBook;

import static org.junit.jupiter.api.Assertions.*;

class ClientBookFactoryTest {
    private ClientBook clientBook;

    @BeforeEach
    void setUp() {
         clientBook = ClientBookFactory.createClientBook("1","A1");
    }

    @Test
    void createClientBook() {

        assertAll(
                () -> assertNotNull(clientBook),
                () -> assertSame("1",clientBook.getClientId()),
                () -> assertSame("A1",clientBook.getBookId()),
                () -> assertNotSame("2",clientBook.getClientId()),
                () -> assertNotSame("aa",clientBook.getBookId())

        );

        System.out.println("client book created");
    }
}