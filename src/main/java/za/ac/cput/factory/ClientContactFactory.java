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

    public static ClientContact createClientcontact(String clientContactId, Client client, Contact contact){

        if(client.getClientId().isEmpty() || contact.getContactId().isEmpty() || clientContactId.isEmpty())
            throw new IllegalArgumentException("Bridging table requires keys from both Client table and contact table");

        return ClientContact.builder()
                .clientContactId(clientContactId)
                .contact(contact)
                .client(client)
                .build();
    }

}
