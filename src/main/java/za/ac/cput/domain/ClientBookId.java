package za.ac.cput.domain;

import javax.persistence.Id;
import java.io.Serializable;

public class ClientBookId implements Serializable {

    private String clientBookId;
    private String clientId;
    private String bookId;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
