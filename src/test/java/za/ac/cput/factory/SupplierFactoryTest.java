package za.ac.cput.factory;

/* SupplierFactoryTest.java
Test class  for the Supplier
Author: Ongezwa Gwaza (211272183)
Date: 31 March 2022
*/

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Library;
import za.ac.cput.entity.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierFactoryTest {
    private static Library library;

    @BeforeAll
    public static void setUp() throws Exception {
        library = new Library.Builder()
                .setLibraryId("123")
                .setAddress("101 10th street")
                .setLocation("Polokwane")
                .setName("City Library")
                .build();
    }
    @Test
    @DisplayName("Test Creation of a new supplier")
    public void createNewSupplierTest(){
        Supplier supplier = SupplierFactory.create("1","Gardner","Cape town",library);
        assertNotNull(supplier);
        System.out.println("Test passed");

    }

    @Test
    @DisplayName("Test Creation of a new supplier with missing attributes")
    public void createSupplierWithMissingDetails(){
    Supplier supplier = new Supplier.SupplierBuilder("123")
            .nameOfSupplier("Baroda")
                    .cityWhereSupplierIsLocated("Jo'burg")
                            .build();
        assertNotNull(supplier);
        System.out.println("Test Passed: Supplier created");

    }

    @Test
    @DisplayName("Test Details of created supplier")
    public void testSupplierDetails() throws Exception {
        Supplier supplier = SupplierFactory.create("1","Gardner","Cape Town",library);
        assertEquals("1", supplier.getSupplierId());
        assertEquals("Gardner", supplier.getName());
        assertEquals("Cape Town", supplier.getCity());
        assertEquals(library, supplier.getLibraryId());
        System.out.println("Test passed : Details are equal");

    }

    @Test
    @DisplayName("Test Creation of a new supplier with missing attributes")
    public void copyDetailsShouldBeTheSame() {
        Supplier supplier = SupplierFactory.create("1","Gardner","Cape Town",library);
        Supplier supplierCopy = new Supplier().copy(supplier);

        library.setLocation("Gugulethu");
        assertEquals(
                supplier.getLibraryId().getLocation(),
                supplierCopy.getLibraryId().getLocation());
        System.out.println("Test passed : copy Details are equal");

    }





}
