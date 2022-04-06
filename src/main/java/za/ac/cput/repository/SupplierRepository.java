package za.ac.cput.repository;
/* SupplierRepository.java
Repository class for the Supplier
Author: Ongezwa Gwaza (211272183)
Date: 4 April 2022
*/

import za.ac.cput.entity.Book;
import za.ac.cput.entity.Library;
import za.ac.cput.entity.Supplier;

import java.util.HashSet;
import java.util.Set;

public class SupplierRepository implements SupplierRepositoryInterface{
    //initialise variables and database
    private static SupplierRepository supplierRepository = null;
    private Set<Supplier> suppliersDB = null;

    private SupplierRepository(){
        suppliersDB = new HashSet<Supplier>();
    }

    /*
    Check if a repository instance is already created.
    Create one if non is created
    Uses the singleton pattern
    */
    public static SupplierRepository getInstance(){

        if(supplierRepository == null){
            supplierRepository = new SupplierRepository();
        }

        return supplierRepository;
    }

    //adds a new supplier to the database
    @Override
    public Supplier create(Supplier supplier) {
        boolean supplierAdded = suppliersDB.add(supplier);
//        if supplierAdded is added return the supplier otherwise return null
        return supplierAdded ? supplier : null;
    }

    //Gets a supplier from the Database using the supplierId
    @Override
    public Supplier read(String supplierId) {

        //iterate  through the supplier list and return the supplier whose supplierId equals the input
        for(Supplier supplier: suppliersDB){
            if(supplier.getSupplierId().equals(supplierId))
                return supplier;
        }
        //supplier not found
        return null;
    }


    //Update a supplier in the Database
    @Override
    public Supplier update(Supplier supplier) {
        //Start by getting the supplier from the database
        Supplier oldSupplier = read(supplier.getSupplierId());

        if(oldSupplier != null) {
            //if the supplier is in the database
            //remove old supplier
            //add the new supplier
            suppliersDB.remove(oldSupplier);
            suppliersDB.add(supplier);
            return supplier; //return the updated supplier
        }
        return null;
    }

    //Delete supplier by supplierId
    @Override
    public boolean delete(String supplierId) {
        //Start by getting the supplier from the database using the supplierId
        Supplier supplierToDelete = read(supplierId);

        //if supplier is not available in database return false;
        if(supplierToDelete == null)
            return false;
        /*
        if supplier is available remove/delete it
        if supplier was present and has been removed
        the  remove() method will return true otherwise it will return false
        */
        return suppliersDB.remove(supplierToDelete);
    }

    //list all the suppliers in the Database
    @Override
    public Set<Supplier> getAll() {
        return suppliersDB;
    }

    //Gets a supplier from the Database using the name of the supplier
    @Override
    public Supplier getSupplierByName(String name) {
        //iterate  through the supplier list and return the supplier with the given name
        for(Supplier supplier: suppliersDB){
            if(supplier.getName().equals(name))
                return supplier;
        }
        //supplier not found
        return null;
    }

    //Gets a supplier from the Database using the publisher of the city
    @Override
    public Supplier getSupplierByCity(String city) {
        //iterate  through the supplier list and return the supplier with the given city
        for(Supplier supplier: suppliersDB){
            if(supplier.getCity().equals(city))
                return supplier;
        }
        //supplier not found
        return null;
    }

    //Gets a supplier from the Database using the library
    @Override
    public Supplier getSupplierByLibrary(Library library) {
        //iterate  through the supplier list and return the supplier with the given library
        for(Supplier supplier: suppliersDB){
            if(supplier.getLibraryId().equals(library))
                return supplier;
        }
        //supplier not found
        return null;
    }

    @Override
    public void deleteAll() {
        suppliersDB.clear();
    }
}
