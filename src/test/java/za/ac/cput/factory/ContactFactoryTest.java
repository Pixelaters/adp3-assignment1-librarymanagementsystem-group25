package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    @Test
    void createContact() {
        Contact contact= ContactFactory.createContact("ZP", "zpetersen@bainscorp.com", "0833830637", "0832831921");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void FailureTestcreateContactWithoutTenDigitNumber() {
        Contact contact= ContactFactory.createContact("ZP", "zpetersen@bainscorp.com", "083380637", "0832831921");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    void FailureTestcreateContactWithoutContactId() {
        Contact contact= ContactFactory.createContact("ZP", "zpetersen@bainscorp.com", "083380637", "0832831921");
        assertNotNull(contact);
        System.out.println(contact);
    }
}