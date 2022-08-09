package za.ac.cput.factory;

/*
 Name : Ethan George
 Student Number : 218008430
 Project: Library Management
 Date : 2022/08/08
 */
import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Gender;

public class GenderFactory {

    public static Gender createGender(String genderId , String name ,String other){
        StringHelper.checkStringParam("genderId" , genderId);
        StringHelper.checkStringParam("name" , name);
        StringHelper.checkStringParam("other" , other);

        return new Gender.Builder().genderId(genderId).name(name).other(other).build();
    }
}
