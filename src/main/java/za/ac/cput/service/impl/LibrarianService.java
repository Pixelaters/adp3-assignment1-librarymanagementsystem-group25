package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Librarian;
import za.ac.cput.repository.LibrarianRepository;

import java.util.List;
@Service
public class LibrarianService implements LibrarianIservice {
private final LibrarianRepository librarianRepository;
@Autowired
    public LibrarianService(LibrarianRepository librarianRepository) {
       this.librarianRepository = librarianRepository;
    }

    @Override
    public Librarian create(Librarian librarian) {
        return this.librarianRepository.save(librarian);
    }

    @Override
    public Librarian read(String id) {
        return this.librarianRepository.getReferenceById(id);
    }

    @Override
    public Librarian update(Librarian Updatelibrarian) {
        return this.librarianRepository.save(Updatelibrarian);
    }

    @Override
    public void delete(String id) {
    this.librarianRepository.deleteById(id);

    }

    @Override
    public List<Librarian> getAll() {
        return this.librarianRepository.findAll();
    }
}

