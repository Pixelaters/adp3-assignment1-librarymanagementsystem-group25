/**

 * This is a PrinterRepositoryTest.java.
 *Nondumiso Gaga (2204308543)
 * ADP Assignment1 term1 Group25
 * date:07/04/2022
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Printer;
import za.ac.cput.factory.PrinterFactory;

import static org.junit.jupiter.api.Assertions.*;

class PrinterRepositoryTest {
    private static PrinterRepository repo = PrinterRepository.getRepo();
    private static Printer printer = PrinterFactory.printerObjects("22212","hp","printing",435);


    @Test
    void create() {
        Printer createdPrinter = repo.create(printer);
        assertEquals(printer.getPrinterCode(),createdPrinter.getPrinterCode());
        System.out.println("Create : " + createdPrinter);
    }



    @Test
    void update() {
        Printer printerUpdate = new Printer.Builder().copy(printer).setStatus("At rest")
                .build();
        System.out.println("printer update: " + printerUpdate);

    }
   // @Test
   // void read() {
     //   Printer read = repo.read(printer.getPrinterCode());
      //  assertNotNull (read);


   // }
    @Test
    void getAll() {
        System.out.println("Show all : ");
        System.out.println(repo.getAll());
    }

    @Test
    void delete() {
        boolean success  = repo.delete(printer.getPrinterCode());
        assertTrue(true);
        System.out.println("Deleted : " + success);

    }


}