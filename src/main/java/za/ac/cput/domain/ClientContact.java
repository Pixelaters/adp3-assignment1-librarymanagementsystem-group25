/*
Nondumiso Gaga(220430853)
08/08/2022
 */
package za.ac.cput.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ClientContactId.class)
public class ClientContact implements Serializable {

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name="contactId",referencedColumnName = "contactId")
    private Contact contact;

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name="clientId",referencedColumnName = "clientId")
    private Client client;

    protected ClientContact(){}

    public ClientContact(Builder builder){
        this.client= builder.client;
        this.contact = builder.contact;

    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientContact{" +
                "contact=" + contact +
                ", client=" + client +
                '}';
    }

    public static class  Builder{
        private Contact contact;
        private Client client;

        public Builder Contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder Client(Client client) {
            this.client = client;
            return this;
        }
        public Builder copy(ClientContact clientContact){
            this.contact = contact;
            this.client = client;
            return this;
        }

        public ClientContact build(){
            return new ClientContact(this);
        }
    }
}
