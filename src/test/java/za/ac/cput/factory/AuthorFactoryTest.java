package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;

import static org.junit.jupiter.api.Assertions.*;

class AuthorFactoryTest {
    private Author author1,author2;

    @BeforeEach
    void setUp(){
        author1 = AuthorFactory.createAuthor("123",
                NameFactory.createName("Dixon","Lee","Williams"));

        author2 = AuthorFactory.createAuthor("321",NameFactory.createName("Ziyaad","Petersen"));
    }

    @Test
    void authorWithMiddleName(){

        assertAll(
                () -> assertNotNull(author1.getName().getMiddleName()),
                () -> assertSame("Lee",author1.getName().getMiddleName()),
                () -> assertNotNull(author1)

        );

        System.out.println("Test successfully passed");
        System.out.println(author1.toString());
    }

    @Test
    void clientWithoutMiddleName(){

        assertAll(
                () -> assertNull(author2.getName().getMiddleName()),
                () -> assertNotSame("",author2.getName().getMiddleName())

        );
        System.out.println("Test successfully passed");
        System.out.println(author2.toString());
    }

    @Test
    void objectEquality(){

        assertAll(
                () -> assertNotEquals(author1.getAuthorId(),author2.getAuthorId()),
                () -> assertNotEquals(author1.getName().getMiddleName(),author2.getName().getMiddleName())
        );

        System.out.println("Test successfully passed");
    }

    @Test
    void objectIdentity(){

        assertAll(
                () -> assertNotSame(author1.getAuthorId(),author2.getAuthorId()),
                () -> assertNotSame(author1.getName().getMiddleName(),author2.getName().getMiddleName())

        );
    }
}