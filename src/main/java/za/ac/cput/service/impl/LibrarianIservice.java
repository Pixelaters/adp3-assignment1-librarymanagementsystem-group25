package za.ac.cput.service.impl;

import za.ac.cput.domain.Librarian;
import za.ac.cput.service.IService;

import java.util.List;

public interface LibrarianIservice  extends IService<Librarian,String> {
    List<Librarian> getAll();
}
