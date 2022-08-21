package za.ac.cput.service.impl;
/*
    Breyton Ernstzen (217203027)
    ADP3
    Capstone Project
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.repository.ClientAddressIRepository;

import java.util.List;

@Service
public class ClientAddressService implements ClientAddressIService{

    private final ClientAddressIRepository clientAddressIRepository;

    @Autowired
    public ClientAddressService(ClientAddressIRepository clientAddressIRepository){
        this.clientAddressIRepository = clientAddressIRepository;
    }

    @Override
    public ClientAddress create(ClientAddress clientAddress) {
        return this.clientAddressIRepository.save(clientAddress);
    }

    @Override
    public ClientAddress read(String id) {
        return this.clientAddressIRepository.findById(id).orElse(null);
    }

    @Override
    public ClientAddress update(ClientAddress updateClientAddress) {
        return this.clientAddressIRepository.save(updateClientAddress);
    }

    @Override
    public void delete(String id) {
        this.clientAddressIRepository.deleteById(id);
    }

    @Override
    public List<ClientAddress> getAll() {
        return this.clientAddressIRepository.findAll();

    }

    public ClientAddress findClientAddressByClientId(String clientId){
        return this.clientAddressIRepository.findClientAddressByClientId(clientId);
    }

}
