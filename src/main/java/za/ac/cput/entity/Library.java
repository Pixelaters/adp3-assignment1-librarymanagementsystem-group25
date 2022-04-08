package za.ac.cput.entity;

/*
   Ethan George (218008430)
   ADP3 - Assignment 1: Group 25
   Date: 28 March 2022
 */

public class Library {

    private String libraryId;
    private String name;
    private String location;
    private String address;

    public Library(String libraryId, String name, String location, String address) {
        this.libraryId = libraryId;
        this.name = name;
        this.location = location;
        this.address = address;
    }

    public Library(Builder builder) {
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryId='" + libraryId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Object isAddress() {
        return null;
    }

    public Object isLocation() {
        return null;
    }

    public static class Builder{

        private String libraryId;
        private String name;
        private String location;
        private String address;

        public Builder Library(String libraryId, String name, String location, String address) {
            this.libraryId = libraryId;
            this.name = name;
            this.location = location;
            this.address = address;

            return this;
        }

        public Builder setLibraryId(String libraryId) {
            this.libraryId = libraryId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Library build(){
            return new Library( this);
        }
    }
}
