/*
Nondumiso Gaga(220430853)
08/08/2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ClientContact;

import static org.junit.jupiter.api.Assertions.*;

class ClientContactFactoryTest {

    private ClientContact clientContact1,clientContact2;

    @BeforeEach
    void setUp(){
        clientContact1 = ClientContactFactory.createClientcontact("3456",
                ClientFactory.createClient("1",NameFactory.createName("Ben","","James")),
                ContactFactory.createContact("123456789","ben@gmail.com","0634048401","0713514211"));
        assertNotNull(clientContact1);

        clientContact2 = ClientContactFactory.createClientcontact("1011",
                ClientFactory.createClient("2",NameFactory.createName("Yan","Rodriguez","Barry")),
                ContactFactory.createContact("24681012","Yan@gmail.com","0862128401","0612151421"));
        assertNotNull(clientContact2);
    }

    @Test
    void objectIdentity(){

        assertAll(
                () -> assertNotSame(clientContact1.getClientContactId(),clientContact2.getClientContactId()),
                () -> assertSame("1", clientContact1.getClient().getClientId()),
                () -> assertSame("2",clientContact2.getClient().getClientId()),
                () -> assertSame("123456789", clientContact1.getContact().getContactId()),
                () -> assertSame("24681012",clientContact2.getContact().getContactId()),
                () -> assertNotNull(clientContact1),
                () -> assertNotNull(clientContact2)
        );
        System.out.println("Test passed");

    }
    @Test
    void objectEquality(){

        assertAll(
                () -> assertNotEquals(clientContact1.getClient().getClientId(),clientContact2.getClient().getClientId()),
                () -> assertNotEquals(clientContact1,clientContact2),
                () -> assertNotEquals(clientContact1.getClientContactId(),clientContact2.getClientContactId())
        );

        System.out.println("Test passed");

    }
}