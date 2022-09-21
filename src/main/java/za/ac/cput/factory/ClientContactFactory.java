/*
Nondumiso Gaga(220430853)
08/08/2022
 */
package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientContact;
import za.ac.cput.domain.Contact;

public class ClientContactFactory {

    public static ClientContact createContact(Client client, Contact contact){
        if(client ==  null || contact == null){
            throw new IllegalArgumentException("no null values");
        }
        return new ClientContact.Builder().Client(client).Contact(contact).build();

    }

}
