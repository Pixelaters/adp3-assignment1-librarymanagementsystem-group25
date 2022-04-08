/*
* This is PrinterRepository.java class.
* Nondumiso Gaga (220430853)
* Date:06/04/2022


 */


package za.ac.cput.repository;

import za.ac.cput.entity.Printer;

import java.util.HashSet;
import java.util.Set;

public class PrinterRepository implements IPrinterRepository {

public static PrinterRepository repo = null;
private Set<Printer> printerDb = null;

private PrinterRepository(){printerDb = new HashSet<Printer>();
}

public static PrinterRepository getRepo(){
 if (repo == null)   {
     repo = new PrinterRepository();
 }
 return repo;
}

    @Override
    public Printer create(Printer printer) {
     boolean success = printerDb.add(printer);
     if(!success)
        return null;
        return printer;
    }

    @Override
    public Printer read( String printerCode) {

    Printer printer = printerDb.stream().filter(e -> e.getPrinterCode().
            equals(printerCode)).findAny().orElse(null);
            return printer;

    }



    @Override
    public Printer update(Printer printer) {
    Printer oldPrinter = read(printer.getPrinterCode());
    if(oldPrinter != null){
        printerDb.remove(oldPrinter);
        printerDb.add(printer);
        return printer;
    }
        return null;
    }



    @Override
    public boolean delete(String printerCode) {
    Printer deletePrinter = read(printerCode);
    if(deletePrinter== null)
        return false;
    printerDb.remove(deletePrinter);
    return true;
    }

    @Override
    public Set<Printer> getAll() {
        return printerDb;
    }
}
