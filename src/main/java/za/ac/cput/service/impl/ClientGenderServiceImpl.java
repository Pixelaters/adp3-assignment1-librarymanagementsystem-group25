package za.ac.cput.service.impl;


import org.springframework.stereotype.Service;
import za.ac.cput.domain.ClientGender;
import za.ac.cput.repository.ClientGenderRepository;
import za.ac.cput.service.ClientGenderService;

import java.util.List;

@Service
public class ClientGenderServiceImpl implements ClientGenderService {

    private final ClientGenderRepository clientGenderRepository;

    public ClientGenderServiceImpl(ClientGenderRepository clientGenderRepository) {
        this.clientGenderRepository = clientGenderRepository;
    }
    

    @Override
    public ClientGender update(ClientGender clientGender){
        return this.clientGenderRepository.save(clientGender);
    }

    @Override
    public ClientGender create(ClientGender clientGender) {
        return this.clientGenderRepository.save(clientGender);
    }

    @Override
    public ClientGenderService create(ClientGenderService clientGenderService) {
        return null;
    }

    @Override
    public ClientGenderService read(String id){
        return (ClientGenderService) this.clientGenderRepository.getReferenceById(id);
    }

    @Override
    public ClientGenderService update(ClientGenderService clientGenderService) {
        return null;
    }

    @Override
    public void delete(String id){
        this.clientGenderRepository.deleteById(id);
    }

    @Override
    public List<ClientGender> getAll(){
        return this.clientGenderRepository.findAll();
    }

    //    public ClientGender findClientGenderById(String clientId){
//        return this.clientGenderRepository.findClientGenderById(clientId);
//    }
}
