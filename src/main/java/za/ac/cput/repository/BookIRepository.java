package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Book;

import java.util.List;

@Repository
public interface BookIRepository extends JpaRepository<Book, String> {
    public List<Book> findByBookId(String bookId);
    public List<Book> findByBookName(String bookName);
    public List<Book> findByAuthor(String author);



}
