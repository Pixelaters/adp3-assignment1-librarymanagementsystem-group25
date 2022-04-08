package za.ac.cput.repository;


import za.ac.cput.entity.Computer;


import java.util.HashSet;
import java.util.Set;

public class ComputerRepository implements ComputerRepositoryInterface {

    private static ComputerRepository computerRepository = null;
    private static Set<Computer> computerDB = null;
    private ComputerRepository() { computerDB = new HashSet<Computer>() ;}

    public static ComputerRepository getInstance(){

        if(computerRepository == null){
            computerRepository = new ComputerRepository();
        }
        return computerRepository;
    }

    @Override
    public Set<Computer> getAll() {

        return computerDB;
    }



    @Override
    public Computer create(Computer newComputer) {
        boolean success = computerDB.add(newComputer);

        if(!success)
        return null;
        return newComputer;
    }

    @Override
    public Computer read(String computerId) {

        for(Computer computer: computerDB){
            if (computer.getComputerId() == computerId) {
                return computer;
            }
        }
        return null;
    }

    @Override
    public Computer update(Computer updateComputer) {
        Computer oldComputer = read(updateComputer.getComputerId());

        if (oldComputer !=null){
            computerDB.remove(oldComputer);
            computerDB.add(updateComputer);
            return updateComputer;
        }

        return null;
    }

    @Override
    public boolean delete(String computerId) {

        Computer deleteComputer = read(computerId);
        if (deleteComputer == null)
            return false;
        computerDB.remove(deleteComputer);
        return true;

    }




}
