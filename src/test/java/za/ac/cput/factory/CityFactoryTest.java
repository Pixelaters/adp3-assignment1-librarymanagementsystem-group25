package za.ac.cput.factory;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * FactoryTest: CityFactoryTest
 * Date: 2022/08/06
 * */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    @Test
    void successfulTest(){
        City city = CityFactory.createCity("9","Cape town","Khayelitsha");
        assertNotNull(city);
        System.out.println(city);
    }

    @Test
    void failuretest1(){
        City city1 = CityFactory.createCity("","Cape town","Maccassar");
        assertNotNull(city1);
        System.out.println(city1);


    }
    @Test
    void failuretest2(){
        City city2 = CityFactory.createCity("9","","Khayelitsha");
        assertNotNull(city2);
        System.out.println(city2);
    }

}