//package za.ac.cput.controller;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import za.ac.cput.domain.ClientAddress;
//import za.ac.cput.domain.Librarian;
//import za.ac.cput.domain.LibrarianGender;
//import za.ac.cput.factory.*;
//
//import java.util.Arrays;
//import static org.junit.jupiter.api.Assertions.*;
//
//class LibrarianGenderControllerTest {
//
//    @LocalServerPort
//    private String portNumber;
//    @Autowired
//    private LibrarianGenderController librarianGenderController;
//    @Autowired private TestRestTemplate restTemplate;
//    private LibrarianGender librarianGender,updatedLibrarianGender;
//    private String urlBase;
//
//
//    @BeforeEach
//    void setUp() {
//       this.librarianGender = LibrarianGenderFactory.createLibrariangender("333","555");
//        this.updatedLibrarianGender = new LibrarianGender.Builder().Copy(librarianGender).LibrarianId("555").build();
//        this.urlBase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/librariangender/";
//
//    }
//
//    @Test
//    void create() {
//
//        String url = urlBase + "save_LibrarianGender";
//        System.out.println(url);
//
//        ResponseEntity<LibrarianGender> responseEntity = this.restTemplate
//                .postForEntity(url,this.librarianGender,LibrarianGender.class);
//        System.out.println(responseEntity);
//
//        assertAll(
//                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
//                () -> assertNotNull(responseEntity.getBody())
//        );
//
//        System.out.println("Librarian Address saved");
//
//    }
//
//    @Test
//    void read() {
//        String url = urlBase + "readLibrarianGender/" + librarianGender.getGenderId();
//        System.out.println(url);
//
//        ResponseEntity<LibrarianGender> responseEntity = this.restTemplate.getForEntity(url,LibrarianGender.class);
//        System.out.println(responseEntity);
//
//        assertAll(
//                () -> assertNotNull(responseEntity),
//                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
//                () -> assertNotNull(responseEntity.getBody())
//        );
//
//
//    }
//
//
//
//    @Test
//    void c_update() {
//        String url = urlBase + "update_LibrarianGender";
//        System.out.println(url);
//
//        ResponseEntity<LibrarianGender> responseEntity = this.restTemplate
//                .postForEntity(url,this.updatedLibrarianGender,LibrarianGender.class);
//
//        assertAll(
//                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
//                () -> assertNotNull(responseEntity.getBody())
//        );
//        System.out.println("Client address updated");
//    }
//
//    @Test
//    void delete() {
//        String url = urlBase + "deleteLibrarianGender/" + updatedLibrarianGender.getGenderId();
//        System.out.println(url);
//
//        this.restTemplate.delete(url);
//
//        assertAll(
//                () -> assertSame("555",updatedLibrarianGender.getGenderId())
//        );
//
//        System.out.println("Librarian Gender deleted");
//
//
//
//
//
//    }
//
//    @Test
//    void getAll() {
//        String url = urlBase + "getAll_LibrarianGender";
//        System.out.println(url);
//
//        ResponseEntity<LibrarianGender[]> responseEntity = this.restTemplate.getForEntity(url,LibrarianGender[].class);
//                System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));
//
//        assertAll(
//                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
//                () -> assertTrue(responseEntity.getBody().length == 0),
//                () -> assertNotNull(responseEntity)
//        );
//
//
//
//
//    }
//}