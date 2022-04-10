package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
    StaffRepositoryTest.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 26 April 2022
 */

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class StaffRepositoryTest {
    private static final Staff accountA = StaffFactory.addStaff(111, "Ziyaad", "Petersen", "33 Michigan Way", 833806377 );

    @Test
    void aCreateStaffTest(){
        Staff st1 = StaffRepository.getInstance().create(accountA);
        Staff st2 = st1;
        Staff accountB = StaffFactory.addStaff(112, "Breyton", "Raeece", "33 Avenue", 874592332 );

        assertEquals(accountA.getStaffMember_ID(),st1.getStaffMember_ID());
        System.out.println("test 1 is equal");
        assertNotSame(accountB.getStaffMember_ID(),st1.getStaffMember_ID());
        System.out.println("test 2 is same");
        assertNotSame(st1.getStaffMember_ID(),accountB.getStaffMember_ID());
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
        System.out.println("Staff Account/s has been added...");
        System.out.println();
    }

    @Test
    void bReadStaffTest(){
        Staff showst = StaffRepository.getInstance().read(accountA.getStaffMember_ID());
        Staff showst2 = showst;
        Staff showst3 = StaffFactory.addStaff(111, "Ziyaad", "Petersen", "33 Michigan Way", 833806377);

        assertNotNull(showst);
        System.out.println("test 1 passed");
        assertNotNull(showst3);
        System.out.println("test 2 passed");
        assertSame(showst.getStaffMember_ID(),showst3.getStaffMember_ID());
        System.out.println("test 3 passed");
        assertNotSame(showst,showst3);
        assertSame(showst.getStaffMember_ID(),accountA.getStaffMember_ID());
        assertSame(showst,showst2);
        assertEquals(accountA.getStaffMember_ID(),showst.getStaffMember_ID());


        System.out.println("Processing accounts...");
        System.out.println(StaffRepository.getInstance().read(111L));
        System.out.println();
    }

    @Test
    void cUpdateStaffTest(){
        Staff updateSt1 = new Staff.StaffBuilder().copy(accountA)
                .setStaffMember_ID(211L)
                .setCellPhone(219301938)
                .build();

        assertNotNull(updateSt1);
        assertNotNull(updateSt1);
        assertSame(updateSt1, updateSt1);
        assertNotEquals(accountA.getStaffMember_ID(),updateSt1.getStaffMember_ID());
        assertNotSame(accountA,updateSt1);
        assertSame(accountA.getHomeAddress(),updateSt1.getHomeAddress());
        assertNotSame(accountA.getStaffMember_ID(),updateSt1.getStaffMember_ID());
        System.out.println("Library Account details updated...");
    }

    @Test
    void fDeleteStaffTest(){
        boolean success = StaffRepository.getInstance().delete((accountA.getStaffMember_ID()));
        assertNotNull(success);
        assertNotSame(accountA,success);
        System.out.println("Delete success? " + success);
        System.out.println();
    }

    @Test
    void d_getAllTest(){
        System.out.println("Getting all results: ");
        assertNotNull(StaffRepository.getInstance().getAll());
        System.out.println(StaffRepository.getInstance().getAll());
        System.out.println();
    }
}
