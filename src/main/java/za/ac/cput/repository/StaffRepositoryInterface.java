package za.ac.cput.repository;

import za.ac.cput.entity.Staff;

import java.util.Set;

/*
    StaffRepositoryInterface.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 26 April 2022
 */

public interface StaffRepositoryInterface extends IRepository<Staff, Long>{


    public Set<Staff> getAll();
}
