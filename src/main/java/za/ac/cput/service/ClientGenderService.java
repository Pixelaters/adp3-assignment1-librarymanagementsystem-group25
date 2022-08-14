package za.ac.cput.service;

import za.ac.cput.domain.ClientGender;

import java.util.List;

public interface ClientGenderService {
    ClientGender create(ClientGender clientGender);

    ClientGender update(ClientGender clientGender);

    ClientGender read(String id);

    void delete(String id);

    List<ClientGender> getAll();
}
