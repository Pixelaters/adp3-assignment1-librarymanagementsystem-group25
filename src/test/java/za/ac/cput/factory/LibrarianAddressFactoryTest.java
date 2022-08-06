package za.ac.cput.factory;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * FactoryTest: LibrarianAddressFactoryTest
 * Date: 2022/08/06
 * */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.LibrarianAddress;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianAddressFactoryTest {

    @Test
    void successfulTest(){
        LibrarianAddress librarianAddress = LibrarianAddressFactory.createLibrarianAddress("5",
                AddressFactory.createAddress("","","23","Malika",8950,
                        CityFactory.createCity("79","Roodepoort","Qheberha")));
        assertNotNull(librarianAddress);
        System.out.println(librarianAddress);
    }

    @Test
    void failureTest1(){
        LibrarianAddress librarianAddress = LibrarianAddressFactory.createLibrarianAddress("",
                AddressFactory.createAddress("","","23","Malika",8950,
                        CityFactory.createCity("79","Roodepoort","Qheberha")));
        assertNotNull(librarianAddress);
        System.out.println(librarianAddress);
    }
    @Test
    void failureTest2(){
        LibrarianAddress librarianAddress = LibrarianAddressFactory.createLibrarianAddress("8000",
                AddressFactory.createAddress("","","23","Malika",89509,
                        CityFactory.createCity("79","Roodepoort","Qheberha")));
        assertNotNull(librarianAddress);
        System.out.println(librarianAddress);

    }
    @Test
    void failureTest3(){
        LibrarianAddress librarianAddress = LibrarianAddressFactory.createLibrarianAddress("",
                AddressFactory.createAddress("","","23","Malika",8950,
                        CityFactory.createCity("","Roodepoort","Qheberha")));
        assertNotNull(librarianAddress);
        System.out.println(librarianAddress);
    }

}