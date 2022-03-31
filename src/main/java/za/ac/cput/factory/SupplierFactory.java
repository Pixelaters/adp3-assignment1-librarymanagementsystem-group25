package za.ac.cput.factory;

/* SupplierFactory.java
Factory class for the Supplier
Author: Ongezwa Gwaza (211272183)
Date: 31 March 2022
*/

import za.ac.cput.entity.Library;
import za.ac.cput.entity.Student;
import za.ac.cput.entity.Supplier;

public class SupplierFactory {
    public static Supplier create(String supplierId, String name, String city, Library library){

        Supplier supplier =  new Supplier.SupplierBuilder(supplierId)
                .nameOfSupplier(name)
                .cityWhereSupplierIsLocated(city)
                .library(library)
                .build();

        return supplier;
    }
}
