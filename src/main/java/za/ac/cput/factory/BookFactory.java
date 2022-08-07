package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Book;

public class BookFactory {
    public static Book CreateBook(String bookName, String author, String genre){
        StringHelper.checkStringParam("bookName", bookName);
        StringHelper.checkStringParam("author", author);
        StringHelper.checkStringParam("genre", genre);

        return new Book.Builder().BookName(bookName).Author(author).Genre(genre).build();


    }
}
