package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Computer;

import static org.junit.jupiter.api.Assertions.*;


 class ComputerFactoryTest {

    @Test
    public void addComputerTest1(){


        Computer computer = ComputerFactory.createComputer(  "9050","Lenovo" ,  "Healthy" );

        assertNotNull(computer);
        System.out.println("Computer added");


    }

     @Test
     public void addComputerTest2(){

Computer computer = (Computer) new Computer.Builder()
        .setBrandName("LG")
        .setComputerId("123")
        .setStatus("Healthy")
        .build();

assertNotNull(computer);

Computer computer1 = null;
assertNotNull(computer1);

System.out.println("Computer added successfully");
     }

    @Test
    public void showComputer(){
        Computer computer = ComputerFactory.createComputer( "9050","Lenovo" ,  "Healthy"  );
        System.out.println(computer);
        assertNotNull(computer);
    }

    @Test
    public void testObjectIdentity(){

        Computer computer1 = ComputerFactory.createComputer( "9050","Lenovo" ,  "Healthy" );
        Computer computer2 = ComputerFactory.createComputer("9051","LG","Poor");
        Computer computer3 = computer1;

        assertSame(computer1,computer3);

        assertSame(computer1.getBrandName(),computer3.getBrandName());
        assertSame(computer1.getStatus() , computer3.getStatus());
        assertSame(computer1.getComputerId() , computer3.getComputerId());
        assertSame(computer3,computer1);

        assertNotSame(computer1.getBrandName() , computer2.getBrandName());
        assertNotSame(computer1.getComputerId(),computer2.getComputerId());
        assertNotSame(computer1.getStatus(),computer2.getStatus());


        System.out.println("Computers Updated");

    }

    @Test
    public void testObjectEquality(){

        Computer computer1 = ComputerFactory.createComputer("9050","Lenovo" ,  "Healthy" );
        Computer computer2 = ComputerFactory.createComputer("9051","LG","Poor");
        Computer computer3 = computer1;
        Computer computer4 =computer3;

        assertEquals(computer1.getComputerId(),computer3.getComputerId());
        assertEquals(computer1.getBrandName(),computer3.getBrandName());
        assertEquals(computer1.getStatus() , computer3.getStatus());


        assertNotEquals(computer1.getComputerId(),computer3.getComputerId());
        assertNotEquals(computer1.getBrandName(),computer3.getBrandName());
        assertNotEquals(computer1.getStatus() , computer3.getStatus());
        System.out.println("Computer Updated");

    }

    @Test

    public void fail(String message){
        System.out.println("Computer Not Found");
    }
}
