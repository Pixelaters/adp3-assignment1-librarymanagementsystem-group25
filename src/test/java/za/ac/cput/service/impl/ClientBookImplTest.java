package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.ClientBook;
import za.ac.cput.factory.BookFactory;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.repository.BookIRepository;
import za.ac.cput.repository.ClientBookIRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ClientBookImplTest {

    @Mock
    private ClientBookIRepository clientBookIRepository;

    ClientBookImpl clientBookService;

    private static ClientBook clientBook,updateClientBook;

    @BeforeEach
    void setUp(){
        clientBookService = new ClientBookImpl(clientBookIRepository);

        clientBook = new ClientBook.Builder()
              .Client(ClientFactory.createClient("1", NameFactory.createName("Breyton","Sean","Ernstzen"),
                      true))
                      .Book (BookFactory.CreateBook("ZZ1","Finding Gobby","James Frank","fiction","description", "false", "https://something.jpg"))
                .build();

        updateClientBook = new ClientBook.Builder().copy(clientBook)
                .Client(ClientFactory.createClient(clientBook.getClient().getClientId(),
                                NameFactory.createName(clientBook.getClient().getName().getFirstName(),
                                        clientBook.getClient().getName().getMiddleName(),
                                        clientBook.getClient().getName().getLastName()),clientBook.getClient().isRented()))
                .Book(BookFactory.CreateBook("FS1","Frankenstein","Mark Shelley","Novel", "false", "description","https://something.jpg"))
                .build();
    }

    @Test
    void a_create(){
        clientBookService.create(clientBook);

        assertAll(
                () -> assertNotNull(clientBook),
                () -> assertSame("1",clientBook.getClient().getClientId()),
                () -> assertSame("ZZ1",clientBook.getBook().getBookId()),
                () -> assertSame(true,clientBook.getClient().isRented())
        );

        System.out.println("Client book saved!");
        System.out.println();
    }

    @Test
    void b_read(){
        clientBookService.read(clientBook.getClient().getClientId());

        assertAll(
                () -> assertNotNull(clientBook)
        );

        System.out.println(clientBook);
        System.out.println();
    }

    @Test
    void c_update(){
        clientBookService.update(updateClientBook);

        assertAll(
                () -> assertNotSame(clientBook.getBook().getBookId(),updateClientBook.getBook().getBookId()),
                () -> assertNotSame(clientBook.getBook().getBookName(),updateClientBook.getBook().getBookName()),
                () -> assertNotSame(clientBook.getBook().getAuthor(),updateClientBook.getBook().getAuthor()),
                () -> assertNotSame(clientBook.getBook().getGenre(),updateClientBook.getBook().getGenre())
        );

        System.out.println("Client book details updated");
        System.out.printf(updateClientBook.toString());
        System.out.println();
    }

    @Test
    void d_delete(){
        clientBookService.delete(updateClientBook.getClient().getClientId());

        assertAll(
                () -> assertNotNull(updateClientBook)
        );

        System.out.println("Client book deleted");
        System.out.println();
    }

    @Test
    void e_getAll(){
        clientBookService.getAll();

        assertAll(
                () -> assertNotNull(clientBookService.getAll())
        );

        System.out.println(clientBookService.getAll());
        System.out.println();
    }

    @Test
    void f_findClientBooksByClientId(){

        assertAll(
                () -> assertNotNull(clientBook)
        );

        System.out.println(clientBookService.findClientBookByClient(updateClientBook.getClient()));

    }
}