package za.ac.cput.repository;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 1 April 2022
 */
import za.ac.cput.entity.Customer;

import java.util.Set;

public interface CustomerRepositoryInterface extends IRepository<Customer, Integer>{

    public Set<Customer> getAll();

}
