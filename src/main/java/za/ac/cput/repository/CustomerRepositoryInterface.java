package za.ac.cput.repository;

import za.ac.cput.entity.Customer;

import java.util.Set;

/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 1 April 2022
 */
public interface CustomerRepositoryInterface extends IRepository<Customer, Integer>{

    public Set<Customer> getAll();

}
