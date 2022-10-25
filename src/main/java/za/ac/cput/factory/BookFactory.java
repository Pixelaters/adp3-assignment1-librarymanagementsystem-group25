package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Book;

public class BookFactory {
    public static Book CreateBook(Book book){
        StringHelper.checkStringParam("bookId", book.getBookId());
        StringHelper.checkStringParam("bookName", book.getBookName());
        StringHelper.checkStringParam("author", book.getAuthor());
        StringHelper.checkStringParam("genre", book.getGenre());
        StringHelper.checkStringParam("genre", book.getGenre2());
        StringHelper.checkStringParam("genre", book.getGenre3());
        StringHelper.checkStringParam("description", book.getDescription());
        StringHelper.checkStringParam("isRented", book.getIsRented());
        StringHelper.checkStringParam("imgUrl", book.getImgUrl());

        return Book.builder().bookId(book.getBookId()).bookName(book.getBookName()).author( book.getAuthor()).author2(book.getAuthor2()).author3(book.getAuthor3()).genre(book.getGenre()).genre2(book.getGenre2()).genre3(book.getGenre3()).description(book.getDescription()).isRented(book.getIsRented()).imgUrl(book.getImgUrl()).build();


    }
}
