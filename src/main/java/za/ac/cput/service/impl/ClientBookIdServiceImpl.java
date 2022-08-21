package za.ac.cput.service.impl;


import org.springframework.stereotype.Service;
import za.ac.cput.domain.ClientBookId;
import za.ac.cput.repository.ClientBookIdRepository;
import za.ac.cput.service.ClientBookIdService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClientBookIdServiceImpl implements ClientBookIdService {

    private final ClientBookIdRepository clientBookIdRepository;

    public ClientBookIdServiceImpl(ClientBookIdRepository clientBookIdRepository) {
        this.clientBookIdRepository = clientBookIdRepository;
    }

    @Override
    public ClientBookId create(ClientBookId clientBookId) {
        return this.clientBookIdRepository.save(clientBookId);
    }

    @Override
    public ClientBookId read(String id) {
        return this.clientBookIdRepository.findById(id).orElse(null);
    }

    @Override
    public ClientBookId update(ClientBookId clientBookId) {
        return this.clientBookIdRepository.save(clientBookId);
    }

    @Override
    public void delete(String id) {

        if (this.clientBookIdRepository.existsById(id)){
            this.clientBookIdRepository.deleteById(id);
            System.out.println("Deletion Success");
        }else {
            System.out.println("Does not exist");
        }
    }


    @Override
    public Set<ClientBookId> getAll() {
        return this.clientBookIdRepository.findAll().stream().collect(Collectors.toSet());
    }
}
