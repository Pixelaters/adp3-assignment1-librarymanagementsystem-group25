/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.ClientAddress;

public class ClientAddressFactory {

    public static ClientAddress createClientAddress(String clientId, Address address){

        if(clientId.isEmpty() || address.getStreetName().isEmpty() || address.getCity().getSuburb().isEmpty())
            throw new IllegalArgumentException("Please complete all fields");

        return new ClientAddress.Builder()
                .clientId(clientId)
                .address(address)
                .build();
    }
}
