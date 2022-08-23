package za.ac.cput.service.impl;
/*
    Breyton Ernstzen (217203027)
    ADP3
    Capstone Project
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Client;
import za.ac.cput.repository.ClientIRepository;

import java.util.List;

@Service
public class ClientService implements ClientIService{

    private final ClientIRepository clientIRepository;

    @Autowired
    public ClientService(ClientIRepository clientIRepository){
        this.clientIRepository = clientIRepository;
    }

    @Override
    public Client create(Client client) {
        return this.clientIRepository.save(client);
    }

    @Override
    public Client read(String clientId) {
        return this.clientIRepository.getReferenceById(clientId);
    }

    @Override
    public Client update(Client updateClient) {
        return this.clientIRepository.save(updateClient);
    }

    @Override
    public void delete(String clientId) {
        this.clientIRepository.deleteById(clientId);
    }

    @Override
    public List<Client> getAll() {
        return this.clientIRepository.findAll();
    }

    @Override
    public Client findClientById(String id) {
        return this.clientIRepository.findById(id).orElse(null);
    }
}
