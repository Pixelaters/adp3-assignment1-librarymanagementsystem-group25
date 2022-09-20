package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianGender;

import za.ac.cput.factory.GenderFactory;
import za.ac.cput.factory.LibrarianFactory;
import za.ac.cput.repository.LibrarianGenderRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class LibrarianGenderServiceTest {

    @Mock
    private LibrarianGenderRepository testLibrarianGenderRepository;
    LibrarianGenderService librariangenderService;
    private static LibrarianGender librarianGender, updatelibrarianGender;
    private static Librarian librarian;
    private static Gender gender;

    @BeforeAll
    static void initialiseTests(){
        librarian = LibrarianFactory.createLibrarian("5694","labrarian","Ongezwa","Ongie","Gwaza");
        gender = GenderFactory.createGender("f","female","girls and woman");
    }

    @BeforeEach
    void setUp() {
        librariangenderService = new LibrarianGenderService(testLibrarianGenderRepository);
        librarianGender = new LibrarianGender.Builder().Librarian(librarian).Gender(gender).build();
        Gender genderUpdate = GenderFactory.createGender("m","male","boys and man");

        updatelibrarianGender = new LibrarianGender.Builder().copy(librarianGender).Gender(genderUpdate).build();


    }

    @Test
    void a_create() {
        librariangenderService.create(librarianGender);
        assertNotNull(librarianGender);
        System.out.println("librarian gender  created successfully");
    }

    @Test
    void b_read() {
        librariangenderService.read(librarianGender.getGender().getGenderId());
        assertNotNull(librarianGender);
        System.out.println(librarianGender);
    }

    @Test
    void c_update() {

        librariangenderService.create(updatelibrarianGender);
        assertNotSame(librarianGender.getGender().getGenderId(), updatelibrarianGender.getGender().getGenderId());

        assertSame("m", librarianGender.getGender().getGenderId());
        System.out.println("genderid is updated");
        System.out.println(updatelibrarianGender.toString());


    }

    @Test
    void e_delete() {
        librariangenderService.delete(updatelibrarianGender.getGender().getGenderId());
        assertAll(
                () -> assertNotNull(updatelibrarianGender),
                () -> assertSame("5694", librarianGender.getLibrarian().getStaffId()),
                () -> assertSame("m", librarianGender.getGender().getGenderId())


        );

        System.out.println("updated");


    }

    @Test
    void getAll() {

        System.out.println(librariangenderService.getAll());
        assertAll(
                () -> assertNotNull(librariangenderService.getAll())

        );
        System.out.println();
    }
}