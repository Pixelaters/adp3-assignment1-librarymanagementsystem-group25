package za.ac.cput.entity;


/*
   Ethan George (218008430)
   ADP3 - Assignment 1: Group 25
   Date: 28 March 2022
 */

public class Computer {


    private  String computerId;
    private String brandName;
    private String status;
    private Object libraryId;


    public Computer(Object libraryId) {
        this.computerId = computerId;
        this.brandName = brandName;
        this.status = status;
        this.libraryId = libraryId;
    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Object libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computerId='" + computerId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", status='" + status + '\'' +
                ", libraryId=" + libraryId +
                '}';
    }


    public static  class Builder{


        private String computerId;
        private String brandName;
        private String status;
        private Object libraryId;

        public Builder setComputerId(String computerId) {
            this.computerId = computerId;
            return this;
        }

        public Builder setBrandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setLibraryId(Object libraryId) {
            this.libraryId = libraryId;
            return this;
        }

        public Builder Computer(String computerId, String brandName, String status, Object libraryId) {
            this.computerId = computerId;
            this.brandName = brandName;
            this.status = status;
            this.libraryId = libraryId;

            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
