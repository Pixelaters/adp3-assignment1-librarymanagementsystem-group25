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

    @Override
    public Customer create(Customer createCustomer) {
        boolean success = customerDB.add(createCustomer);

        if(!success) //if not a success then still add new customer
            return null;
            return createCustomer;

    }

    @Override
    public Customer read(Integer integer) {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Set<Customer> getAll() {
        return null;
    }
}
