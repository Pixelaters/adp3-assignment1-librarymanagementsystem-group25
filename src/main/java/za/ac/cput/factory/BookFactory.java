package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Book;

public class BookFactory {
    public static Book CreateBook(String bookId, String bookName, String bookAuthor, String bookAuthor2,
                                  String bookAuthor3, String genre, String genre2, String genre3, String description,
                                    String isRented, String imgUrl){
        StringHelper.checkStringParam("bookId", bookId);
        StringHelper.checkStringParam("bookName", bookName);
        StringHelper.checkStringParam("author", bookAuthor);
        StringHelper.checkStringParam("author2", bookAuthor2);
        StringHelper.checkStringParam("author3", bookAuthor3);
        StringHelper.checkStringParam("genre", genre);
        StringHelper.checkStringParam("genre2", genre2);
        StringHelper.checkStringParam("genre3", genre3);
        StringHelper.checkStringParam("description", description);
        StringHelper.checkStringParam("isRented", isRented);
        StringHelper.checkStringParam("imgUrl", imgUrl);

        return Book.builder().bookId(bookId).bookName(bookName).author(bookAuthor).author2(bookAuthor2).
                author3(bookAuthor3).genre(genre).genre2(genre2).genre3(genre3).
                description(description).isRented(isRented).
                imgUrl(imgUrl).build();


    }
}
