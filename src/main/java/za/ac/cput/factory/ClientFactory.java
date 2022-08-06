/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Book;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.Name;

public class ClientFactory {

    public static Client createClient(String id, Name name, Book book, boolean bookRented){

        if(id.isEmpty() || name.getFirstName().isEmpty() || name.getLastName().isEmpty() || book.getBookName().isEmpty()
        || book.getAuthor().isEmpty() || book.getGenre().isEmpty())
            throw new IllegalArgumentException("Please complete all fields");

        return new Client.Builder()
                .id(id)
                .name(name)
                .book(book)
                .isRented(bookRented)
                .build();
        }

    }

