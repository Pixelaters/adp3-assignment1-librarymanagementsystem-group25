package za.ac.cput.factory;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 29 March 2022
 */
import za.ac.cput.entity.Adult;

public class AdultFactory {

    public static Adult createAdult(int id,String name,String surname,String address,long cellNo,
                                    boolean pensioner,boolean employed,String jobDescription){

        Adult newAdult = (Adult) new Adult.Builder()
                .setPensioner(pensioner)
                .setEmployed(employed)
                .setJobDescription(jobDescription)
                .setCustomerID(id)
                .setCustomerName(name)
                .setCustomerSurname(surname)
                .setAddress(address)
                .setCellNo(cellNo)
                .build();

            return newAdult;
    }
}
