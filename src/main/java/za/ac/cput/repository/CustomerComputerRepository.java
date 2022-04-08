package za.ac.cput.repository;




import za.ac.cput.entity.Computer;
import za.ac.cput.entity.CustomerComputer;

import java.util.HashSet;
import java.util.Set;


public class CustomerComputerRepository implements CustomerComputerRepositoryInterface{

    private static CustomerComputerRepository customerComputerRepository = null;
    private static Set<CustomerComputer> customerComputerDB = null;
    private CustomerComputerRepository() { customerComputerDB = new HashSet<CustomerComputer>() ;}

    public static CustomerComputerRepository getInstance(){

        if(customerComputerRepository == null){
            customerComputerRepository = new CustomerComputerRepository();
        }
        return customerComputerRepository;
    }


    @Override
    public Set<CustomerComputer> getAll() {
        return customerComputerDB;
    }

    @Override
    public CustomerComputer create(CustomerComputer newCustomerComputer) {
        boolean success = customerComputerDB.add(newCustomerComputer);

        if(!success)
            return null;
        return newCustomerComputer;

    }

    @Override
    public CustomerComputer read(String computerId) {

        for(CustomerComputer customercomputer: customerComputerDB){
            if (customercomputer.getComputerId() == computerId) {
                return customercomputer;
            }
        }
        return null;
    }

    @Override
    public CustomerComputer update(CustomerComputer updateCustomerComputer) {
        CustomerComputer oldCustomerComputer = read(updateCustomerComputer.getComputerId());

        if (oldCustomerComputer !=null){
            customerComputerDB.remove(oldCustomerComputer);
            customerComputerDB.add(updateCustomerComputer);
            return updateCustomerComputer;
        }
        return null;
    }

    @Override
    public boolean delete(String computerId) {
        CustomerComputer deleteCustomerComputer = read(computerId);
        if (deleteCustomerComputer == null)
            return false;
        customerComputerDB.remove(deleteCustomerComputer);
        return true;

    }
}
