package za.ac.cput.service;

import za.ac.cput.domain.Book;

import java.util.Set;

public interface BookIService extends IService<Book, String> {
    public Set<Book> getAll();
}
