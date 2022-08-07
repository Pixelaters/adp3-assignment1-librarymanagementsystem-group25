package za.ac.cput.factory;

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Name;

public class NameFactory {

    public static Name createName(String firstName, String middleName, String lastName){
        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.setEmptyIfNull(middleName);
        StringHelper.checkStringParam("lastName",lastName);
        return new Name.Builder().FirstName(firstName).MiddleName(middleName).LastName(lastName).build();
    }

    public static Name createName(String firstName, String lastName){
        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.checkStringParam("lastName",lastName);
        return new Name.Builder().FirstName(firstName).LastName(lastName).build();
    }

}
