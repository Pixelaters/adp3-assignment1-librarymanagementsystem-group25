/*
Ongezwa Gwaza 211272183
08/08/2022
 */

package za.ac.cput.factory;
import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.LibrarianGender;
public class LibrarianGenderFactory {
    public static LibrarianGender createLibrariangender (String librarianId , String genderId){
        StringHelper.checkStringParam("librarianId", librarianId);
        StringHelper.checkStringParam("genderId", genderId);
        return new LibrarianGender.Builder().LibrarianId(librarianId).GenderId(genderId).createLibrarianG();
    }

}
