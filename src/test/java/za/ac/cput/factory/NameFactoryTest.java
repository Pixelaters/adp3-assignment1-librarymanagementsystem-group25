package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
    void createNameWithoutMiddleName() {
        Name name = NameFactory.createName("Ziyaad","Petersen");
        assertNotNull(name);
    }

    @Test
    void testCreateNameWithMiddleName() {
        Name name = NameFactory.createName("Ziyaad","something", "Petersen");
        assertNotNull(name);
        System.out.println(name);
    }

    @Test
    void failureWithoutFirstName(){
        Name name = NameFactory.createName("","something", "Petersen");
        assertNotNull(name);
        System.out.println(name);
    }

    @Test
    void failureWithoutLastName(){
        Name name = NameFactory.createName("Ziyaad","", "");
        assertNotNull(name);
        System.out.println(name);
    }

    @Test
    void failureWithoutAnyName(){
        Name name = NameFactory.createName("","","");
        assertNotNull(name);
        System.out.println(name);
    }
}