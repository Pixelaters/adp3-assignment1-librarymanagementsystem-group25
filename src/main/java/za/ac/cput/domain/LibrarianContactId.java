package za.ac.cput.domain;

import java.io.Serializable;
import java.util.Objects;

public class LibrarianContactId implements Serializable {

    private Librarian librarian ;
    private Contact contact;


    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public LibrarianContactId(){}

    @Override
    public String toString() {
        return "LibrarianContactId{" +
                "librarian=" + librarian +
                ", contact=" + contact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibrarianContactId) ) return false;
        LibrarianContactId that = (LibrarianContactId) o;
        return librarian.equals(that.librarian) && contact.equals(that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(librarian, contact);
    }
}