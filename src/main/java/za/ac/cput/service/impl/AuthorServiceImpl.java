package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Author;
import za.ac.cput.repository.AuthorIRepository;
import za.ac.cput.service.AuthorIService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorIService {
    private final AuthorIRepository authorIRepository;

    @Autowired
    AuthorServiceImpl(AuthorIRepository authorIRepository){
        this.authorIRepository= authorIRepository;
    }


    @Override
    public Author create(Author author) {
        return this.authorIRepository.save(author);
    }

    @Override
    public Author read(String s) {
        return this.authorIRepository.findById(s).orElse(null);
    }

    @Override
    public Author update(Author author) {
       return this.authorIRepository.save(author);
    }

    public List<Author> getAll(){
        return this.authorIRepository.findAll();
    }
    @Override
    public void delete(String s) {
        if (this.authorIRepository.existsById(s)) {
            this.authorIRepository.deleteById(s);
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Could not find Id specified");
        }
    }
}
