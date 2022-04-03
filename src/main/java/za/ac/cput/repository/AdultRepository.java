package za.ac.cput.repository;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 1 April 2022
 */
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

    //update adults data on the database
    @Override
    public Adult update(Adult updateAdult) {
        Adult oldAdult = read(updateAdult.getCustomerID());

        if(oldAdult != null){ //if adult data is not empty
            adultDB.remove(oldAdult);//removes the old data
            adultDB.add(updateAdult);//replace the removed data
            return updateAdult;//updates

        }
        return null;
    }

    //removes an adult from the database
    @Override
    public boolean delete(Integer adultID) {
        Adult deleteCustomer = read(adultID);

        if(deleteCustomer == null)
            return false;
            adultDB.remove(deleteCustomer);
            return true;

    }

    //get all adults from the database
    @Override
    public Set<Adult> getAll() {
        return adultDB;
    }
}
