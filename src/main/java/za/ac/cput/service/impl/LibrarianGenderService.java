package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianGender;
import za.ac.cput.repository.LibrarianGenderRepository;

import java.util.List;
@Service
public class LibrarianGenderService implements LibrarianGenderIservice{
private final LibrarianGenderRepository librarianGenderRepository;
@Autowired
    public LibrarianGenderService(LibrarianGenderRepository librarianGenderRepository) {
        this.librarianGenderRepository = librarianGenderRepository;
    }

    @Override
    public LibrarianGender create(LibrarianGender librarianGender) {
        return this.librarianGenderRepository.save(librarianGender);
    }

    @Override
    public LibrarianGender read(String id) {
        return this.librarianGenderRepository.getReferenceById(id);
    }

    @Override
    public LibrarianGender update(LibrarianGender UpdatelibrarianGender) {
        return this.librarianGenderRepository.save(UpdatelibrarianGender);
    }

    @Override
    public void delete(String id) {
    this.librarianGenderRepository.deleteById(id);

    }

    @Override
    public List<LibrarianGender> getAll() {
        return this.librarianGenderRepository.findAll();
    }
}

