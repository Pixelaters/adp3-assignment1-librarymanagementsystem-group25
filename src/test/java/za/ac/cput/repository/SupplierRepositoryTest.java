package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Supplier;
import za.ac.cput.entity.Library;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SupplierRepositoryTest {
    private static SupplierRepository supplierRepository = SupplierRepository.getInstance();
    private static Library library;
    private static Supplier testSupplier;
    private static Supplier supplier2;
    private static Supplier supplier3;
    private static Supplier supplier4;

    @BeforeAll
    public static void setUp() throws Exception {

         library = new Library.Builder()
                .setLibraryId("123")
                .setAddress("101 10th street")
                .setLocation("Polokwane")
                .setName("City Library")
                .build();

        testSupplier = new Supplier.SupplierBuilder("1")
                .nameOfSupplier("Baroda")
                .cityWhereSupplierIsLocated("Jo'burg")
                .library(library)
                .build();
        

        //create supplier instances
        Library library2 = library;
        library2.setName("Council Library");
        supplier2 = new Supplier.SupplierBuilder("2")
                .nameOfSupplier("Beetle")
                .cityWhereSupplierIsLocated("Messina")
                .library(library2)
                .build();

        Library library3 = library;
        library3.setName("University Library");
        supplier3 = new Supplier.SupplierBuilder("3")
                .nameOfSupplier("Cyber")
                .cityWhereSupplierIsLocated("Cape Town")
                .library(library3)
                .build();


        Library library4 = library;
        library4.setName("School Library");
        supplier4 = new Supplier.SupplierBuilder("4")
                .nameOfSupplier("TechnoReader")
                .cityWhereSupplierIsLocated("Eastern Cape")
                .library(library3)
                .build();

    }

    @AfterEach
    public void cleanUpEach() throws Exception {
        supplierRepository.deleteAll();

    }

    @Test
    @DisplayName("Test get all when database is empty")
    public void getAll_if_database_isempty() {

        Set<Supplier> suppliers = supplierRepository.getAll();
        System.out.println(suppliers);
        Boolean suppliersIsEmpty = suppliers.isEmpty();
        assertTrue(suppliersIsEmpty,"Database is empty as there are not items in the database");
        System.out.println("Test passed : Database is empty");

    }
    @Test
    @DisplayName("Test persistence of supplier in the database")
    public void createSupplier_success() {
        Supplier supplier = supplierRepository.create(testSupplier);
        assertNotNull(supplier, "The saved supplier should not be null");
        assertEquals(supplier.getSupplierId(),testSupplier.getSupplierId(), "The saved supplierId should be equal to the supplierId of supplied supplier");
        assertEquals(supplier.getName(),testSupplier.getName(), "The names of the saved supplier and supplied supplier should be equal");
        assertEquals(supplier.getCity(),testSupplier.getCity(), "The city fields should be equal");
        assertEquals(supplier.getLibraryId(),testSupplier.getLibraryId(), "The libraries of the supplier should be the same");
        System.out.println("Test passed: Supplier created and saved");

    }
    @Test
    @DisplayName("List all the suppliers in the database")
    public void getAll_when_database_has_values() {

        //save the suppliers to database
        System.out.println(supplierRepository.getAll());
        supplierRepository.create(supplier2);
        supplierRepository.create(supplier3);
        supplierRepository.create(supplier4);

        Set<Supplier> suppliers = supplierRepository.getAll();
        assertEquals(3,suppliers.size(),"The number of elements in the database should be equal to the number of items added");
        System.out.println("Test passed : All suppliers listed");

    }
    @Test
    @DisplayName("Get one supplier by supplierId")
    public void read_should_find_supplier_by_supplierId() {

        System.out.println(testSupplier);
        supplierRepository.create(testSupplier);
        supplierRepository.create(supplier2);
        supplierRepository.create(supplier3);
        Supplier foundSupplier = supplierRepository.read(testSupplier.getSupplierId());
        assertEquals(testSupplier.getSupplierId(),foundSupplier.getSupplierId(),"The supplier found in the database should be equal to the supplier added");
        System.out.println("Test passed : One supplier read from database");
    }
    @Test
    @DisplayName("Get one supplier by supplier name")
    public void getSupplierByName_success() {
        //save suppliers
        supplierRepository.create(testSupplier);
        supplierRepository.create(supplier2);
        supplierRepository.create(supplier3);
        //get supplier by name
        Supplier foundSupplier = supplierRepository.getSupplierByName(testSupplier.getName());
        assertEquals(foundSupplier,testSupplier,"The supplier found in the database should be equal to the supplier added");
        System.out.println("Test passed : Supplier found by name");
    }

    @Test
    @DisplayName("Get one supplier by city")
    public void getSupplierByCity_success() {
        //save suppliers
        supplierRepository.create(testSupplier);
        supplierRepository.create(supplier2);
        supplierRepository.create(supplier3);
        //get supplier by city
        Supplier foundSupplier = supplierRepository.getSupplierByCity(testSupplier.getCity());
        assertEquals(foundSupplier,testSupplier,"The supplier found in the database should be equal to the supplier added");
        System.out.println("Test passed : Supplier Found by city");
    }

    @Test
    @DisplayName("Delete supplier by supplierId")
    public void delete() {
        //save suppliers
        supplierRepository.create(testSupplier);
        supplierRepository.create(supplier2);
        supplierRepository.create(supplier3);
        //delete supplier
        Boolean supplierDeleted = supplierRepository.delete(testSupplier.getSupplierId());
        assertTrue(supplierDeleted,testSupplier.getName() + " has been deleted successfully");
        System.out.println("Test passed : Suppliers successfully deleted");
        //test deleting a supplier not in database
        Boolean itemDeleted = supplierRepository.delete("6");
        assertFalse(itemDeleted,testSupplier.getSupplierId() + " is not available");
        System.out.println("Test passed : Supplier not deleted as it is not available");

        //test if the other suppliers are still available
        Set<Supplier> suppliers = supplierRepository.getAll();
        Boolean supplier2isPresent = suppliers.contains(supplier2);
        Boolean supplier3isPresent = suppliers.contains(supplier3);
        assertTrue(supplier2isPresent,supplier2.getName() + " was not deleted");
        assertTrue(supplier3isPresent,supplier3.getName() + " was not deleted");
        System.out.println("Test passed : Suppliers not deleted");

    }
    @Test
    public void update() {
        //save suppliers
        Supplier supplier = supplierRepository.create(testSupplier);
        Supplier supplierBeforeUpdate = supplier4.copy(supplier4);
        System.out.println(supplierBeforeUpdate);
        Supplier savedSupplier = supplierRepository.create(supplierBeforeUpdate);

        //update savedSupplier
        savedSupplier.setName("First Readers");
        savedSupplier.setCity("Gugulethu");
        Supplier updatedSupplier = supplierRepository.update(savedSupplier);

        //check if saved supplier has been updated
        assertEquals(updatedSupplier.getSupplierId(),savedSupplier.getSupplierId(),"SupplierIds should be equal");
        assertEquals(updatedSupplier.getName(),savedSupplier.getName(),"Names should be equal");
        assertEquals(updatedSupplier.getCity(),savedSupplier.getCity(),"Cities should be equal");
        System.out.println("Test passed : Supplier updated");

        //check if original supplier i.e supplier4 is different from updated supplier
        assertNotEquals("TecnoReader",updatedSupplier.getName(),"Final updated Supplier name should be different from original supplier ");
        assertNotEquals("Eastern Cape",updatedSupplier.getName(),"Final updated Supplier city should be different from original supplier ");
        assertEquals(supplier,testSupplier,"Supplier not updated");


    }

}
