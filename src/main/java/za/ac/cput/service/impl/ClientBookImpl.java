package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ClientBook;
import za.ac.cput.repository.ClientBookIRepository;
import za.ac.cput.repository.ClientIRepository;
import za.ac.cput.service.ClientBookIService;
import za.ac.cput.service.IService;

import java.util.List;

@Service
public class ClientBookImpl implements ClientBookIService {

    private final ClientBookIRepository clientBookIRepository;

    @Autowired
    public ClientBookImpl(ClientBookIRepository clientBookIRepository){
        this.clientBookIRepository = clientBookIRepository;
    }

    @Override
    public ClientBook create(ClientBook clientBook) {
        return this.clientBookIRepository.save(clientBook);
    }

    @Override
    public ClientBook read(String id) {
        return this.clientBookIRepository.findById(id).orElse(null);
    }

    @Override
    public ClientBook update(ClientBook updateClientBook) {
        return this.clientBookIRepository.save(updateClientBook);
    }

    @Override
    public void delete(String id) {
        this.clientBookIRepository.deleteById(id);

    }

    @Override
    public List<ClientBook> getAll() {
        return this.clientBookIRepository.findAll();
    }
}
