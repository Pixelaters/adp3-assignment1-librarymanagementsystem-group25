package za.ac.cput.factory;

/* BookFactory.java
Factory class for the Book
Author: Ongezwa Gwaza (211272183)
Date: 31 March 2022
*/

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
