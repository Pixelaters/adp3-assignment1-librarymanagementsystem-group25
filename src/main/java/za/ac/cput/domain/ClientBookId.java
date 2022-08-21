package za.ac.cput.domain;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClientBookId implements Serializable {

    private String clientBookId;
    private String clientId;
    private String bookId;

    public String getClientId() {
        return clientId;
    }

    private void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBookId() {
        return bookId;
    }

    private void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientBookId that)) return false;
        return clientBookId.equals(that.clientBookId) && clientId.equals(that.clientId) && bookId.equals(that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientBookId, clientId, bookId);
    }
}
