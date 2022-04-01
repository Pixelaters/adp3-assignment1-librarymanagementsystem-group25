package za.ac.cput.repository;

import za.ac.cput.entity.Customer;

import java.util.HashSet;
import java.util.Set;

/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: April 2022
 */
public class CustomerRepository implements CustomerRepositoryInterface{
    private static CustomerRepository customerRepository = null;
    private Set<Customer> customerDB = null;

    private CustomerRepository(){
        customerDB = new HashSet<Customer>();

    }

    //First checks to see if a repository is already created or not. If it is not created yet, then it creates one
    //Uses the singleton pattern
    public static CustomerRepository getInstance(){

        if(customerRepository == null){
            customerRepository = new CustomerRepository();
        }
        return customerRepository;
    }

    //adds a new customer to the database
    @Override
    public Customer create(Customer createCustomer) {
        boolean success = customerDB.add(createCustomer);

        if(!success) //if not a success then still add new customer
            return null;
            return createCustomer;

    }

    //read from the database
    @Override
    public Customer read(Integer customerID) {

        //Loops through the set and search for the customer ID, then see if it matches the ID in the database that is looking for
        for(Customer customer: customerDB){
            if(customer.getCustomerID() == customerID)
            return customer;
        }
        return null;
    }

    //Updates customer data
    @Override
    public Customer update(Customer updateCustomer) {
        Customer oldCustomer = read(updateCustomer.getCustomerID()); //first read from the database and see if the customer id is there

        if(oldCustomer != null){ //if the customer data is not empty
            customerDB.remove(oldCustomer); //removes old customer data
            customerDB.add(updateCustomer); //replace it with the updated data
            return updateCustomer; //updates customer data
        }
            return null;
    }

    @Override
    public boolean delete(Integer customerID) {
        Customer deleteCustomer = read(customerID);//read through the database

        if(deleteCustomer == null)
            return false;
            customerDB.remove(deleteCustomer); //removes customer
            return true;
    }

    @Override
    public Set<Customer> getAll() {
        return customerDB;
    }
}
