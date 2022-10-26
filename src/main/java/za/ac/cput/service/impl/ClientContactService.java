package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ClientContact;
import za.ac.cput.repository.ClientContactIRepository;

import java.util.List;
@Service
public class ClientContactService implements ClientContactIService{
    private final ClientContactIRepository clientContactIRepository;


     @Autowired
    public ClientContactService(ClientContactIRepository clientContactIRepository) {
        this.clientContactIRepository = clientContactIRepository;
    }


    @Override
    public ClientContact create(ClientContact clientContact) {
        return this.clientContactIRepository.save(clientContact);
    }

    @Override
    public ClientContact read(String clientId) {
        return this.clientContactIRepository.findById(clientId).orElse(null);
    }

    @Override
    public ClientContact update(ClientContact updateClientContact) {
        return this.clientContactIRepository.save(updateClientContact);
    }

    @Override
    public void delete(String id) {
         this.clientContactIRepository.deleteById(id);


        }
    @Override
    public List<ClientContact> getAll() {
        return this.clientContactIRepository.findAll().stream().toList();
    }

}
