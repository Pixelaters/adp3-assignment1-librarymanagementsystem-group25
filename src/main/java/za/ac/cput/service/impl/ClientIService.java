package za.ac.cput.service.impl;
/*
    Breyton Ernstzen (217203027)
    ADP3
    Capstone Project
 */

import za.ac.cput.domain.Client;
import za.ac.cput.service.IService;

import java.util.List;

public interface ClientIService extends IService<Client, String> {

    List<Client> getAll();

    Client findClientByClientId(String id);//this may cause errors for the findClientById method in the ClientService class
}
