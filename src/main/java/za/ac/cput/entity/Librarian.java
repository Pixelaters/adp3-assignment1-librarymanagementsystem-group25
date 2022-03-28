package za.ac.cput.entity;

/*
   Ziyaad Petersen (219083479)
   ADP3 - Assignment 1: Group 25
   Date: 28 March 2022
 */
public class Librarian extends Staff{
    private String librarianCode;
    private String position;
    private boolean availability;

    public Librarian(LibrarianBuilder b) {
        super(b);
        this.librarianCode = b.librarianCode;
        this.position = b.position;
        this.availability = b.availability;
    }

    public String getLibrarianCode() {
        return librarianCode;
    }

    public void setLibrarianCode(String librarianCode) {
        this.librarianCode = librarianCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return super.toString() +"Librarian{" +
                "librarianCode='" + librarianCode + '\'' +
                ", position='" + position + '\'' +
                ", availability=" + availability +
                '}';
    }


    public static class LibrarianBuilder extends Staff.StaffBuilder{
        private String librarianCode;
        private String position;
        private boolean availability;

        public LibrarianBuilder setLibrarianCode(String librarianCode) {
            this.librarianCode = librarianCode;
            return this;
        }

        public LibrarianBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public LibrarianBuilder setAvailability(boolean availability) {
            this.availability = availability;
            return this;
        }

        public LibrarianBuilder copy(Librarian l){
            this.librarianCode = l.librarianCode;
            this.position = l.position;
            this.availability = l.availability;
            return this;
        }

        public Librarian build(){
            return new Librarian(this);
        }
    }

}
