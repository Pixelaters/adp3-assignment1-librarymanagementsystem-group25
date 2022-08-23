package za.ac.cput.factory;

import za.ac.cput.domain.Book;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBook;

public class ClientBookFactory {
    public static ClientBook createClientBook(Client client, Book book) {
        if (client == null || book == null){
            throw new IllegalArgumentException("there should be no null values");
        }
        return new ClientBook.Builder().Client(client).Book(book).build();

    }
}
