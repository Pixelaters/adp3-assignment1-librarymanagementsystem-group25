package za.ac.cput.service;

import za.ac.cput.domain.ClientBook;

import java.util.List;

public interface ClientBookIService extends IService<ClientBook,String>{
    public List<ClientBook> getAll();
    public List<ClientBook> findClientBooksByClientId(String clientId);
}
