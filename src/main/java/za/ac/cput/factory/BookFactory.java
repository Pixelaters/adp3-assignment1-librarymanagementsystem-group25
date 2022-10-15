package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Book;

public class BookFactory {
    public static Book CreateBook(String bookId, String bookName, String author, String genre, String description, String isRented, String imgUrl){
        StringHelper.checkStringParam("bookId", bookId);
        StringHelper.checkStringParam("bookName", bookName);
        StringHelper.checkStringParam("author", author);
        StringHelper.checkStringParam("genre", genre);
        StringHelper.checkStringParam("description", description);
        StringHelper.checkStringParam("isRented", isRented);
        StringHelper.checkStringParam("imgUrl", imgUrl);

        return Book.builder().bookId(bookId).bookName(bookName).author(author).genre(genre).description(description).isRented(isRented).imgUrl(imgUrl).build();


    }
}
