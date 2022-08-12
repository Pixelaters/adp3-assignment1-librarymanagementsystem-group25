package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.LibrarianAddress;
import za.ac.cput.repository.LibrarianAddressIRepository;

@Service
public class LibrarianAddressService implements LibrarianAddressIService {

    public final LibrarianAddressIRepository librarianAddressIRepository;

    @Autowired
    public LibrarianAddressService(LibrarianAddressIRepository librarianAddressIRepository){
        this.librarianAddressIRepository = librarianAddressIRepository;

    }

    @Override
    public LibrarianAddress create(LibrarianAddress librarianAddress) {
        return null;
    }

    @Override
    public LibrarianAddress read(String s) {
        return null;
    }

    @Override
    public LibrarianAddress update(LibrarianAddress librarianAddress) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
