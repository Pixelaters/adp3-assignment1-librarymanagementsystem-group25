package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.LibrarianAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.repository.LibrarianAddressIRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.class)
class LibrarianAddressServiceTest {

    @Mock
    private LibrarianAddressIRepository testLibrarianAddressIrepsoitory;


    LibrarianAddressService librarianAddressService;

    private static LibrarianAddress librarianAddress1,updateLibrarianAddress1;

    @BeforeEach
    void setUp(){
        librarianAddressService = new LibrarianAddressService(testLibrarianAddressIrepsoitory);

        librarianAddress1 = new LibrarianAddress.LibrarianAddressBuilder().librarianId("23").
                address(AddressFactory.createAddress("J25","Johnny","89","Test",8995,
                        CityFactory.createCity("2","CPT","Khayelitsha"))).build();

        updateLibrarianAddress1 = new LibrarianAddress.LibrarianAddressBuilder().copy(librarianAddress1).address(AddressFactory.createAddress("","",librarianAddress1.getAddress().getStreetNumber(),librarianAddress1.getAddress().getStreetName(),librarianAddress1.getAddress().getPostalCode(),librarianAddress1.getAddress().getCity() ))
                .build();
    }

    @Test
    void a_create() {
        librarianAddressService.create(librarianAddress1);

        assertNotNull(librarianAddress1);
        System.out.println("Librarian address created successfully");
        System.out.println(librarianAddress1);

    }

    @Test
    void b_read() {
        librarianAddressService.read(librarianAddress1.getLibrarianId());
        assertNotNull(librarianAddress1);
        System.out.println(librarianAddress1);
    }

    @Test
    void c_update() {
        librarianAddressService.update(updateLibrarianAddress1);

        assertNotNull(updateLibrarianAddress1);
        assertNotSame(librarianAddress1.getAddress().getComplexName(),updateLibrarianAddress1.getAddress().getComplexName());
        assertNotSame(librarianAddress1.getAddress().getUnitNumber(),updateLibrarianAddress1.getAddress().getUnitNumber());

        System.out.println("LibrarianAddress updated successfully");
        System.out.println(updateLibrarianAddress1);
    }

    @Test
    void f_delete() {
        librarianAddressService.delete(updateLibrarianAddress1.getLibrarianId());

        assertNotNull(updateLibrarianAddress1);
        System.out.println("Librarian Address Deleted Successfully");


    }

    @Test
    void e_getAll() {
        librarianAddressService.getAll();

        assertNotNull(librarianAddressService.getAll());

        System.out.println(librarianAddressService.getAll());
    }

    @Test
    void d_findLibrarianAddressByLibrarianId() {
        System.out.println(librarianAddressService.findLibrarianAddressByLibrarianId("23"));

        assertNotNull(updateLibrarianAddress1);
    }
}