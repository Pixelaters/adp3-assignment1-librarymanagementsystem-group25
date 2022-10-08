package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ClientBook;

import static org.junit.jupiter.api.Assertions.*;

class ClientBookFactoryTest {
    private ClientBook clientBook1,clientBook2;

    @BeforeEach
    void setUp(){
        clientBook1 = ClientBookFactory.createClientBook(ClientFactory.createClient("1",
                NameFactory.createName("Breyton","Sean","Ernstzen")),
                BookFactory.CreateBook("ZZ1","Finding Gobby","James Franke","fiction", "description","false", "https://something.jpg"));

        clientBook2 = ClientBookFactory.createClientBook(ClientFactory.createClient("2",
                        NameFactory.createName("Ziyaad","Petersen")),
                BookFactory.CreateBook("AA1","Frankenstein","Claude van Damme","science-fiction", "description","false", "https://something.jpg"));
    }

    @Test
    void objectIdentity(){

        assertAll(
                () -> assertNotSame(clientBook1.getClient().getClientId(),clientBook2.getClient().getClientId()),
                () -> assertNotSame(clientBook1.getBook().getBookId(),clientBook2.getBook().getBookId()),
                () -> assertNotNull(clientBook1),
                () -> assertNotNull(clientBook2),
                () -> assertSame("1",clientBook1.getClient().getClientId()),
                () -> assertSame("2",clientBook2.getClient().getClientId())
        );

        System.out.println("success");
    }

    @Test
    void objectEquality(){

        assertAll(
                () -> assertNotEquals(clientBook1.getClient().getClientId(),clientBook2.getClient().getClientId()),
                () -> assertNotEquals(clientBook1.getBook().getBookId(),clientBook2.getBook().getBookId()),
                () -> assertNotEquals(clientBook1,clientBook2)
        );

        System.out.println("success");
    }
}