package za.ac.cput.repository;

import za.ac.cput.entity.Supplier;
import za.ac.cput.entity.Library;

import java.util.Set;

/* SupplierRepositoryInterface.java
Repository interface for the Supplier
Author: Ongezwa Gwaza (211272183)
Date: 4 April 2022
*/
public interface SupplierRepositoryInterface extends IRepository<Supplier,String>{
    Set<Supplier> getAll();
    Supplier getSupplierByName(String name);
    Supplier getSupplierByCity(String publisher);
    Supplier getSupplierByLibrary(Library library);
}
