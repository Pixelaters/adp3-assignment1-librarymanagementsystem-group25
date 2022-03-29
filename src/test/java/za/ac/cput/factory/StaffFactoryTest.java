package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Staff;

import static org.junit.jupiter.api.Assertions.*;

class StaffFactoryTest {
    @Test
    void CreateStaffTest1() {
        Staff staff = StaffFactory.addStaff(123123, "Ziyaad", "Petersen", "33 Michigan Way", 833806377);
        assertNotNull(staff);
        System.out.println("Staff added");
    }

    @Test
    void AddStaffTest2(){
        Staff staff = (Staff) new Staff.StaffBuilder()
                .setStaffMember_ID(23132)
                .setFirstName("Pixel")
                .setLastName("Laters")
                .build();
        assertNotNull(staff);
        System.out.println("Staff added");
    }

    @Test
    void ShowStaffDetails(){
        Staff staff = StaffFactory.addStaff(123123, "Ziyaad", "Petersen",
                "33 Michigan Way", 833806377);
        System.out.println(staff);
        assertNotNull(staff);
    }

    @Test
    void testObjectIdentity(){
        Staff staff0 = StaffFactory.addStaff(123123, "Ziyaad", "Petersen",
                "33 Michigan Way", 833806377);
        //same as staff0
        Staff staff1 = staff0;
        Staff staff2 = StaffFactory.addStaff(123123, "Raeece", "Breyton",
                "32 BergRivier", 831231231);
        assertSame(staff0, staff1);


        assertNotSame(staff0, staff2);
        System.out.println("test passed");
    }

    @Test
    void TestObjectEquality(){
        Staff staff0 = StaffFactory.addStaff(123123, "Ziyaad", "Petersen",
                "33 Michigan Way", 833806377);
        Staff staff1 = staff0;

        assertEquals(staff0,staff1);
    }

    @Test
    void fail(String failTest){

    }
}