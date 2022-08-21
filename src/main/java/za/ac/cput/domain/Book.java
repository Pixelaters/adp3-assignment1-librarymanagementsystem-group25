package za.ac.cput.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book implements Serializable {
    @Id
    @Column(name = "bookId")
    private String bookId;
    @NotNull
    private String bookName;
    @NotNull
    private String author;
    @NotNull
    private String genre;

    @OneToMany(mappedBy = "book")
    private Set<ClientBook> clientBookSet;

    protected Book(){

    }

    public Book(Builder builder) {
        this.bookId = builder.bookId;
        this.bookName = builder.bookName;
        this.author = builder.author;
        this.genre = builder.genre;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return bookId.equals(book.bookId) && bookName.equals(book.bookName) && author.equals(book.author) && genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, author, genre);
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
