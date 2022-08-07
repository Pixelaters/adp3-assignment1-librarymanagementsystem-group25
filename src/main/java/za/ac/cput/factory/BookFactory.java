package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Book;

public class BookFactory {
    public static Book CreateBook(String bookId, String bookName, String author, String genre){
        StringHelper.checkStringParam("bookId", bookId);
        StringHelper.checkStringParam("bookName", bookName);
        StringHelper.checkStringParam("author", author);
        StringHelper.checkStringParam("genre", genre);

        return new Book.Builder().BookId(bookId).BookName(bookName).Author(author).Genre(genre).build();


    }
}
