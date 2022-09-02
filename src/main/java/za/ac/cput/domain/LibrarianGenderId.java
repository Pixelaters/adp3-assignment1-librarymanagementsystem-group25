package za.ac.cput.domain;

import java.util.Objects;

public class LibrarianGenderId {

    private Librarian librarian;
    private Gender gender;


    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public LibrarianGenderId(){

    }

    @Override
    public String toString() {
        return "LibrarianGenderId{" +
                "librarian=" + librarian +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibrarianGenderId))  return false;
        LibrarianGenderId that = (LibrarianGenderId) o;
        return librarian.equals(that.librarian) && gender.equals(that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(librarian, gender);
    }
}
