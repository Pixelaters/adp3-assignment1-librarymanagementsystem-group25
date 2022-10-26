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
import za.ac.cput.factory.ClientBookFactory;
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

        clientBook = ClientBookFactory.createClientBook("123456789",ClientFactory.createClient("1010101010",
                        NameFactory.createName("Dennis","","Zakaria")),
                BookFactory.CreateBook("123","Finding Gobbie","Anne James","Dixon Rodrigues",
                        "John Smith","adventure","science","fiction","funf for kids",
                        "yes","https://myprofile.com"),"2022/10/26");

        updateClientBook = ClientBookFactory.createClientBook("246810322",ClientFactory.createClient("1010101010",
                        NameFactory.createName("Dennis","Edward","Zakaria")),
                BookFactory.CreateBook("123","Finding Gobbie","Anne James","Dixon Rodrigues",
                        "John Smith","adventure","science","fiction","funf for kids",
                        "yes","https://myprofile.com"),"2022/10/26");
    }

    @Test
    void a_create(){
        clientBookService.create(clientBook);

        assertSame("123456789",clientBook.getClientBookId());
        assertSame("1010101010",clientBook.getClients().getClientId());
        assertSame("123",clientBook.getBooks().getBookId());
        assertNotNull(clientBook);

    }

    @Test
    void b_read(){
        clientBookService.read(clientBook.getClientBookId());

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
                () -> assertNotSame(clientBook.getClientBookId(),updateClientBook.getClientBookId()),
                () -> assertNotSame("54646546",clientBook.getClients().getClientId()),
                () -> assertSame(clientBook.getClients().getClientId(),updateClientBook.getClients().getClientId())
        );

        System.out.println("Client book details updated");
        System.out.printf(updateClientBook.toString());
        System.out.println();
    }

    @Test
    void d_delete(){
        clientBookService.delete(updateClientBook.getClientBookId());

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
    }
}