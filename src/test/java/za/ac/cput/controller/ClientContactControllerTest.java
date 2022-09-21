package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.ClientContact;
import za.ac.cput.factory.ClientContactFactory;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.NameFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientContactControllerTest {
    @LocalServerPort
    private String portNumber;
    @Autowired private ClientContactController clientContactController;
    @Autowired
    private TestRestTemplate restTemplate;

    private ClientContact clientContact,updateclientContact;
    private String urlbase;

  @BeforeEach
          void setUp(){
      assertNotNull(clientContactController);

      this.clientContact = ClientContactFactory.createContact(ClientFactory.createClient("4567",
              NameFactory.createName("Amala","","Dlamini"),true),
              ContactFactory.createContact("324","abzt@mail.com","0793458690","efgg"));

      this.urlbase = "http://localhost:" + this.portNumber + "/librarymanagementsystem/clientContact/";

    


  }

    @Test
    void create() {
      String url = urlbase +"save_clientContact";
        System.out.println(url);

        ResponseEntity<ClientContact> responseEntity  =this.restTemplate.postForEntity(url,this.clientContact,ClientContact.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
        System.out.println("client contact saved");

    }

    @Test
    void read() {
        String url = urlbase +"readClientcontact/" + clientContact.getClient().getClientId();
        System.out.println(url);

        ResponseEntity<ClientContact> responseEntity = this.restTemplate.getForEntity(url,ClientContact.class);

        assertAll(
               () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())

        );

    }

    @Test
    void update() {
      String url = urlbase + "update_ClientContact";
        System.out.println(url);
      ResponseEntity<ClientContact> responseEntity  = this.restTemplate.postForEntity(url,this.updateclientContact,ClientContact.class);

        System.out.println(responseEntity);

        assertAll(
                () -> assertNotNull(responseEntity),
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
        System.out.println("client contact updated ");
    }

    @Test
    void delete() {
        String url = urlbase +"delete_Clientcontact/" + updateclientContact.getClient().getClientId();
        System.out.println(url);
        this.restTemplate.delete(url);
        assertAll(

                () -> assertSame("345",updateclientContact.getClient().getClientId())

        );
        System.out.println("client contact deleted");
    }

    @Test
    void getAll() {
        String url = urlbase +"getClientcontact/";
        System.out.println(url);

        ResponseEntity<ClientContact[]> response = this.restTemplate.getForEntity(url,ClientContact[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertTrue(response.getBody().length==0),
                () -> assertNotNull(response)
                );


    }
}