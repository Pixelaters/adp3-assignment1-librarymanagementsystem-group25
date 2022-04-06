package za.ac.cput.repository;

import za.ac.cput.entity.Manager;

import java.util.Set;

public interface ManagerRepositoryInterface extends  IRepository<Manager, String>{
    public Set<Manager> getAll();
}
