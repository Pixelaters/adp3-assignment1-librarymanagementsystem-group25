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
    public Manager read(String managerCode) {
       for (Manager manager: man){
           if (manager.getManagerCode().equals(managerCode)){
            return manager;
           }
       }
       return null;
    }

    @Override
    public Manager update(Manager manager) {
        Manager oldManager = read((manager.getManagerCode()));
        if (oldManager != null){
            man.remove(oldManager);
            man.add(manager);
            return manager;
        }
        return null;
    }

    @Override
    public boolean delete(String managerCode) {
        Manager deleteManager= read(managerCode);
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
