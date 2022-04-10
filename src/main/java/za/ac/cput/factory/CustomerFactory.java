package za.ac.cput.factory;

import za.ac.cput.entity.Customer;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 29 March 2022
 */
import java.util.UUID;

public class CustomerFactory {

    public static String generateCustomerID(){
        return UUID.randomUUID().toString();
    }

    public static Customer addCustomer(int customerID,String name,String surname,String address,long cellNo){
        Customer newCustomer = new Customer.Builder()
                .setCustomerID(customerID)
                .setCustomerName(name)
                .setCustomerSurname(surname)
                .setAddress(address)
                .setCellNo(cellNo)
                .build();

        return newCustomer;
    }
}
