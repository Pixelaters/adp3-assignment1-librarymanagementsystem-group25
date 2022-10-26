package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @Column(name = "bookId")
    private String bookId;
    @NotNull
    private String bookName;

    @NotNull
    private String author;

    private String author2;

    private String author3;

    @NotNull
    private String genre;

    private String genre2;

    private String genre3;

    @NotNull
    private String description;
    @NotNull
    private String isRented;

    private String imgUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "books", fetch = FetchType.EAGER)
    private List<ClientBook> clientBooks;

    @ManyToMany
            @JoinTable(
                    name = "BookAuthor",
                    joinColumns = @JoinColumn(name = "bookId"),
                    inverseJoinColumns = @JoinColumn(name = "authorId")
            )
    Set<Author> authorSet;

    @ManyToMany
    @JoinTable(
            name= "BookGenre",
            joinColumns = @JoinColumn(name= "bookId"),
            inverseJoinColumns = @JoinColumn(name= "genreName")
    )
    Set<Genre> genreSet;

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", author2='" + author2 + '\'' +
                ", author3='" + author3 + '\'' +
                ", genre='" + genre + '\'' +
                ", genre2='" + genre2 + '\'' +
                ", genre3='" + genre3 + '\'' +
                ", description='" + description + '\'' +
                ", isRented='" + isRented + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", authorSet=" + authorSet +
                ", genreSet=" + genreSet +
                '}';
    }

    public String getBookId() {
        return bookId;
    }

    private void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    private void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor2() {
        return author2;
    }

    private void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public String getAuthor3() {
        return author3;
    }

    private void setAuthor3(String author3) {
        this.author3 = author3;
    }

    public String getGenre() {
        return genre;
    }

    private void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre2() {
        return genre2;
    }

    private void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    private void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public String getIsRented() {
        return isRented;
    }

    public void setIsRented(String isRented) {
        this.isRented = isRented;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    private void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<ClientBook> getClientBooks() {
        return clientBooks;
    }

    private void setClientBooks(List<ClientBook> clientBooks) {
        this.clientBooks = clientBooks;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    private void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public Set<Genre> getGenreSet() {
        return genreSet;
    }

    private void setGenreSet(Set<Genre> genreSet) {
        this.genreSet = genreSet;
    }
}
