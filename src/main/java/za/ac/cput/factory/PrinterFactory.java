/**

 * This is a PrinterFactory.java class implementing factory pattern, creating Printer objects.
 *Nondumiso Gaga (2204308543)
 * ADP Assignment1 term1 Group25
 * date:30/03/2022
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Printer;

public class PrinterFactory {
    public static Printer printerObjects(String printerCode,String brandName,String status,int libraryId ){
        return new Printer.Builder().setPrinterCode(printerCode).setBrandName(brandName)
                .setStatus(status).setLibraryId(libraryId).build();

}}
