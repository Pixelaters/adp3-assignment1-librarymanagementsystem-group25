package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(LibrarianContactId.class)
public class LibrarianContact implements Serializable {
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name="contactId",referencedColumnName = "contactId")
    private Contact contact;

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name="librarianId",referencedColumnName = "librarianId")
    private Librarian librarian;

    protected LibrarianContact(){}

    public LibrarianContact(Builder builder){
        this.librarian= builder.librarian;
        this.contact = builder.contact;

    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public String toString() {
        return "ClientContact{" +
                "contact=" + contact +
                ", librarian=" + librarian +
                '}';
    }

    public static class  Builder{
        private Contact contact;
        private Librarian librarian;

        public LibrarianContact.Builder Contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public LibrarianContact.Builder Librarian(Librarian librarian) {
            this.librarian =librarian;
            return this;
        }
        public LibrarianContact.Builder copy(LibrarianContact librarianContact){
            this.librarian = librarian;
            this.contact = contact;

            return this;
        }

        public LibrarianContact build(){
            return new LibrarianContact(this);
        }
    }
}
