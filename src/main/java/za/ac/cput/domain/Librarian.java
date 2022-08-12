package za.ac.cput.domain;

import javax.persistence.*;

/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Entity: Librarian class (Didn't have to do this)
 * Date: 2022/08/06
 * */
@Entity
public class Librarian {
    @Id
    private String staffId;
    private String position;


    private Name name;

    private Librarian(LibrarianBuilder lb) {
        this.staffId = lb.staffId;
        this.position = lb.position;
        this.name = lb.name;
    }

    public Librarian() {

    }

    public String getStaffId() {
        return staffId;
    }

    public String getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "staffId='" + staffId + '\'' +
                ", name='" + name + '\'' +
                ", position=" + position+
                '}';
    }

    public static class LibrarianBuilder{
        private String staffId, position;
        private Name name;

        public LibrarianBuilder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public LibrarianBuilder position(String position) {
            this.position = position;
            return this;
        }

        public LibrarianBuilder name(Name name) {
            this.name = name;
            return this;
        }

        public LibrarianBuilder copy(Librarian l){
            this.staffId = l.staffId;
            this.name = l.name;
            this.position = l.position;
            return this;
        }

        public Librarian build(){
            return new Librarian(this);
        }
    }
}
