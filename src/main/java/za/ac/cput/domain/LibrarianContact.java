package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LibrarianContact implements Serializable {
    @Id
    private String contactId;
    @Id
    private String librarianId;

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