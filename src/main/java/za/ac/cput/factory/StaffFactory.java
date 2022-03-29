package za.ac.cput.factory;

import za.ac.cput.entity.Staff;

import java.util.UUID;

public class StaffFactory {
    public static String generateStaffID(){ return UUID.randomUUID().toString();
    }

    public static Staff addStaff(long staffID, String firstName, String lastName, String homeAddress, long cellPhone){
        Staff newStaff = new Staff.StaffBuilder()
                .setStaffMember_ID(staffID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setHomeAddress(homeAddress)
                .setCellPhone(cellPhone)
                .build();
        return newStaff;
    }

}
