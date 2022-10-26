package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Contact implements Serializable {
    @Id
    @Column(name= "contactId")
    private String contactId;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String cell;

    @NotNull
    private String nextOfKin;

    @JsonBackReference
    @OneToMany(mappedBy = "contact")
    //@Fetch(value = FetchMode.SELECT)
    private Set<ClientContact> clientContactSet;

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
