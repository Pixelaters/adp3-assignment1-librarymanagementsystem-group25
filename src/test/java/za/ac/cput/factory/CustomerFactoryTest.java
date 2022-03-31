package za.ac.cput.factory;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 29 March 2022
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Customer;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    public void addCustomerTest(){
        //test to add a new customer
        Customer testNewCustomer = CustomerFactory.addCustomer(121,"a","b","c",123456789);
        System.out.println("User has been added...");
        assertNotNull(testNewCustomer);
        //assertNull(testNewCustomer); //failed test
    }

    @Test
    public void showCustomer(){
        //Test for "not null" and show the added customer
        Customer testViewCustomer = CustomerFactory.addCustomer(121,"a","b","c",123456789);
        System.out.println(testViewCustomer.toString());
        assertNotNull(testViewCustomer);
    }

    @Test
    public void testObjectIdentity(){
        //Testing object identity
        Customer testViewCustomer1 = CustomerFactory.addCustomer(121,"a","b","c",123456789);
        Customer testViewCustomer2 = CustomerFactory.addCustomer(120,"d","e","f",1098765432);
        Customer testViewCustomer3 = testViewCustomer1;

            assertSame(testViewCustomer1,testViewCustomer3);
            assertNotSame(testViewCustomer1, testViewCustomer2);
            assertNotSame(testViewCustomer2, testViewCustomer1);
            assertNotSame(testViewCustomer2, testViewCustomer3);
            System.out.println("Tests passed!...");
        }

        @Test
    public void testObjectEquality(){
        //test object equality
        Customer testViewCustomer1 = CustomerFactory.addCustomer(121,"a","b","c",123456789);
        Customer testViewCustomer2 = CustomerFactory.addCustomer(120,"d","e","f",1098765432);
        Customer testViewCustomer3 = testViewCustomer1;
        Customer testViewCustomer4 = testViewCustomer2;

        assertEquals(testViewCustomer1,testViewCustomer3);
        assertEquals(testViewCustomer2,testViewCustomer4);
            System.out.println("Test passed!...");

    }

  @Test
  //@Disabled
    public void fail(String message){
    }

}