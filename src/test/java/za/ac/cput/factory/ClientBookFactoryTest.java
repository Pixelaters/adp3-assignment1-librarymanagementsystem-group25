package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ClientBook;

import static org.junit.jupiter.api.Assertions.*;

class ClientBookFactoryTest {
    private ClientBook clientBook1,clientBook2;

   @BeforeEach
   void setUp(){
       clientBook1 = ClientBookFactory.createClientBook("123456789",ClientFactory.createClient("1010101010",
               NameFactory.createName("Dennis","","Zakaria")),
               BookFactory.CreateBook("123","Finding Gobbie","Anne James","Dixon Rodrigues",
                       "John Smith","adventure","science","fiction","funf for kids",
                       "yes","https://myprofile.com"),"2022/10/26");

        clientBook2 = ClientBookFactory.createClientBook("987654321",ClientFactory.createClient("1111111111",
                        NameFactory.createName("Timo","Danny","van Gaal")),
                BookFactory.CreateBook("AZZ","The Farm","Mike Billings","Chris Maddisson",
                        "Wayne Smeichel","horror","suspense","mystery","gives goosebumps",
                        "yes","https://myprofile1.com"),"2022/10/26");
    }

    @Test
    void objectIdentity(){

        assertAll(
                () -> assertNotSame(clientBook1.getClientBookId(),clientBook2.getClientBookId()),
                () -> assertNotSame(clientBook1.getClients().getClientId(),clientBook2.getClients().getClientId()),
                () -> assertNotSame(clientBook1.getBooks().getBookId(),clientBook2.getBooks().getBookId()),
                () -> assertNotNull(clientBook1),
                () -> assertNotNull(clientBook2),
                () -> assertSame("123456789",clientBook1.getClientBookId()),
                () -> assertSame("987654321",clientBook2.getClientBookId())
        );

        System.out.println("success");
    }

    @Test
    void objectEquality(){

        assertAll(
                () -> assertNotEquals(clientBook1.getClientBookId(),clientBook2.getClientBookId()),
                () -> assertNotEquals(clientBook1.getClients().getClientId(),clientBook2.getClients().getClientId()),
                () -> assertNotEquals(clientBook1.getBooks().getBookId(),clientBook2.getBooks().getBookId())
        );

        System.out.println("success");
    }
}