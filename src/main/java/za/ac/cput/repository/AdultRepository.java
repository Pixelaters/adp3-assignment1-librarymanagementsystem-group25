package za.ac.cput.repository;

import za.ac.cput.entity.Adult;

import java.util.HashSet;
import java.util.Set;

public class AdultRepository implements AdultRepositoryInterface{
    private static AdultRepository adultRepository = null;
    private static Set<Adult> adultDB = null;

    private AdultRepository(){
        adultDB = new HashSet<Adult>();
    }

    //First checks to see if a repository is already created or not. If it is not created yet, then it creates one
    //Uses the singleton pattern
    public static AdultRepository getInstance(){

        if(adultRepository == null){
            adultRepository = new AdultRepository();
        }
        return adultRepository;
    }

    //adds a new adult to the database
    @Override
    public Adult create(Adult newAdult) {
        boolean success = adultDB.add(newAdult);

        if(!success)
            return null;
            return newAdult;
    }

    //reads from the database
    @Override
    public Adult read(Integer adultID) {

        for(Adult adult: adultDB){
            if(adult.getCustomerID() == adultID)
                return adult;
            }
        return null;
    }

    @Override
    public Adult update(Adult adult) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Set<Adult> getAll() {
        return null;
    }
}
