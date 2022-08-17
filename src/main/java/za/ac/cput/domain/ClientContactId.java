package za.ac.cput.domain;

import java.io.Serializable;
import java.util.Objects;

public class ClientContactId implements Serializable {
    private String clientContactId;
    private String clientId;
    private String contactId;

    public String getClientContactId() {
        return clientContactId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getContactId() {
        return contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientContactId)) return false;
        ClientContactId that = (ClientContactId) o;
        return clientContactId.equals(that.clientContactId) && clientId.equals(that.clientId) && contactId.equals(that.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientContactId, clientId, contactId);
    }
}
