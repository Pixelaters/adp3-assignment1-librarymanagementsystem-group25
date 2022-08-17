package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ClientBook implements Serializable {
    @Id
    private String clientId;
    @Id
    private String bookId;

    @OneToOne
    @JoinColumn(name="bookId",referencedColumnName = "bookId")
    private Book book;
    @OneToOne
    @JoinColumn(name="clientId",referencedColumnName = "clientId")
    private Client client;

    protected ClientBook(){

    }

    public ClientBook(Builder b) {
        this.clientId = b.clientId;
        this.bookId = b.bookId;

    }

    public String getClientId() {
        return clientId;
    }

    public String getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return "ClientBook{" +
                "clientId='" + clientId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientBook that)) return false;
        return clientId.equals(that.clientId) && bookId.equals(that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, bookId);
    }

    public static class Builder {
        private String clientId;
        private String bookId;

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder bookId(String bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder copy(ClientBook clientBook){
            this.clientId = clientBook.clientId;
            this.bookId = clientBook.bookId;
            return this;
        }

        public ClientBook build() {
            return new ClientBook(this);
        }
    }
}



