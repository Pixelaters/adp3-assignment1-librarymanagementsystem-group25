package za.ac.cput.domain;

public class Book {
    private String bookName;
    private String author;
    private String genre;

    protected Book(){

    }

    public Book(Builder builder) {
        this.bookName = builder.bookName;
        this.author = builder.author;
        this.genre = builder.genre;
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
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public static class Builder {
        private String bookName;
        private String author;
        private String genre;

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
