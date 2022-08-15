package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.ClientAddress;
import za.ac.cput.domain.LibrarianGender;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.repository.ClientAddressIRepository;
import za.ac.cput.repository.LibrarianGenderRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class LibrarianGenderServiceTest {

    @Mock
    private LibrarianGenderRepository testLibrarianGenderRepository;
    LibrarianGenderService librariangenderService;
    private static LibrarianGender librarian1, updatelibrarian1;

    @BeforeEach
    void setUp(){
        librariangenderService = new LibrarianGenderService(testLibrarianGenderRepository) ;
        librarian1 = new LibrarianGender.Builder().LibrarianId("999").GenderId("222").createLibrarianG();

        updatelibrarian1 =  new LibrarianGender.Builder().Copy(librarian1).GenderId("333").createLibrarianG();



    }

    @Test
    void a_create(){
    librariangenderService.create(librarian1);

            assertNotNull(librarian1);
        System.out.println("librarian gender  created successfully");







    }
    @Test
  void b_read(){
     librariangenderService.read(librarian1.getGenderId());
        assertNotNull(librarian1);
        System.out.println(librarian1);


    }
    @Test
    void c_update(){

    librariangenderService.create(updatelibrarian1) ;
    assertNotSame (librarian1.getGenderId(),updatelibrarian1.getGenderId());

    assertSame("333",librarian1.getGenderId());
        System.out.println("genderid is updated");
        System.out.println(updatelibrarian1.toString());


    }
    @Test
    void e_delete(){
   librariangenderService.delete(updatelibrarian1.getGenderId());
   assertAll(
           () ->assertNotNull(updatelibrarian1),
           () ->assertSame("999",librarian1.getLibrarianId()),
           () -> assertSame("333",librarian1.getGenderId())



   );

        System.out.println(librariangenderService.getAll());
        assertAll(
                ()  -> assertNotNull(librariangenderService.getAll())


        );

    }

}