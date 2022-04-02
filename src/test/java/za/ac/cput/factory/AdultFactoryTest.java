package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Adult;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 29 March 2022
 */
import static org.junit.jupiter.api.Assertions.*;

class AdultFactoryTest {

    @Test
    public void addAdultTest1(){

        //checks if student can be created and test passed
        Adult adult = AdultFactory.createAdult(3642,"Atticus","Johnson","Court Street",
                763404840,false,true,"Lawyer");

        assertNotNull(adult);
        //assertNull(adult1); //fails test
        System.out.println("Adult added...");

    }

    @Test
    public void addAdultTest2(){

        //Create and test a new customer but with some missing values
        Adult adult = (Adult) new Adult.Builder()
                .setPensioner(true)
                .setEmployed(false)
                .setCustomerID(1290)
                .setCustomerName("Cobus")
                .setCustomerSurname("Potgieter")
                .setAddress("Farm street")
                .build();

        assertNotNull(adult);
        //assertNull(adult);//test failed

        Adult adult1 = null;
        assertNull(adult1);

        System.out.println("Customer added...");

    }

    @Test
    public void showAdultDetails(){
        //Test to see if adult details shows
        Adult adult = AdultFactory.createAdult(3642,"Atticus","Johnson","Court Street",
                763404840,false,true,"Lawyer");

        System.out.println(adult);
        assertNotNull(adult);
    }

    @Test
    public void testObjectIdentity(){
        //Test for object identities
        Adult adult1 = AdultFactory.createAdult(3642,"Atticus","Johnson","Court Street",
                763404840,false,true,"Lawyer");
        Adult adult2 = AdultFactory.createAdult(1839,"Chris","Frawley","Sand ave",
                82009971,true,false,"retired");
        Adult adult3 = adult1;

        assertSame(adult1,adult3);
        assertSame(adult3,adult1);
        //assertSame(adult1,adult2); //failed test

        //assertNotSame(student1,student3);//failed test
        assertNotSame(adult1.getCustomerID(),adult2.getCustomerID());
        assertNotSame(adult1.getCellNo(),adult2.getCellNo());
        assertNotSame(adult1.isEmployed(),adult2.isEmployed());
        assertNotSame(adult1.isPensioner(),adult2.isPensioner());
        assertNotSame(adult1,adult2);
        assertNotSame(adult2,adult1);
        assertNotSame(adult2,adult3);
        assertNotSame(adult3,adult2);
        System.out.println("Test passed...");
    }

    @Test
    public void testObjectEquality(){
        //test for any object equalities
        Adult adult1 = AdultFactory.createAdult(3642,"Atticus","Johnson","Court Street",
                763404840,false,true,"Lawyer");
        Adult adult2 = AdultFactory.createAdult(1839,"Chris","Frawley","Sand ave",
                82009971,true,false,"retired");
        Adult adult3 = adult1;
        Adult adult4 = adult2;

       // assertEquals(adult1,adult2); //fail test
        assertEquals(adult1.getCustomerID(),adult3.getCustomerID());
        assertEquals(adult1.getCellNo(),adult3.getCellNo());
        assertEquals(adult2.getCustomerID(),adult4.getCustomerID());
        assertEquals(adult2.getCellNo(),adult4.getCellNo());
        assertEquals(adult1,adult3);
        assertEquals(adult3,adult1);
        assertEquals(adult4,adult2);
        assertEquals(adult2,adult4);

        assertEquals(true,adult1.isEmployed());
        //assertEquals(true,adult1.isPensioner()); //failed test
        assertEquals(false,adult1.isPensioner());
       // assertEquals(false,adult1.isPensioner()); //failed test

        assertEquals(true,adult2.isPensioner());
        //assertEquals(true,adult2.isEmployed()); //failed test
        assertEquals(false,adult2.isEmployed());
        //assertEquals(false,adult2.isEmployed()); //failed test

        System.out.println("All tests passed...");


    }

}