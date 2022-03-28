/* Library.java
Entity for Library
Author: Ethan George(218008430)
Date: 28 March 2022
*/

package za.ac.cput.entity;

public class Library {

    private String libraryId;
    private String libraryName;
    private String libraryLocation;
    private String libraryAddress;

    public Library( String libraryId , String libraryName , String libraryLocation , String libraryAddress){

       this.libraryId = libraryId;
       this.libraryName =  libraryName;
       this.libraryLocation = libraryLocation;
       this.libraryAddress = libraryAddress;
    }

    public Library(Library library) {
    }


    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryLocation() {
        return libraryLocation;
    }

    public void setLibraryLocation(String libraryLocation) {
        this.libraryLocation = libraryLocation;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryId='" + libraryId + '\'' +
                ", libraryName='" + libraryName + '\'' +
                ", libraryLocation='" + libraryLocation + '\'' +
                ", libraryAddress='" + libraryAddress + '\'' +
                '}';
    }


    public static class LibraryBuilder{

        private String libraryId;
        private String libraryName;
        private String libraryLocation;
        private String libraryAddress;
    }





    public Library build(){
        Library library = new Library(  this);
        return library;
    }
}
