package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    public void addCustomerTest(){
        Customer testNewCustomer = CustomerFactory.addCustomer(121,"a","b","c",123456789);
        assertNotNull(testNewCustomer);
    }

}