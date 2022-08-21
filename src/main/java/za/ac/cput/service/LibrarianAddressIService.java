package za.ac.cput.service;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface LibrarianAddressIService extends IService<LibrarianAddress, String> {

    public List<LibrarianAddress> getAll();

    public LibrarianAddress findLibrarianAddressByLibrarianId(String librarianId);


}
