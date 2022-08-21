package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(LibrarianContact.class)
public class LibrarianContact implements Serializable {
    @Id
    @Column(name = "librarianContactId")
    private String librarianContactId;

    @Id
    @Column(name = "contactId")
    private String contactId;

    @Id
    @Column(name = "librarianId")
    private String librarianId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "contactId",referencedColumnName = "contactId")
    private Contact contact;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "librarianId",referencedColumnName = "librarianId")
    private Librarian librarian;

   protected LibrarianContact(){

    }

    public LibrarianContact(Builder builder){
    this.contactId = builder.contactId;
    this.librarianId = builder.librarianId;
}
    public String getContactId() {
        return contactId;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    @Override
    public String toString() {
        return "LibrarianContact{" +
                "contactId='" + contactId + '\'' +
                ", librarianId='" + librarianId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibrarianContact that)) return false;
        return contactId.equals(that.contactId) && librarianId.equals(that.librarianId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, librarianId);
    }

    public static class Builder{
        private String contactId;
        private String librarianId;

        public Builder ContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder LibrarianId(String librarianId) {
            this.librarianId = librarianId;
            return this;
        }
        public Builder Copy(LibrarianContact librarianContact){
            this.contactId = contactId;
            this.librarianId = librarianId;
            return this;
        }
        public LibrarianContact createLibrarianC(){
            return new LibrarianContact(this);
        }


    }
}