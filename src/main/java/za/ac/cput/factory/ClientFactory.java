/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Client;
import za.ac.cput.domain.Name;

public class ClientFactory {

    public static Client builder(String id, Name name, boolean bookRented){

        if(id.isEmpty())
            throw new IllegalArgumentException("Id cannot be null");
        return new Client.Builder()
                .id(id)
                .name(name)
                .isRented(bookRented)
                .build();
        }

    }

