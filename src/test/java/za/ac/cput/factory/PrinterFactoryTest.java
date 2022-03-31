package za.ac.cput.factory;



import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Printer;

import static org.junit.jupiter.api.Assertions.*;

class PrinterFactoryTest {
    @Test
    public void Test(){

    Printer printer= PrinterFactory.printerObjects("2700","HP","printing",344);
    assertNotNull(printer);
}}