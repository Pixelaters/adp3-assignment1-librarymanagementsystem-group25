/* Supplier.java
Entity for the Supplier
Author: Ongezwa Gwaza (211272183)
Date: 27 March 2022
*/
package za.ac.cput.entity;

public class Supplier {
    //    Attributes for the Supplier entity
    private String supplierId;
    private String name;
    private String city;

    /* Constructor for the supplier class
   which uses SupplierBuilder to instantiate fields
    */
    public Supplier(SupplierBuilder supplierBuilder) {
        this.supplierId = supplierBuilder.supplierId;
        this.name = supplierBuilder.name;
        this.city = supplierBuilder.city;
    }

    public Supplier copy(Supplier supplier){
        setSupplierId(supplier.getSupplierId());
        setName(supplier.getName());
        setCity(supplier.getCity());
        setLibraryId(supplier.getLibraryId());
        return this;
    }

    //    Getters and Setters for the Supplier attributes
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //    toString method used to convert object attributes to  string data type
    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    //    Builder class used to implement the Builder pattern

    public static class SupplierBuilder{
        //    Attributes to use in the Builder class
        private String supplierId;
        private String name;
        private String city;

        /* Constructor for the Supplier BuilderClass
           supplierId should be available on each object instantiation
        */
        public SupplierBuilder(String supplierId) {
            this.supplierId = supplierId;
        }


        public SupplierBuilder nameOfSupplier(String name){
            this.name = name;
            return this;
        }

        public SupplierBuilder cityWhereIsLocated(String city){
            this.city = city;
            return this;
        }

        // method for creating/building the instance of the supplier class
        public Supplier build(){
            Supplier supplier = new Supplier(this);
            return  supplier;
        }
    }
}
