package za.ac.cput.factory;

import za.ac.cput.entity.Computer;


/*
   Ethan George (218008430)
   ADP3 - Assignment 1: Group 25
   Date:  30 March 2022
 */


public class ComputerFactory {

    public static Computer createComputer(String id , String brandName , String status )
    {
        Computer newComputer = (Computer) new Computer.Builder()
                .setComputerId(id)
                .setBrandName(brandName)
                .setStatus(status)
                .build();
        return newComputer;
    }


}
