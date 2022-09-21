package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.LibrarianContact;
import za.ac.cput.repository.LibrarianContactIRepository;

import java.util.List;
@Service
public class LibrarianContactService implements LibrarianContactIService{
  private final LibrarianContactIRepository librarianContactIRepository;

     @Autowired
    public LibrarianContactService(LibrarianContactIRepository librarianContactIRepository) {
        this.librarianContactIRepository = librarianContactIRepository;
    }


    @Override
    public LibrarianContact create(LibrarianContact librarianContact) {
        return this.librarianContactIRepository.save(librarianContact);
    }

    @Override
    public LibrarianContact read(String id) {
        return this.librarianContactIRepository.getReferenceById(id);
    }

    @Override
    public LibrarianContact update(LibrarianContact UpdateLibrarianContact) {
        return this.librarianContactIRepository.save(UpdateLibrarianContact);
    }

    @Override
    public void delete(String id) {
        this.librarianContactIRepository.deleteById(id);


    }

    @Override
    public List<LibrarianContact> getAll() {
        return this.librarianContactIRepository.findAll();
    }

    @Override
    public List<LibrarianContact> findLibrarianByLibrarianId(String librarianId) {
        return null;
    }
}
