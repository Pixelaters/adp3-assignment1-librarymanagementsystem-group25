package za.ac.cput.service.impl;


import org.springframework.stereotype.Service;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientGender;
import za.ac.cput.repository.ClientGenderRepository;
import za.ac.cput.service.ClientGenderService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ClientGenderServiceImpl implements ClientGenderService {

    private final ClientGenderRepository clientGenderRepository;

    public ClientGenderServiceImpl(ClientGenderRepository clientGenderRepository) {
        this.clientGenderRepository = clientGenderRepository;
    }


 @Override
 public ClientGender create(ClientGender clientGender){
        return this.clientGenderRepository.save(clientGender);
 }

    @Override
    public ClientGender read(String id){
        return  this.clientGenderRepository.findById(id).orElse(null);
    }

   @Override
   public ClientGender update(ClientGender clientGender){
        return this.clientGenderRepository.save(clientGender);
   }


    @Override
    public void delete(String id){
        this.clientGenderRepository.deleteById(id);
    }

    @Override
    public List<ClientGender> getAll(){
        return this.clientGenderRepository.findAll();
    }

    public List<ClientGender> findClientGenderByClient(Client client){
       return this.clientGenderRepository.findClientGenderByClient(client);

    }
}
