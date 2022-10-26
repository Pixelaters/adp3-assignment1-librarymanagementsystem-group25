package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Librarian;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.repository.LibrarianRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class LibrarianServiceTest {

    @Mock
    private LibrarianRepository librarianRepository;
    @Autowired
    LibrarianService librarianService;
    private static Librarian librarian1, librarian2;

    @BeforeEach
    void setUp(){
     librarianService = new LibrarianService(librarianRepository);
      librarian1 = new Librarian.LibrarianBuilder().staffId("123").position("246").name(NameFactory.createName("Ongezwa" ,"Ongie","Gwaza")).build();
      librarian2 = new Librarian.LibrarianBuilder().position("4444").copy(librarian1).build();
    }

    @Test
    void create() {
    librarianService.create(librarian1) ;
    assertNotNull(librarian1);
        System.out.println("saved successfully");

    }

    @Test
    void read() {
    librarianService.read(librarian1.getStaffId())  ;
     assertNotNull(librarian1);
        System.out.println(librarian1);

    }

    @Test
    void update() {
    librarianService.create(librarian2) ;

    assertNotSame(librarian1.getPosition(),librarian2.getPosition());
    assertSame("4444",librarian2.getPosition());
        System.out.println("updated");

    }

    @Test
    void delete() {
      librarianService.delete(librarian2.getPosition());
      assertAll(
              () -> Assertions.assertNotNull(librarian2),
              () ->assertSame("Ongezwa",librarian1.getName().getFirstName()),
              () -> assertSame("Ongie",librarian1.getName().getMiddleName()),
              () -> assertSame("Gwaza",librarian1.getName().getLastName())

      );
        System.out.println("deleted");

    }

    @Test
    void getAll() {

        System.out.println(librarianService.getAll());
        assertAll(
                () -> assertNotNull(librarianService.getAll())
        );
        System.out.println();
    }
}