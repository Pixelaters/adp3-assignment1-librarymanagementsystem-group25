package za.ac.cput.domain;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClientBookId implements Serializable {

    private Client client;
    private Book book;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ClientBookId() {

    }

    @Override
    public String toString() {
        return "ClientBookId{" +
                "client=" + client +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientBookId)) return false;
        ClientBookId that = (ClientBookId) o;
        return client.equals(that.client) && book.equals(that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, book);
    }
}
