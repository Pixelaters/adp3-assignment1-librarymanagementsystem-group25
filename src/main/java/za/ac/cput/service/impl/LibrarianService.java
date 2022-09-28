package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.Name;
import za.ac.cput.repository.LibrarianRepository;
import za.ac.cput.repository.LibrarianRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class LibrarianService implements LibrarianIservice {
private final LibrarianRepository librarianRepository;

@Autowired
    public LibrarianService(LibrarianRepository librarianRepository) {
       this.librarianRepository = librarianRepository;
    }

    @Override
    public Librarian create(Librarian librarian) {
        return this.librarianRepository.save(librarian);
    }

    @Override
    public Librarian read(String id) {
        return this.librarianRepository.findById(id).orElse(null);
    }

    @Override
    public Librarian update(Librarian Updatelibrarian) {
        return this.librarianRepository.save(Updatelibrarian);
    }

    @Override
    public void delete(String id) {
    if (this.librarianRepository.existsById(id)){
        this.librarianRepository.deleteById(id);
        System.out.println("Deleted successfully");

    }else{
        System.out.println("Could not find Id specified");

    }
    }

    @Override
    public List<Librarian> getAll() {
        return this.librarianRepository.findAll().stream().toList();
    }

    public List<Librarian>  findLibrarianByPosition(String position) {
        List<Librarian> subset= this.librarianRepository.findLibrarianByPosition(position);
        List<Librarian> librarianList = new ArrayList<>();
        for (Librarian l:subset){
            librarianList.add(l);
        }
        return librarianList;
    }

    public List<Librarian> findLibrarianByName(Name name){

        List<Librarian> subset= this.librarianRepository.findLibrarianByName(name);
        List<Librarian> librarianList = new ArrayList<>();
        for (Librarian l:subset){
            librarianList.add(l);
        }
        return librarianList;


    }
}

