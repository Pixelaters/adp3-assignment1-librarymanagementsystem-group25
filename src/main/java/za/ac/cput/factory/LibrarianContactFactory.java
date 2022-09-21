
/*
Nondumiso Gaga(220430853)
08/08/2022
 */
package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.LibrarianContact;

public class LibrarianContactFactory {

public static LibrarianContact createContact(Librarian librarian, Contact contact){
  if(librarian == null || contact == null){
      throw new IllegalArgumentException("no null values");
  }
  return new LibrarianContact.Builder().Librarian(librarian).Contact(contact).build();
}
}
