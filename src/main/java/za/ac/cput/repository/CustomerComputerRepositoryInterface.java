package za.ac.cput.repository;


import za.ac.cput.entity.CustomerComputer;

import java.util.Set;

public interface CustomerComputerRepositoryInterface extends IRepository<CustomerComputer , String> {

    public  Set<CustomerComputer> getAll();

    CustomerComputer create(CustomerComputer computer);
}
