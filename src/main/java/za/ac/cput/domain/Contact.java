package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Contact implements Serializable {
    @Id
    @Column(name= "contactId")
    private String contactId;

    @NotNull
    private String email;

    @NotNull
    private String cell;

    @NotNull
    private String nextOfKin;

    @OneToMany(mappedBy = "contact")
    private Set<ClientContact> clientContactSet;


    protected Contact() {

    }

    public Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.email = builder.email;
        this.cell = builder.cell;
        this.nextOfKin = builder.nextOfKin;
    }

    public String getContactId() {
        return contactId;
    }

    public String getEmail() {
        return email;
    }

    public String getCell() {
        return cell;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public static class Builder {
        private String contactId;
        private String email;
        private String cell;
        private String nextOfKin;

        public Builder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setCell(String cell) {
            this.cell = cell;
            return this;
        }

        public Builder setNextOfKin(String nextOfKin) {
            this.nextOfKin = nextOfKin;
            return this;
        }

        public Builder copy(Contact c){
            this.contactId = c.contactId;
            this.email = c.email;
            this.cell = c.cell;
            this.nextOfKin = c.nextOfKin;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
