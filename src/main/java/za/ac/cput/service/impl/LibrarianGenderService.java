package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.LibrarianGender;
import za.ac.cput.repository.LibrarianGenderRepository;

import java.util.List;
@Service
public class LibrarianGenderService implements LibrarianGenderIservice{
private final LibrarianGenderRepository LibrarianGenderRepository;
@Autowired
    public LibrarianGenderService(za.ac.cput.repository.LibrarianGenderRepository librarianGenderRepository) {
        LibrarianGenderRepository = librarianGenderRepository;
    }

    @Override
    public LibrarianGender create(LibrarianGender librarianGender) {
        return this.LibrarianGenderRepository.save(librarianGender);
    }

    @Override
    public LibrarianGender read(String id) {
        return this.LibrarianGenderRepository.getReferenceById(id);
    }

    @Override
    public LibrarianGender update(LibrarianGender UpdatelibrarianGender) {
        return this.LibrarianGenderRepository.save(UpdatelibrarianGender);
    }

    @Override
    public void delete(String id) {
    this.LibrarianGenderRepository.deleteById(id);

    }

    @Override
    public List<LibrarianGender> getAll() {
        return this.LibrarianGenderRepository.findAll();
    }
}

