package za.ac.cput.repository;




import za.ac.cput.entity.Library;


import java.util.HashSet;
import java.util.Set;


public class LibraryRepository implements LibraryRepositoryInterface{

    private static LibraryRepository libraryRepository = null;
    private static Set<Library> libraryDB = null;
    private LibraryRepository() { libraryDB = new HashSet<Library>() ;}

    public static LibraryRepository getInstance(){

        if(libraryRepository == null){
            libraryRepository = new LibraryRepository();
        }
        return libraryRepository;
    }

    @Override
    public Library create(Library newLibrary) {

        boolean success = libraryDB.add(newLibrary);

        if(!success)
            return null;
        return newLibrary;

    }



    @Override
    public Library read(String libraryID) {

        for(Library library: libraryDB){
            if (library.getLibraryId() ==  libraryID) {
                return library;
            }
        }
        return null;
    }



    @Override
    public Library update(Library updateLibrary) {

        Library oldLibrary = read(updateLibrary.getLibraryId());

        if(oldLibrary != null){
            libraryDB.remove(oldLibrary);
            libraryDB.add(updateLibrary);
            return updateLibrary;

        }

        return null;
    }

    @Override
    public boolean delete(String libraryId) {

        Library deleteLibrary = read(libraryId);
        if (deleteLibrary == null)
            return false;
        libraryDB.remove(deleteLibrary);
        return true;

    }
    



    @Override
    public Set<Library> getAll() {
        return libraryDB;
    }
}
