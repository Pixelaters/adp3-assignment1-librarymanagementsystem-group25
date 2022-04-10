package za.ac.cput.repository;

import za.ac.cput.entity.Librarian;

import java.util.HashSet;
import java.util.Set;

/*
    LibrarianRepository.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 6 April 2022
 */

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
    public Librarian read(Long staffID) {
        for (Librarian librarian: lbrarian){
            if (librarian.getStaffMember_ID()== staffID){
                return librarian;
            }

        }
        return null;
    }

    @Override
    public Librarian update(Librarian librarian) {
        Librarian oldLibrarian = read((librarian.getStaffMember_ID()));
        if (oldLibrarian != null){
            lbrarian.remove(oldLibrarian);
            lbrarian.add(librarian);
            return librarian;
        }
        return null;
    }

    @Override
    public boolean delete(Long librarianCode) {
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
