/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class LibrarianGender implements Serializable {
    @Id
    private String librarianId;
    @Id
    private String genderId;

    protected LibrarianGender(){

    }



    public LibrarianGender(Builder builder){
        this.genderId = builder.genderId;
        this.librarianId = builder.librarianId;

    }

    public String getLibrarianId() {
        return librarianId;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public String toString() {
        return "LibrarianGender{" +
                "librarianId='" + librarianId + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibrarianGender that)) return false;
        return librarianId.equals(that.librarianId) && genderId.equals(that.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(librarianId, genderId);
    }

    public static class Builder{
        private String librarianId;
        private String genderId;

        public Builder LibrarianId(String librarianId) {
            this.librarianId = librarianId;
            return this;
        }

        public Builder GenderId(String genderId) {
            this.genderId = genderId;
            return this;
        }
        public Builder Copy (LibrarianGender LibrarianGender){
            this.librarianId = librarianId;
            this.genderId = genderId;
            return this;

        }
        public LibrarianGender createLibrarianG(){return new LibrarianGender(this);}
    }

}
