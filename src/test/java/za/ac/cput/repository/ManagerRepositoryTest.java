package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Manager;
import za.ac.cput.factory.ManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
    ManagerRepositoryTest.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 26 April 2022
 */

public class ManagerRepositoryTest {
    private static final Manager accountA = ManagerFactory.createManager(111, "Ziyaad", "Petersen", "33 Michigan Way", 833806377,"214", true);

    @Test
    void aCreateStaffTest(){
        Manager st1 = ManagerRepository.getInstance().create(accountA);
        Manager st2 = st1;
        Manager accountB = ManagerFactory.createManager(112, "Breyton", "Raeece", "33 Avenue", 874592332, "213", true);

        assertEquals(accountA.getManagerCode(),st1.getManagerCode());
        System.out.println("test 1 is equal");
        assertNotSame(accountB.getManagerCode(),st1.getManagerCode());
        System.out.println("test 2 is same");
        assertNotSame(st1.getManagerCode(),accountB.getManagerCode());
        System.out.println("test 3 is not same");
        assertNotSame(st2.getHomeAddress(),accountB.getHomeAddress());
        System.out.println("test 4 is not same");
        assertSame(st1,st2);
        System.out.println("test 5 is same");
        //assertNotSame(st1,st2); fails
        //System.out.println("test 6 is not same");
        assertNotNull(accountA);
        System.out.println("test 7 is not null");
        assertNotNull(st2);
        System.out.println("test 8 is not null");
        assertNotNull(accountB);
        System.out.println("test 9 is not null");
        System.out.println("Manager Account/s has been added...");
        System.out.println();
    }

    @Test
    void bReadStaffTest(){
        Manager showst = ManagerRepository.getInstance().read(accountA.getManagerCode());
        Manager showst2 = showst;
        Manager showst3 = ManagerFactory.createManager(111, "Ziyaad", "Petersen", "33 Michigan Way", 833806377,"214",  true);

        assertNull(showst);
        System.out.println("test 1 passed");
        assertNotNull(showst3);
        assertNotSame(showst.getManagerCode(),showst3.getManagerCode());
        assertNotSame(showst,showst3);
        assertSame(showst.getManagerCode(),accountA.getManagerCode());
        assertSame(showst,showst2);
        assertEquals(accountA.getManagerCode(),showst.getManagerCode());


        System.out.println("Processing accounts...");
        System.out.println(ManagerRepository.getInstance().read("214"));
        System.out.println();
    }

    @Test
    void cUpdateStaffTest(){
        Manager updateSt1 = new Manager.ManagerBuilder().copy(accountA)
                .setManagerCode("212")
                .setAvailability(false)
                .build();

        assertNotNull(updateSt1);
        assertNotNull(updateSt1);
        assertSame(updateSt1, updateSt1);
        assertNotEquals(accountA.getManagerCode(),updateSt1.getManagerCode());
        assertNotSame(accountA,updateSt1);
        assertNotSame(accountA.getHomeAddress(),updateSt1.getHomeAddress());
        assertNotSame(accountA.getManagerCode(),updateSt1.getManagerCode());
        System.out.println("Library Account details updated...");
    }

    @Test
    void fDeleteStaffTest(){
        boolean success = ManagerRepository.getInstance().delete((accountA.getManagerCode()));
        assertNotNull(success);
        assertNotSame(accountA,success);
        System.out.println("Delete success? " + success);
        System.out.println();
    }

    @Test
    void d_getAllTest(){
        System.out.println("Getting all results: ");
        assertNotNull(ManagerRepository.getInstance().getAll());
        System.out.println(ManagerRepository.getInstance().getAll());
        System.out.println();
    }
}
