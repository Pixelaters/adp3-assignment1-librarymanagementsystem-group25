/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.factory;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianGender;
public class LibrarianGenderFactory {
    public static LibrarianGender createLibrariangender (Librarian librarian , Gender gender) {
        if (librarian == null || gender == null) {
            throw new IllegalArgumentException("There should be no null value");
        }
        return new LibrarianGender.Builder().Librarian(librarian).Gender(gender).build();

    }

    }


