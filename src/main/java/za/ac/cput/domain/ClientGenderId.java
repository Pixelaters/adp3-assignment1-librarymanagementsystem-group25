package za.ac.cput.domain;

import java.io.Serializable;
import java.util.Objects;

public class ClientGenderId implements Serializable {
    private String clientId;
    private String genderId;
    private String clientGenderId;

    public String getClientId() {
        return clientId;
    }

    private void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getGenderId() {
        return genderId;
    }

    private void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getClientGenderId() {
        return clientGenderId;
    }

    private void setClientGenderId(String clientGenderId) {
        this.clientGenderId = clientGenderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientGenderId that)) return false;
        return clientId.equals(that.clientId) && genderId.equals(that.genderId) && clientGenderId.equals(that.clientGenderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, genderId, clientGenderId);
    }
}
