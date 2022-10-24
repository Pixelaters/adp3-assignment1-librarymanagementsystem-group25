package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.Genre;
import za.ac.cput.repository.AuthorIRepository;
import za.ac.cput.repository.GenreIRepository;
import za.ac.cput.service.GenreIService;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreIService {
    private final GenreIRepository genreIRepository;

    @Autowired
    GenreServiceImpl(GenreIRepository genreIRepository){
        this.genreIRepository= genreIRepository;
    }


    @Override
    public Genre create(Genre genre) {
        return this.genreIRepository.save(genre);
    }

    @Override
    public Genre read(String s) {
        return this.genreIRepository.findById(s).orElse(null);
    }

    @Override
    public Genre update(Genre genre) {
        return this.genreIRepository.save(genre);
    }

    public List<Genre> getAll(){
        return this.genreIRepository.findAll();
    }

    @Override
    public void delete(String s) {
        if (this.genreIRepository.existsById(s)) {
            this.genreIRepository.deleteById(s);
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Could not find Id specified");
        }
    }
}
