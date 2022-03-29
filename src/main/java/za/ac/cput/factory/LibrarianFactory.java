package za.ac.cput.factory;

import za.ac.cput.entity.Librarian;
import za.ac.cput.entity.Manager;

public class LibrarianFactory {
    public static Librarian createLibrarian(long staffID, String firstName, String lastName, String homeAddress, long cellPhone, String librarianCode, String position, boolean Availability){
        Librarian newLibrarian = (Librarian) new Librarian
                .LibrarianBuilder()
                .setLibrarianCode(librarianCode)
                .setPosition(position)
                .setAvailability(Availability)
                .setStaffMember_ID(staffID)
                .setFirstName(firstName).
                setLastName(lastName).
                setHomeAddress(homeAddress).
                setCellPhone(cellPhone).
                build();
        return newLibrarian;
    }
}
