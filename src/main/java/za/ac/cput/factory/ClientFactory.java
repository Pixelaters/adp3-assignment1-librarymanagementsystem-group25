/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Book;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.Name;

public class ClientFactory {

    public static Client createClient(String id, Name name, boolean bookRented){

        if(id.isEmpty() || name.getFirstName().isEmpty() || name.getLastName().isEmpty())
            throw new IllegalArgumentException("Please complete all fields");

        return new Client.Builder()
                .id(id)
                .name(name)
                .isRented(bookRented)
                .build();
        }

    }

