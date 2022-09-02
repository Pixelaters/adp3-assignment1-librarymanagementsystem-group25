/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.factory;
import za.ac.cput.domain.LibrarianGender;
public class LibrarianGenderFactory {
    public static LibrarianGender createLibrariangender (String librarian , String gender) {
        if (librarian == null || gender == null) {
            throw new IllegalArgumentException("There should be no null value");
        }
        return new LibrarianGender.Builder().Gender(gender).Librarian(librarian).build();

    }

    }


