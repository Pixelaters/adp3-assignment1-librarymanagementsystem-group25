package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ClientAddress;

import static org.junit.jupiter.api.Assertions.*;

class ClientAddressFactoryTest {
    private ClientAddress ca1,ca2;

    @BeforeEach
    void setUp() {
        ca1 = ClientAddressFactory.createClientAddress("1", AddressFactory.build("123",
                "McTominay Estate","123","Kruger Ave",7798,
                CityFactory.build("A12","Cape Town","Wynberg")));

        ca2 = ClientAddressFactory.createClientAddress("2", AddressFactory.build("123",
                "Bergkruine","123","Voortrekker rd",7798,
                CityFactory.build("CT12","Cape Town","Vanguard")));

    }

    @Test
    void objectIdentity(){

        assertAll(
                () -> assertNotSame(ca1.getClientId(),ca2.getClientId()),
                () -> assertSame("1", ca1.getClientId()),
                () -> assertSame("2",ca2.getClientId()),
                () -> assertNotNull(ca1.getClientId()),
                () -> assertNotNull(ca2.getClientId())
        );
        System.out.println("Test passed");

    }

    @Test
    void objectEquality(){

        assertAll(
                () -> assertNotEquals(ca1.getClientId(),ca2.getClientId()),
                () -> assertNotEquals(ca2,ca1),
                () -> assertNotEquals(ca1.getAddress(),ca2.getAddress())
        );

        System.out.println("Test passed");

    }
}