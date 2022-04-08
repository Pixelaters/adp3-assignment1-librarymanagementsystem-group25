
package za.ac.cput.repository;


import za.ac.cput.entity.Printer;

import java.util.Set;

public interface IPrinterRepository  extends IRepository<Printer, String> {

    public Set<Printer> getAll();
}
