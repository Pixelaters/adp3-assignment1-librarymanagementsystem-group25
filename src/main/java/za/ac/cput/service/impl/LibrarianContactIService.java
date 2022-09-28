package za.ac.cput.service.impl;

import za.ac.cput.domain.LibrarianContact;
import za.ac.cput.service.IService;

import java.util.List;

public interface LibrarianContactIService extends IService<LibrarianContact,String> {
    List<LibrarianContact> getAll();
    LibrarianContact findLibrarianContactByLibrarianId(String librarianId);


}
