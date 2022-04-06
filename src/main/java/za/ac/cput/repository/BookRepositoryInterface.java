package za.ac.cput.repository;

/* BookRepositoryInterface.java
Repository interface for the Book
Author: Ongezwa Gwaza (211272183)
Date: 4 April 2022
*/

import za.ac.cput.entity.Book;
import za.ac.cput.entity.Supplier;

import java.util.Set;

public interface BookRepositoryInterface extends IRepository<Book,String>{
    Set<Book> getAll();
    Book getBookByName(String name);
    Book getBookByPublisher(String publisher);
    Book getBookBySupplier(Supplier supplier);
    void deleteAll();
}
