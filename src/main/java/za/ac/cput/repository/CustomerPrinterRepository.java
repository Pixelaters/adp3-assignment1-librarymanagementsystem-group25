package za.ac.cput.repository;


import za.ac.cput.entity.CustomerPrinter;
import za.ac.cput.entity.Printer;


import java.util.HashSet;
import java.util.Set;

public class CustomerPrinterRepository implements ICustomerPrinterRepository {

    public static CustomerPrinterRepository repository = null;
    private Set<CustomerPrinter> custpDB = null;

    private CustomerPrinterRepository(){custpDB = new HashSet<CustomerPrinter>();
    }

    public static CustomerPrinterRepository getRepository(){
        if (repository == null)   {
            repository = new CustomerPrinterRepository();
        }
        return repository;
    }




    @Override
    public CustomerPrinter create(CustomerPrinter custPrinter) {
        boolean success = custpDB.add(custPrinter);
        if(!success)
            return null;
        return custPrinter;
   }


    @Override
    public CustomerPrinter read(String printerCode) {
       CustomerPrinter custPrinter = custpDB.stream().filter(e -> e.getPrinterCode().equals(printerCode)).findAny().orElse(null);
        return custPrinter;

    }

    @Override
    public CustomerPrinter update(CustomerPrinter custPrinter) {
        CustomerPrinter oldcustPrinter = read(custPrinter.getPrinterCode());
        if(oldcustPrinter != null){
            custpDB.remove(oldcustPrinter);
            custpDB.add(custPrinter);
            return custPrinter;
        }
        return null;
    }


    @Override
    public boolean delete(String printerCode) {
        CustomerPrinter deletecustPrinter = read(printerCode);
        if(deletecustPrinter== null)
            return false;
        custpDB.remove(deletecustPrinter);
        return true;
    }

    @Override
    public Set<CustomerPrinter> getAll() {
        return custpDB;
    }
}






