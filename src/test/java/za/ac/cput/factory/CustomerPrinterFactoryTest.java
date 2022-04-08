/**

 * This is a CustomerPrinterFactoryTest.java class.
 *Nondumiso Gaga (2204308543)
 * ADP Assignment1 term1 Group25
 * date:07/04/2022
 */

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