package za.ac.cput.repository;

import za.ac.cput.entity.Staff;

import java.util.Set;

public interface StaffRepositoryInterface extends IRepository<Staff, Long>{


    public Set<Staff> getAll();
}
