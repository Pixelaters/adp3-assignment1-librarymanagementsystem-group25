package za.ac.cput.factory;

import za.ac.cput.entity.Library;


public class LibraryFactory {

    public static Library createLibrary(int id , String name , String Location , String address){

        Library newLibrary =  (Library) new Library.Builder()
                .setName(name)
                .setLocation(Location)
                .setAddress(address)
                .setLibraryId(String.valueOf(id))
                .build();

        return  newLibrary;

    }
}
