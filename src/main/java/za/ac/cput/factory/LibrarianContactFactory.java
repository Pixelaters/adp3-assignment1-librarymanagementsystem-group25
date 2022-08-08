
/*
Nondumiso Gaga(220430853)
08/08/2022
 */
package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.LibrarianContact;

public class LibrarianContactFactory {

public static LibrarianContact createLibrariancontact(String contactId,String librarianId){
    StringHelper.checkStringParam("contactId",contactId);
    StringHelper.checkStringParam("librarianId",librarianId);

    return new LibrarianContact.Builder().ContactId(contactId).LibrarianId(librarianId).createLibrarianC();

}
}
