package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianAddress;
import za.ac.cput.repository.LibrarianAddressIRepository;
import za.ac.cput.service.LibrarianAddressIService;

import java.util.List;

@Service
public class LibrarianAddressService implements LibrarianAddressIService {

    public final LibrarianAddressIRepository librarianAddressIRepository;

    @Autowired
    public LibrarianAddressService(LibrarianAddressIRepository librarianAddressIRepository) {
        this.librarianAddressIRepository = librarianAddressIRepository;

    }

    @Override
    public LibrarianAddress create(LibrarianAddress librarianAddress) {
        return this.librarianAddressIRepository.save(librarianAddress);
    }

    @Override
    public LibrarianAddress read(String id) {
        return this.librarianAddressIRepository.findById(id).orElse(null);
    }

    @Override
    public LibrarianAddress update(LibrarianAddress updateLibrarianAddress) {
        return this.librarianAddressIRepository.save(updateLibrarianAddress);
    }

    @Override
    public void delete(String id) {
        this.librarianAddressIRepository.deleteById(id);
    }

    @Override
    public List<LibrarianAddress> getAll() {
        return this.librarianAddressIRepository.findAll();
    }

    @Override
    public LibrarianAddress findLibrarianAddressByLibrarianId(String librarianId) {
        return this.librarianAddressIRepository.findLibrarianAddressByLibrarianId(librarianId);
    }
}
