package za.ac.cput.factory;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * FactoryTest: AddressFactoryTest
 * Date: 2022/08/06
 * */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void successfulTest(){
        Address address = AddressFactory.createAddress("89","Bon jovi","39","Runaway",8900,
                CityFactory.createCity("3","Kansas","Ohio"));
        assertNotNull(address);
        System.out.println(address);
    }

    @Test
    void FailureTest(){
        Address address2 = AddressFactory.createAddress("","Bon jovi","39","Runaway",8900,
                CityFactory.createCity("3","","Ohio"));
        assertNotNull(address2);
        System.out.println(address2);

    }

}