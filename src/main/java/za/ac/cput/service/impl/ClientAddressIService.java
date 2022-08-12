/*
    Breyton Ernstzen (217203027)
    ADP3
    Capstone Project
 */
package za.ac.cput.service.impl;

import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface ClientAddressIService extends IService<ClientAddress, String> {

    public List<ClientAddress> getAll();
    //public Client findClientAddressByClientId(String id);
}
