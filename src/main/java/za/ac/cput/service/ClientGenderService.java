package za.ac.cput.service;

import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientGender;
import za.ac.cput.domain.Gender;

import java.util.List;

public interface ClientGenderService extends IService<ClientGender , String> {


    List<ClientGender> getAll();

    List<ClientGender> findClientGenderByClient(Client client);
}
