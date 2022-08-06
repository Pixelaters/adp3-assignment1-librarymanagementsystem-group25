package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.LibrarianAddress;

/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Factory: LibrarianAddressFactory
 * Date: 2022/08/06
 * */
public class LibrarianAddressFactory {
    public static LibrarianAddress build(String librarianId, Address address){
        StringHelper.checkStringParam("1234",librarianId);
        return new LibrarianAddress.LibrarianAddressBuilder().librarianId(librarianId).address(address).build();
    }
}
