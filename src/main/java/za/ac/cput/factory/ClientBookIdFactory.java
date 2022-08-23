package za.ac.cput.factory;

import za.ac.cput.domain.Book;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBookId;

public class ClientBookIdFactory {

    public static ClientBookId createClientBookId(Client client, Book book){
        if (client == null || book == null){
            throw new IllegalArgumentException("there should be no null values");
        }
        return new ClientBookId();
    }
}
