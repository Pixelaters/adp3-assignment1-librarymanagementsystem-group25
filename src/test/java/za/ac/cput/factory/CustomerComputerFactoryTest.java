package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.CustomerComputer;

import static org.junit.jupiter.api.Assertions.*;


public class CustomerComputerFactoryTest {

    @Test
    public void addCustomerComputerTest(){
        CustomerComputer customerComputer = CustomerComputerFactory.createCustomerComputer( "1" ,  "451" , "Research" , "5" , "LG" , "Moderate" );

        assertNotNull(customerComputer);
        System.out.println("Customer Computer activity added");


    }

    @Test
    public void showCustomerComputer(){
        CustomerComputer testViewCustomerComputer = CustomerComputerFactory.createCustomerComputer( "1" ,  "451" , "Research" , "5" , "LG" , "Moderate" );
        System.out.println(testViewCustomerComputer.toString());
        assertNotNull(testViewCustomerComputer);
    }

    @Test
    public void testObjectIdentity(){

        CustomerComputer testViewCustomerComputer1 = CustomerComputerFactory.createCustomerComputer("1" ,  "451" , "Research" , "5" , "LG" , "Moderate" );
        CustomerComputer testViewCustomerComputer2 = CustomerComputerFactory.createCustomerComputer("2" ,  "452" , "Youtube" , "6" , "Samsung" , "Healthy");
        CustomerComputer testViewCustomerComputer3 =testViewCustomerComputer1;

        assertSame(testViewCustomerComputer1,testViewCustomerComputer2);
        assertNotSame(testViewCustomerComputer2, testViewCustomerComputer3);
        assertNotSame(testViewCustomerComputer3, testViewCustomerComputer1);
        assertNotSame(testViewCustomerComputer1, testViewCustomerComputer2);
        System.out.println("Customer Computer Updated");

    }

    @Test
    public void testObjectEquality(){

        CustomerComputer testViewCustomerComputer1 = CustomerComputerFactory.createCustomerComputer("1" ,  "451" , "Research" , "5" , "LG" , "Moderate" );
        CustomerComputer testViewCustomerComputer2 = CustomerComputerFactory.createCustomerComputer("2" ,  "452" , "Youtube" , "6" , "Samsung" , "Healthy");
        CustomerComputer testViewCustomerComputer3=  testViewCustomerComputer1;
        CustomerComputer testViewCustomerComputer4 =  testViewCustomerComputer2;

        assertEquals(testViewCustomerComputer1,testViewCustomerComputer4);
        assertEquals(testViewCustomerComputer2,testViewCustomerComputer3);
        System.out.println("Customer Computer Updated");

    }

    @Test

    public void fail(String message){
        System.out.println("Customer Computer not Found");

    }
}
