package za.ac.cput.service;

import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBook;

import java.util.List;

public interface ClientBookIService extends IService<ClientBook, String>{
    List<ClientBook> getAll();
    List<ClientBook> findClientBookByClients_ClientId(String clientId);
    ClientBook findClientBookByBooks_BookId(String bookId);
}
