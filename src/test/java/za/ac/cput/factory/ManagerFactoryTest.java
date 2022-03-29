package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Manager;

import static org.junit.jupiter.api.Assertions.*;

/*
    ManagerFactoryTest.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 29 March 2022
 */

class ManagerFactoryTest {

    @Test
    void CreateManagerTest1() {
        Manager manager = ManagerFactory.createManager(123123, "Ziyaad", "Petersen", "33 Michigan Way", 833806377, "A50", true );
        assertNotNull(manager);
        System.out.println("Manager added");
    }

    @Test
    void AddManagerTest2(){
        Manager manager = (Manager) new Manager.ManagerBuilder()
                .setStaffMember_ID(23132)
                .setFirstName("Pixel")
                .setLastName("Laters")
                .build();
        assertNotNull(manager);
        System.out.println("Manager added");
    }

    @Test
    void ShowManagerDetails(){
        Manager manager = ManagerFactory.createManager(123123, "Ziyaad", "Petersen",
                "33 Michigan Way", 833806377, "A50", true );
        System.out.println(manager);
        assertNotNull(manager);
    }

    @Test
    void testObjectIdentity(){
        Manager manager0 = ManagerFactory.createManager(123123, "Ziyaad", "Petersen",
                "33 Michigan Way", 833806377, "A50", true );
        //same as manager0
        Manager manager1 = manager0;
        Manager manager2 = ManagerFactory.createManager(123123, "Raeece", "Breyton",
                "32 BergRivier", 831231231, "J50", false);
        assertSame(manager0, manager1);


        assertNotSame(manager0, manager2);
        System.out.println("test passed");
    }

    @Test
    void TestObjectEquality(){
        Manager manager0 = ManagerFactory.createManager(123123, "Ziyaad", "Petersen",
                "33 Michigan Way", 833806377, "A50", true);
        Manager manager1 = manager0;

        assertEquals(manager0,manager1);
    }

    @Test
    void fail(String failTest){

    }
}