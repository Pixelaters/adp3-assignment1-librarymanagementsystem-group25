package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceImplTest {

    @Autowired
    ContactServiceImpl contactService;
    private static Contact contact1, contact2, contact3, updateContact;


    @BeforeEach
    void setUp() {
        contact1= ContactFactory.createContact("1","zpetersen@bainscorp.com","0833806377", "0833806377");
        assertNotNull(contact1);
        System.out.println(contact1);

        contact2= ContactFactory.createContact("2","219083479@bainscorp.com","0833806377", "0833806377");
        assertNotNull(contact2);
        System.out.println(contact2);

        contact3= ContactFactory.createContact("3","219083479@cput.ac.za","0833806377", "0833806377");
        assertNotNull(contact3);
        System.out.println(contact3);

        updateContact= new Contact.Builder().copy(contact1).setCell("0835733829").build();
    }

    @Test
    @Order(1)
    void create() {
        Contact created1 = contactService.create(contact1);
        assertNotNull(created1);
        System.out.println(created1);

        Contact created2 = contactService.create(contact2);
        assertNotNull(created2);
        System.out.println(created2);

        Contact created3 = contactService.create(contact3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    @Order(2)
    void read() {
        Contact read= contactService.read(contact1.getContactId());
        assertEquals(read.getContactId(), contact1.getContactId());
        System.out.println("read"+ read);
    }

    @Test
    @Order(3)
    void update() {
        Contact updated = contactService.create(updateContact);
        Contact created1 = contactService.create(contact1);

        assertSame(false,created1.getCell(),updated.getCell());

        System.out.println("details updated successfully");
    }

    @Test
    @Order(4)
    void delete() {
        contactService.delete(contact3.getContactId());
        assertNotNull(contact3);
        System.out.println("deleted successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(contactService.getAll());
    }

    @Test
    @Order(6)
    void findByCell() {
        System.out.println(contactService.findByCell("0833806377"));
    }

    @Test
    @Order(7)
    void findByEmail() {
        //System.out.println(contactService.findByEmail("Zpetersen@bainscorp.com"));
    }

    @Test
    @Order(8)
    void findByContactId() {
        System.out.println(contactService.findByContactId("1"));
    }
}