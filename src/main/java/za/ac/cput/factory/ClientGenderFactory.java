package za.ac.cput.factory;


/*
 Name : Ethan George
 Student Number : 218008430
 Project: Library Management
 Date : 2022/08/08
 */

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.ClientGender;

public class ClientGenderFactory {

    public static ClientGender createClientGender(String clientId , String genderId ){
        StringHelper.checkStringParam("clientId" , clientId);
        StringHelper.checkStringParam("genderId" , genderId);

        return new ClientGender.Builder().clientId(clientId).genderId(genderId).build();
    }
}
