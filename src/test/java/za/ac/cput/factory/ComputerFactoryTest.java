package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Computer;

import static org.junit.jupiter.api.Assertions.*;


public class ComputerFactoryTest {

    @Test
    public void addComputerTest(){
        Computer computer = ComputerFactory.createComputer(  "9050","Lenovo" ,  "Healthy" );

        assertNotNull(computer);
        System.out.println("Computer added");


    }

    @Test
    public void showComputer(){
        Computer testViewComputer = ComputerFactory.createComputer( "9050","Lenovo" ,  "Healthy"  );
        System.out.println(testViewComputer.toString());
        assertNotNull(testViewComputer);
    }

    @Test
    public void testObjectIdentity(){

        Computer testViewComputer1 = ComputerFactory.createComputer( "9050","Lenovo" ,  "Healthy" );
        Computer testViewComputer2 = ComputerFactory.createComputer("9051","LG","Poor");
        Computer testViewComputer3 = testViewComputer1;

        assertSame(testViewComputer1,testViewComputer2);
        assertNotSame(testViewComputer2, testViewComputer3);
        assertNotSame(testViewComputer3, testViewComputer1);
        assertNotSame(testViewComputer1, testViewComputer2);
        System.out.println("Computers Updated");

    }

    @Test
    public void testObjectEquality(){

        Computer testViewComputer1 = ComputerFactory.createComputer("9050","Lenovo" ,  "Healthy" );
        Computer testViewComputer2 = ComputerFactory.createComputer("9051","LG","Poor");
        Computer testViewComputer3 = testViewComputer1;
        Computer testViewComputer4 = testViewComputer3;

        assertEquals(testViewComputer1,testViewComputer4);
        assertEquals(testViewComputer2,testViewComputer3);
        System.out.println("Computer Updated");

    }

    @Test

    public void fail(String message){
        System.out.println("Computer Not Found");
    }
}
