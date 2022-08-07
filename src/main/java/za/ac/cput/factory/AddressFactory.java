package za.ac.cput.factory;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Factory: AddressFactory
 * Date: 2022/08/06
 * */


import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;

public class AddressFactory {
    public static Address createAddress(String unitNumber, String complexName, String streetNumber, String streetName, int postalCode, City city){
        StringHelper.setEmptyIfNull(unitNumber);
        StringHelper.setEmptyIfNull(complexName);
        StringHelper.checkStringParam("123",streetNumber);
        StringHelper.checkStringParam("",streetName);
        if (postalCode<999 || postalCode >9999){
            throw new IllegalArgumentException("Postal code must be 4 digits");
        }

        return new Address.AddressBuilder().unitNumber(unitNumber).complexName(complexName).streetNumber(streetNumber).streetName(streetName).postalCode(postalCode).City(city).build();
    }

}
