package za.ac.cput.repository;

import za.ac.cput.entity.Librarian;

import java.util.Set;

public interface LibrarianRepositoryInterface extends IRepository<Librarian, String> {
    public Set<Librarian> getAll();
}
