package za.ac.cput.factory;

import za.ac.cput.domain.Author;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.Name;

public class AuthorFactory {

    public static Author createAuthor(String authorId, Name name){
        if(authorId.isEmpty() || name.getFirstName().isEmpty() || name.getLastName().isEmpty())
            throw new IllegalArgumentException("Please complete all fields");

        return Author.builder()
                .authorId(authorId)
                .name(name)
                .build();
    }

}

