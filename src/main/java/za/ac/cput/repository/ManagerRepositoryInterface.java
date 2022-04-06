package za.ac.cput.repository;

import za.ac.cput.entity.Manager;

import java.util.Set;

/*
    ManagerRepositoryInterface.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 26 April 2022
 */

public interface ManagerRepositoryInterface extends  IRepository<Manager, String>{
    public Set<Manager> getAll();
}
