package za.ac.cput.factory;

/*
Ongezwa Gwaza 211272183
08/08/2022
 */

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.Librarian;
import za.ac.cput.domain.Name;

public class LibrarianFactory {
    public static Librarian createLibrarian(String staffId, String position,String firstName,String middleName,String lastName){
        if (StringHelper.isEmptyorNull(staffId))
            throw new IllegalArgumentException();
        StringHelper.checkStringParam("position",position);
        Name name = NameFactory.createName(firstName,middleName,lastName);
        if(name == null)
            throw new IllegalArgumentException();

        return new Librarian.LibrarianBuilder().staffId(staffId).position(position).name(name).build();


    }
}
