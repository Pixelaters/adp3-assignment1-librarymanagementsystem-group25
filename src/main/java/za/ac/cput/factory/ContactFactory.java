package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Contact;

public class ContactFactory {
    public static Contact createContact(String contactId,String email, String cell, String nextOfKin){
        StringHelper.checkStringParam("contactId",contactId);
        StringHelper.checkEmail(email);
        StringHelper.checkStringParam("email", email);
        StringHelper.checkStringParam("cell",cell);
        StringHelper.checkStringParam("nextOfKin",nextOfKin);
        StringHelper.checkPhoneNumber(cell);
        StringHelper.checkPhoneNumber(nextOfKin);

        return new Contact.Builder().setContactId(contactId).setEmail(email).setCell(cell).setNextOfKin(nextOfKin).build();

    }
}
