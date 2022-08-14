package za.ac.cput.service;

import za.ac.cput.domain.ClientGender;
import za.ac.cput.domain.Gender;

import java.util.List;

public interface ClientGenderService extends IService<ClientGenderService , String> {

    ClientGender create(ClientGender clientGender);

    ClientGender update(ClientGender clientGender);

    public List<ClientGender> getAll();
}
