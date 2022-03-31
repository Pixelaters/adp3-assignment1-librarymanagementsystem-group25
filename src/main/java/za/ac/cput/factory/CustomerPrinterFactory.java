package za.ac.cput.factory;


/**
 * This is CustomerPrinterFactory.java file,
 * Nondumiso Gaga (220430853)
 * ADP Assignment1 term1 Group 25
 * date:30/03/2022
 */

import za.ac.cput.entity.CustomerPrinter;

public class CustomerPrinterFactory {
    public static CustomerPrinter createCustPrinterObj(int customerId, String printerCode,String activity){
        return new CustomerPrinter.Builder().setCustomerId(customerId).
                setPrinterCode(printerCode).setActivity(activity)
                .build();


    }}
