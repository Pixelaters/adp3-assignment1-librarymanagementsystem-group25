package za.ac.cput.factory;

import za.ac.cput.entity.Manager;

/*
    ManagerFactory.java
    Ziyaad Petersen (219083479)
    ADP3 - Assignment 1: Group 25
    Date: 29 March 2022
 */

public class ManagerFactory {
    public static Manager createManager(long staffID, String firstName, String lastName, String homeAddress, long cellPhone, String managerCode, boolean Availability){
    Manager newManager = (Manager) new Manager
            .ManagerBuilder()
            .setManagerCode(managerCode)
            .setAvailability(Availability)
            .setStaffMember_ID(staffID)
            .setFirstName(firstName).
            setLastName(lastName).
            setHomeAddress(homeAddress).
            setCellPhone(cellPhone).
            build();
    return newManager;
    }
}
