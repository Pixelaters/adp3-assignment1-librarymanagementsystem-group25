package za.ac.cput.repository;

import za.ac.cput.entity.Librarian;

import java.util.Set;

/*
    LibrarianRepositoryInterface.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 26 April 2022
 */

public interface LibrarianRepositoryInterface extends IRepository<Librarian, Long> {
    public Set<Librarian> getAll();
}
