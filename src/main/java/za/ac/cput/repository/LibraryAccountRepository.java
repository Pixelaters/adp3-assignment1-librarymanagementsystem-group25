package za.ac.cput.repository;
/**
 * LibraryAccountRepository.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 01 April 2022
 */
import za.ac.cput.entity.LibraryAccount;
import java.util.HashSet;
import java.util.Set;

public class LibraryAccountRepository implements LibraryAccountRepositoryInterface {
    private static IRepository IR = null;

    private Set<LibraryAccount> lADB;

    private LibraryAccountRepository(){
        lADB = new HashSet<LibraryAccount>();

    }

    public static LibraryAccountRepository getInstance(){
        if (IR == null) {
            IR = new LibraryAccountRepository();
        }
        return (LibraryAccountRepository) IR;
    }

    @Override
    public LibraryAccount create(LibraryAccount la) {
        boolean success = lADB.add(la);
        if(!success)
        return null;
        return la;
    }

    @Override
    public LibraryAccount read(String accountID) {
        for (LibraryAccount la: lADB) {
            if(la.getAccount_ID().equals(accountID))
                return la;
        }
        return null;
    }

    @Override
    public LibraryAccount update(LibraryAccount la) {
        LibraryAccount oldLibraryAccount = read(la.getAccount_ID());
        if (oldLibraryAccount != null){
            lADB.remove(oldLibraryAccount);
            lADB.add(la);
            return la;

        }
        return null;
    }

    @Override
    public boolean delete(String accountID) {
        LibraryAccount deleteLibraryAccount = read(accountID);
        if (deleteLibraryAccount == null)
            return false;
        lADB.remove(deleteLibraryAccount);
        return true;
    }



    @Override
    public Set<LibraryAccount> getAll() {
        return lADB;
    }
}
