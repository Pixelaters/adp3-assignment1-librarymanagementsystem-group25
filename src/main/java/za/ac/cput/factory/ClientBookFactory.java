package za.ac.cput.factory;

import za.ac.cput.domain.ClientBook;

public class ClientBookFactory {
    public static ClientBook createClientBook(String clientId,String bookId){
        if(clientId.isEmpty()||bookId.isEmpty())
            throw new IllegalArgumentException("Id's cannot be left empty");

            return new ClientBook.Builder()
                    .clientId(clientId)
                    .bookId(bookId)
                    .build();
        }
}
