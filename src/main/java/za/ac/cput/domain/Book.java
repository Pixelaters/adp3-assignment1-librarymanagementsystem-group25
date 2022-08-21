package za.ac.cput.domain;

import javax.persistence.Embeddable;

//ziyaad

@Embeddable
public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private String genre;

    protected Book(){

    }

    public Book(Builder builder) {
        this.bookId = builder.bookId;
        this.bookName = builder.bookName;
        this.author = builder.author;
        this.genre = builder.genre;
    }

    private void setBookId(String bookId) {
        this.bookId = bookId;
    }

    private void setBookName(String bookName) {
        this.bookName = bookName;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public static class Builder {
        private String bookId;
        private String bookName;
        private String author;
        private String genre;

        public Builder BookId(String bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder BookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public Builder Author(String author) {
            this.author = author;
            return this;
        }

        public Builder Genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder copy(Book book){
            this.bookId= bookId;
            this.bookName= bookName;
            this.author= author;
            this.genre= genre;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
