package za.ac.cput.service.impl;
/*
    Breyton Ernstzen (217203027)
    ADP3
    Capstone Project
 */
import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.repository.ClientAddressIRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientAddressServiceTest {
    @Mock
    private ClientAddressIRepository testClientAddressIRepository;

    ClientAddressService clientAddressService;

    private static ClientAddress clientAddress1,updateClientAddress1;

    @BeforeEach
    void setUp() {
        clientAddressService = new ClientAddressService(testClientAddressIRepository);

        clientAddress1 = new ClientAddress.Builder()
                .clientId("1")
                .address(AddressFactory.createAddress("K18","Weltevreden","52",
                        "van Riebeeck Avenue",7306, CityFactory.createCity("CPT","Cape Town",
                                "Durbanville")))
                .build();

        updateClientAddress1 = new ClientAddress.Builder().copy(clientAddress1)
                .address(AddressFactory.createAddress("A3",
                        "Glen Lilly",clientAddress1.getAddress().getStreetNumber(),
                        clientAddress1.getAddress().getStreetName(),clientAddress1.getAddress().getPostalCode(),
                        CityFactory.createCity(clientAddress1.getAddress().getCity().getId(),
                                clientAddress1.getAddress().getCity().getName(),"Constantia")))
                .build();

    }

    @Test
    void a_create() {
        testClientAddressIRepository.save(clientAddress1);

        assertAll(
                () -> assertNotNull(clientAddress1),
                () -> assertSame("1",clientAddress1.getClientId()),
                () -> assertSame("K18",clientAddress1.getAddress().getUnitNumber()),
                () -> assertSame("CPT",clientAddress1.getAddress().getCity().getId())
        );

        System.out.println("Client address saved");
        //System.out.println(clientAddress1.toString());
        System.out.println();
    }

    @Test
    void b_read() {
        testClientAddressIRepository.getReferenceById(clientAddress1.getClientId());

        assertAll(
                () -> assertNotNull(clientAddress1)
        );

        System.out.println(clientAddress1);
        System.out.println();

    }

    @Test
    void c_update() {
        testClientAddressIRepository.save(updateClientAddress1);

        assertAll(
                () -> assertNotSame(clientAddress1.getAddress().getUnitNumber(),updateClientAddress1.getAddress().getUnitNumber()),
                () -> assertSame("A3",updateClientAddress1.getAddress().getUnitNumber()),
                () -> assertSame("Glen Lilly",updateClientAddress1.getAddress().getComplexName()),
                () -> assertSame("Constantia",updateClientAddress1.getAddress().getCity().getSuburb())
        );

        System.out.println("Client address updated");
        System.out.println(updateClientAddress1.toString());
        System.out.println();
    }

    @Test
    void d_delete() {
        testClientAddressIRepository.deleteById(updateClientAddress1.getClientId());

        assertAll(
                () -> assertNotNull(updateClientAddress1)
        );

        System.out.println("Client address deleted");
        System.out.println();
    }

    @Test
    void e_getAll() {
        testClientAddressIRepository.findAll();

        assertAll(
                () -> assertNotNull(testClientAddressIRepository.findAll())
        );

        System.out.println(testClientAddressIRepository.findAll());
        System.out.println();
    }

    @Test
    void f_findClientAddressByClientId(){
        testClientAddressIRepository.findClientAddressByClientId(updateClientAddress1.getClientId());

        assertAll(
                () -> assertNotNull(updateClientAddress1)
        );

        System.out.println("Client id: " + updateClientAddress1.getClientId());
    }
}