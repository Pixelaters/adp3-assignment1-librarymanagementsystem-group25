/*
 * This is ICustomerPrinterRepository.java class.
 * Nondumiso Gaga (220430853)
 * Date:06/04/2022


 */

package za.ac.cput.repository;

import za.ac.cput.entity.CustomerPrinter;
import za.ac.cput.entity.Printer;

import java.util.Set;

public interface ICustomerPrinterRepository extends IRepository<CustomerPrinter, String>{
    public Set<CustomerPrinter> getAll();
}
