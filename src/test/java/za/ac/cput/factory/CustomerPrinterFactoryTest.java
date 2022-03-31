package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.CustomerPrinter;

import static org.junit.jupiter.api.Assertions.*;

class CustomerPrinterFactoryTest {

    @Test
    public void Test(){

        CustomerPrinter custPrinter = CustomerPrinterFactory.createCustPrinterObj(11001,"1033","Print");
        assertNotNull(custPrinter);


    }}