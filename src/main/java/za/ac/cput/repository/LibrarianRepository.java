package za.ac.cput.repository;

import za.ac.cput.entity.Librarian;

import java.util.HashSet;
import java.util.Set;

public class LibrarianRepository implements  LibrarianRepositoryInterface {

    private static IRepository IR= null;

    private Set<Librarian> lbrarian;

    private LibrarianRepository(){
        lbrarian = new HashSet<Librarian>();
    }
    public static LibrarianRepository getInstance(){
        if(IR == null){
            IR= new LibrarianRepository();
        }
        return(LibrarianRepository) IR;
    }

    @Override
    public Librarian create(Librarian librarian) {
        boolean success= lbrarian.add((librarian));
        if (!success){
            return null;
        }
        return librarian;
    }

    @Override
    public Librarian read(String librarianCode) {
        for (Librarian librarian: lbrarian){
            if (librarian.getLibrarianCode().equals(librarianCode)){
                return librarian;
            }

        }
        return null;
    }

    @Override
    public Librarian update(Librarian librarian) {
        Librarian oldLibrarian = read((librarian.getLibrarianCode()));
        if (oldLibrarian != null){
            lbrarian.remove(oldLibrarian);
            lbrarian.add(librarian);
            return librarian;
        }
        return null;
    }

    @Override
    public boolean delete(String librarianCode) {
        Librarian deleteLibrarian= read(librarianCode);
        if (deleteLibrarian== null){
            return false;
        }
        lbrarian.remove(deleteLibrarian);
        return true;
    }

    @Override
    public Set<Librarian> getAll() {
        return lbrarian;
    }
}
