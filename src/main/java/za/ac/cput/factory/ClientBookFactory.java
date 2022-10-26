package za.ac.cput.factory;

import za.ac.cput.domain.Book;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBook;

public class ClientBookFactory {
    public static ClientBook createClientBook(String clientBookId, Client clientId, Book bookId, String dateOrdered) {
        if (clientBookId == null || clientId == null || bookId == null || dateOrdered == null){
            throw new IllegalArgumentException("there should be no null values");
        }
        return  ClientBook.builder().
                clientBookId(clientBookId).
                clients(clientId).
                books(bookId).
                dateOrdered(dateOrdered).
                build();

    }
}

