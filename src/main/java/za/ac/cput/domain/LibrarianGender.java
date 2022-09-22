/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(LibrarianGender.class)
public class LibrarianGender implements Serializable {
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "genderId", referencedColumnName = "genderId")
    private Gender gender;
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "librarianId", referencedColumnName = "librarianId")
    private Librarian librarian;

    protected LibrarianGender() {
    }

    public LibrarianGender(Builder builder) {
        this.librarian = builder.librarian;
        this.gender = builder.gender;

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public String toString() {
        return "LibrarianGender{" +
                "gender=" + gender +
                ", librarian=" + librarian +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibrarianGender that)) return false;
        return gender.equals(that.gender) && librarian.equals(that.librarian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, librarian);
    }

    public static class Builder {
        private Gender gender;
        private Librarian librarian;


        public Builder Gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder Librarian(Librarian librarian) {
            this.librarian = librarian;
            return this;
        }

        public Builder copy(LibrarianGender librarianGender) {
            this.gender = gender;
            this.librarian = librarian;
            return this;

        }

        public LibrarianGender build() {
            return new LibrarianGender(this);
        }
    }
}
