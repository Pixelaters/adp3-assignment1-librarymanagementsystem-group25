package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ClientBookId.class)
public class ClientBook implements Serializable {

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name="bookId",referencedColumnName = "bookId")
    private Book book;


    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name="clientId",referencedColumnName = "clientId")
    private Client client;

    protected ClientBook(){

    }

    public ClientBook(Builder b) {
        this.book = b.book;
        this.client = b.client;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientBook{" +
                "book=" + book +
                ", client=" + client +
                '}';
    }


    public static class Builder {
        private Book book;
        private Client client;

        public Builder Book(Book book) {
            this.book = book;
            return this;
        }

        public Builder Client(Client client) {
            this.client = client;
            return this;
        }

        public Builder copy(ClientBook clientBook){
            this.book= book;
            this.client= client;
            return this;
        }

        public ClientBook build() {
            return new ClientBook(this);
        }
    }
}



