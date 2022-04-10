package za.ac.cput.repository;

import za.ac.cput.entity.Manager;

import java.util.HashSet;
import java.util.Set;

/*
    ManagerRepository.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 6 April 2022
 */

public class ManagerRepository implements  ManagerRepositoryInterface {

    private static IRepository IR= null;

    private Set<Manager> man;

    private ManagerRepository() {
        man= new HashSet<Manager>();
    }

    public static ManagerRepository getInstance(){
        if (IR== null){
            IR= new ManagerRepository();
        }
        return(ManagerRepository) IR;
    }

    @Override
    public Manager create(Manager manager) {
        boolean success = man.add((manager));
        if (!success){
            return null;
        }
        return manager;
    }

    @Override
    public Manager read(Long staffID) {
        for (Manager manager : man) {
            if (manager.getStaffMember_ID() == staffID) {
                return manager;
            }
        }
        return null;
    }



    @Override
    public Manager update(Manager manager) {
        Manager oldManager = read((manager.getStaffMember_ID()));
        if (oldManager != null){
            man.remove(oldManager);
            man.add(manager);
            return manager;
        }
        return null;
    }

    @Override
    public boolean delete(Long StaffId) {
        Manager deleteManager= read(StaffId);
        if (deleteManager == null){
            return false;
        }
        man.remove(deleteManager);
        return true;
    }


    @Override
    public Set<Manager> getAll() {
        return man;
    }
}
