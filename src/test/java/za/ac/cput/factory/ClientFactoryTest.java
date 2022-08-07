/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Client;

import static org.junit.jupiter.api.Assertions.*;

class ClientFactoryTest {
    private Client client1,client2;

    @BeforeEach
    void setUp(){
        client1 = ClientFactory.createClient("1",NameFactory.createName("Breyton","Sean",
                "Ernstzen"),BookFactory.CreateBook("A123","Happy Feet","Harry Lange",
                        "Fiction"), true);

        client2 = ClientFactory.createClient("2",NameFactory.createName("Ziyaad","Petersen"),
                BookFactory.CreateBook("B141","My Neighbour Totoro","Kim Jeen","Fiction"),
                true);
    }

    @Test
    void clientWithMiddleName(){

        assertAll(
                () -> assertNotNull(client1.getName().getMiddleName()),
                () -> assertSame("Sean",client1.getName().getMiddleName()),
                () -> assertNotNull(client1)

        );

        System.out.println("Test successfully passed");
        System.out.println(client1.toString());
    }

    @Test
    void clientWithoutMiddleName(){

        assertAll(
                () -> assertNull(client2.getName().getMiddleName()),
                () -> assertNotSame("",client2.getName().getMiddleName())

        );
        System.out.println("Test successfully passed");
        System.out.println(client2.toString());
    }

    @Test
    void objectEquality(){

        assertAll(
                () -> assertNotEquals(client1.getId(),client2.getId()),
                () -> assertNotEquals(client1.getName().getMiddleName(),client2.getName().getMiddleName()),
                () -> assertEquals(client1.isRented(),client2.isRented())
        );

        System.out.println("Test successfully passed");
    }

    @Test
    void objectIdentity(){

        assertAll(
                () -> assertNotSame(client1.getId(),client2.getId()),
                () -> assertNotSame(client1.getName().getMiddleName(),client2.getName().getMiddleName()),
                () -> assertSame(client1.isRented(),client2.isRented())

        );
    }

}