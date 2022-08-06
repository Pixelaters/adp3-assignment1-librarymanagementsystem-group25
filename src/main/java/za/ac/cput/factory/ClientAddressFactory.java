/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.ClientAddress;

public class ClientAddressFactory {

    public static ClientAddress createClientAddress(String clientId, Address address){

        if(clientId.isEmpty())
            throw new IllegalArgumentException("Id cannot be null");
        return new ClientAddress.Builder()
                .clientId(clientId)
                .address(address)
                .build();
    }
}
