package za.ac.cput.factory;

import za.ac.cput.entity.Book;
import za.ac.cput.entity.Supplier;

public class BookFactory {
    public static Book create(String bookCode, String name, String publisher, String available, Supplier supplier){
        Book book = new Book.BookBuilder(bookCode)
                .nameOfBook(name)
                .publishedBy(publisher)
                .isBookAvailable(available)
                .supplierOfBook(supplier)
                .build();

        return book;

    }
}
