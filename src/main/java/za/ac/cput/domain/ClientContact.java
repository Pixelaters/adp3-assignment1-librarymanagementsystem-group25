/*
Nondumiso Gaga(220430853)
08/08/2022
 */
package za.ac.cput.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ClientContact implements Serializable {
    @Id
    private String contactId;

    @Id
    private String clientId;

    protected ClientContact(){

    }
    private ClientContact(ClientContact.Builder builder){
        this.contactId = builder.contactId;
        this.clientId = builder.clientId;
    }
    public String getContactId() {
        return contactId;
    }

    public String getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "LibrarianContact{" +
                "contactId='" + contactId + '\'' +
                ", librarianId='" + clientId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientContact that)) return false;
        return contactId.equals(that.contactId) && clientId.equals(that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, clientId);
    }

    public static class Builder{
        private String contactId;
        private String clientId;

        public ClientContact.Builder ContactId(String contactId) {

            this.contactId = contactId;
            return this;
        }

        public ClientContact.Builder ClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        public ClientContact.Builder Copy(ClientContact clientContact){
            this.contactId = contactId;
            this.clientId = clientId;
            return this;
        }
        public ClientContact createClientCont(){
            return new ClientContact(this);
        }


    }
}
