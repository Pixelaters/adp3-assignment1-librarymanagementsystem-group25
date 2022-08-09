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

@Service
public class ClientService implements ClientIService{

    private final ClientIRepository clientIRepository;

    @Autowired
    public ClientService(ClientIRepository clientIRepository){
        this.clientIRepository = clientIRepository;
    }

    @Override
    public Client create(Client client) {
        return null;
    }

    @Override
    public Client read(String s) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
