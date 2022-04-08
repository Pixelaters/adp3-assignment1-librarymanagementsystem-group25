package za.ac.cput.repository;

import za.ac.cput.entity.Computer;


import java.util.Set;

public interface ComputerRepositoryInterface extends IRepository<Computer , String> {

    public Set<Computer> getAll();



    Computer create(Computer computer);
}
