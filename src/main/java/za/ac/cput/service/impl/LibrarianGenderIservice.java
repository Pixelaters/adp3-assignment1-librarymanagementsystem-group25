package za.ac.cput.service.impl;

import za.ac.cput.domain.LibrarianGender;
import za.ac.cput.service.IService;

import java.util.List;

public interface LibrarianGenderIservice extends IService<LibrarianGender,String> {
    public List<LibrarianGender> getAll();
    public List<LibrarianGender> findLibrarianByLibrarianId(String librarianId);

    List<LibrarianGender> findLibrarianGenderByLibrarianId(String librarianId);
}
