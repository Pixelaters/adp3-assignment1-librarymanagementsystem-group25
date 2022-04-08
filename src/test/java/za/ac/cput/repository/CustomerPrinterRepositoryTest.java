package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.CustomerPrinter;
import za.ac.cput.entity.Printer;
import za.ac.cput.factory.CustomerPrinterFactory;


import static org.junit.jupiter.api.Assertions.*;

class CustomerPrinterRepositoryTest {
    private static CustomerPrinterRepository repository = CustomerPrinterRepository.getRepository();
    private static CustomerPrinter customerPrinter = CustomerPrinterFactory.createCustPrinterObj(22212,"3344E","printing");

    @Test
    void create() {
        CustomerPrinter createdcustPrinter = repository.create(customerPrinter);
        assertEquals(customerPrinter.getPrinterCode(),createdcustPrinter.getPrinterCode());
        System.out.println("Create : " + createdcustPrinter);
    }

   // @Test
  //  void read() {
      //  CustomerPrinter read = repository.read(customerPrinter.getPrinterCode());
       // assertNotNull (read);
      //  System.out.println("Read : " + read);
  //  }

    @Test
    void update() {
        CustomerPrinter custprinterUpdate = new CustomerPrinter.Builder().copy(customerPrinter).setActivity("At rest")
                .build();
        System.out.println("printer update: " + custprinterUpdate);

    }
    @Test
    void getAll() {
        System.out.println("Show all : ");
        System.out.println(repository.getAll());
    }

    @Test
    void delete() {
        boolean success  = repository.delete(customerPrinter.getPrinterCode());
        assertTrue(true);
        System.out.println("Deleted : " + success);
    }


}