/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import za.ac.cput.domain.Client;

import static org.junit.jupiter.api.Assertions.*;

class ClientFactoryTest {
    private Client client1,client2;

    @BeforeEach
    void setUp(){
        client1 = ClientFactory.createClient("1",NameFactory.createName("Breyton","Sean",
                "Ernstzen"),BookFactory.CreateBook("Happy Feet","Harry Lange","Fiction"),
                true);
    }

}