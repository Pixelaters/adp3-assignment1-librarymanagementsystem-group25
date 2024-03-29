package za.ac.cput.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Entity: LibrarianAddress class
 * Date: 2022/08/06
 * */
@Entity
public class LibrarianAddress implements Serializable {
    @Id
    private String librarianId;
    @Embedded
    private Address address;

    private LibrarianAddress(LibrarianAddressBuilder lab) {
        this.librarianId = lab.librarianId;
        this.address = lab.address;
    }

    protected LibrarianAddress() {

    }

    public String getLibrarianId() {
        return librarianId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "LibrarianAddress{" +
                "librarianId='" + librarianId + '\'' +
                ", address=" + address +
                '}';
    }

    public static class LibrarianAddressBuilder{
        private String librarianId;
        private Address address;

        public LibrarianAddressBuilder librarianId(String librarianId) {
            this.librarianId = librarianId;
            return this;
        }

        public LibrarianAddressBuilder address(Address address) {
            this.address = address;
            return this;
        }
        public LibrarianAddressBuilder copy(LibrarianAddress la){
            this.librarianId = la.librarianId;
            this.address = la.address;
            return this;

        }

        public LibrarianAddress build(){
            return new LibrarianAddress(this);
        }
    }
}
