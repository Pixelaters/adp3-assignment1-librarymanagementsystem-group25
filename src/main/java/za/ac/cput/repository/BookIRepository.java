package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Book;

import java.util.List;

public interface BookIRepository extends JpaRepository<Book, String> {
    public List<Book> findByBookId(String bookId);
    public List<Book> findByBookName(String bookName);
    public List<Book> findByAuthor(String author);

}
