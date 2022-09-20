package za.ac.cput.factory;


/*
 Name : Ethan George
 Student Number : 218008430
 Project: Library Management
 Date : 2022/08/08
 */

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientGender;
import za.ac.cput.domain.Gender;

public class ClientGenderFactory {

    public static ClientGender createClientGender(Client client , Gender gender ){
//        StringHelper.checkStringParam("clientId" , client);
//        StringHelper.checkStringParam("genderId" , gender);
        if (client == null || gender == null) {
            throw new IllegalArgumentException("there should be no null values");
        }
        return new ClientGender.Builder().Client(client).Gender(gender).build();
    }
}
