package za.ac.cput.repository;

import za.ac.cput.entity.Library;

import java.util.Set;

public interface LibraryRepositoryInterface extends IRepository<Library , String> {


    Library read(String libraryID);

    public Set<Library> getAll();

}
