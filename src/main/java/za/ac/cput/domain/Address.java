package za.ac.cput.domain;
/*
* Name: Raeece Samuels
* Project: Library Management
* Entity: Address class
* Date: 2022/08/06
* */

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

    @Size(min = 1,max = 5)
    private String unitNumber;

    @Size(min = 2,max = 20)
    private String complexName;

    @Size(min = 1,max = 4)
    @NotEmpty
    private String streetNumber;

    @Size(min = 2,max = 20)
    @NotEmpty
    private String streetName;

    @Size(min = 4,max = 4)
    @NotEmpty
    private int postalCode;

    @ManyToOne(targetEntity = City.class,cascade = CascadeType.ALL)
    private City city;

    public Address(AddressBuilder ab){
        this.unitNumber = ab.unitNumber;
        this.complexName = ab.complexName;
        this.streetNumber = ab.streetNumber;
        this.streetName = ab.streetName;
        this.postalCode = ab.postalCode;
        this.city = ab.city;


    }

    public Address() {

    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    public static class AddressBuilder {
        private String unitNumber, complexName, streetNumber, streetName;
        private int postalCode;
        private City city;

        public AddressBuilder unitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public AddressBuilder complexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public AddressBuilder streetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder postalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        public AddressBuilder City(City city){
            this.city = city;
            return this;
        }

       public AddressBuilder copy(Address a){
            this.unitNumber = a.unitNumber;
            this.complexName = a.complexName;
            this.streetNumber = a.streetNumber;
            this.streetName = a.streetName;
            this.postalCode = a.postalCode;
            this.city = a.city;
            return this;
       }

       public Address build(){
            return new Address(this);
       }
    }
}