package za.ac.cput.repository;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 2 April 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Adult;
import za.ac.cput.factory.AdultFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class AdultRepositoryTest {
    private static AdultRepository adultRepository = AdultRepository.getInstance();
    private static Adult adult_a = AdultFactory.createAdult(1234,"Atticus","Smith",
            "Court street",2022040212,false,true,"Lawyer");
    private static Adult adult_b = AdultFactory.createAdult(1212,"Roy","Hodgson",
            "Eagle ave",124520202,true,false,"retired");

    //Test to add an adult customer to the LMS
    @Test
    void a_CreateAdultTest(){
        Adult newAdult1 = adultRepository.create(adult_a);
        Adult newAdult2 = adultRepository.create(adult_b);
        Adult newAdult3 = newAdult1;
        Adult newAdult4 = newAdult2;

        assertNotNull(newAdult1);
        assertNotNull(newAdult2);
        assertEquals(newAdult1,newAdult3);
        assertEquals(newAdult2,newAdult4);
        assertNotSame(adult_a,adult_b);
        assertSame(adult_a,newAdult1);
        assertSame(adult_b,newAdult2);
        assertSame(adult_a.isEmployed(),newAdult1.isEmployed());
        assertEquals(adult_a.isPensioner(),newAdult1.isPensioner());
        //assertSame(adult_a,adult_b); //fail test
        System.out.println("Adult customer added...");
        System.out.println();
    }

    //Read a specific adult customer from the database
    @Test
    void b_ReadAdultTest(){
       Adult readAdult = adultRepository.read(adult_a.getCustomerID());
       Adult anotherAdult = readAdult;

       assertNotNull(readAdult);
       assertSame(adult_a,readAdult);
       assertSame(adult_a.isEmployed(),readAdult.isEmployed());
       assertEquals(adult_a.isPensioner(),readAdult.isPensioner());
       assertNotSame(adult_b,readAdult);
       assertEquals(adult_a,readAdult);
       assertEquals(anotherAdult,readAdult);
       //assertSame(adult_a,adult_b);//fails test

        System.out.println("Reading adult customer...");
        System.out.println(adultRepository.read(1234));
        System.out.println();
    }

    //test to update a specific adult customer details
    @Test
    void c_UpdateAdultTest(){
        Adult updateAdult = (Adult) new Adult.Builder().copy(adult_b)
                .setPensioner(adult_b.isPensioner())
                .setEmployed(true)
                .setJobDescription("gas station attendant")
                .setCustomerID(adult_b.getCustomerID())
                .setCustomerName(adult_b.getCustomerName())
                .setCustomerSurname(adult_b.getCustomerSurname())
                .setAddress("San Andreas")
                .setCellNo(adult_b.getCellNo())
                .build();

        assertNotNull(updateAdult);
        assertNotSame(adult_b,updateAdult);
        assertNotSame(adult_b.getJobDescription(),updateAdult.getJobDescription());
        assertNotSame(adult_b.isEmployed(),updateAdult.isEmployed());
        assertNotSame(adult_b.getAddress(),updateAdult.getAddress());
        assertEquals(adult_b.getCustomerID(),updateAdult.getCustomerID());
        //assertSame(adult_b,updateAdult);//fails test
        System.out.println(adult_b.getCustomerName() + "'s details updated....");
        System.out.println(adultRepository.update(updateAdult));
        System.out.println();
    }

    //test to delete adult customer
    @Test
    void e_deleteAdult(){
        boolean success = AdultRepository.getInstance().delete(adult_b.getCustomerID());
        //assertTrue(success);
        assertNotNull(success);

        System.out.println("Delete Success? " + success);
        System.out.println();
    }

    @Test
    void d_getAllTest(){
        System.out.println("Getting all adult customers...");
        System.out.println(adultRepository.getAll() + "\n");
        System.out.println();
    }


}