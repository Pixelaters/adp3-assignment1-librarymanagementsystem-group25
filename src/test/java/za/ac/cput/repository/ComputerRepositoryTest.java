package za.ac.cput.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Computer;



import za.ac.cput.factory.ComputerFactory;



import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
 class ComputerRepositoryTest {

    private static ComputerRepository computerRepository = ComputerRepository.getInstance();
    private static Computer computer_a = ComputerFactory.createComputer("9050","Lenovo" ,  "Healthy" );

    private static Computer computer_b = ComputerFactory.createComputer("9051","LG","Poor");

    @Test
   public void a_CreateComputerTest() {

        Computer newComputer1 = computerRepository.create(computer_a);
        Computer newComputer2 = computerRepository.create(computer_b);
        Computer newComputer3 = newComputer1;
       Computer newComputer4 = newComputer2;

        assertNotNull(newComputer1);
        assertNotNull(newComputer2);
        assertEquals(newComputer1,newComputer3);
        assertEquals(newComputer2,newComputer4);
        assertNotSame(computer_a,computer_b);
        assertSame(computer_a,newComputer1);
        assertSame(computer_b,newComputer2);
        assertSame(computer_a.isStatus() ,computer_b.isStatus());
        assertEquals(computer_a.isBrandName(),computer_b.isBrandName());

        System.out.println(" customer computer added...");
        System.out.println();
    }

    @Test
    void b_ReadComputerTest() {

        Computer readComputer = computerRepository.read(computer_a.getComputerId());
        Computer anotherComputer = readComputer;

        assertNotNull(readComputer);
        assertSame(computer_a,readComputer);
        assertSame(computer_a.isStatus() , readComputer.isStatus());
        assertSame(computer_a.isBrandName() , readComputer.isBrandName());
        assertNotSame(computer_b,readComputer);
        assertEquals(computer_a,readComputer);

        System.out.println("The Customer Computer Data is reading");
        System.out.println(computerRepository.read("9050"));
        System.out.println();

    }

    @Test
    void c_UpdateComputerTest() {

        Computer updateComputer = (Computer) new Computer.Builder()
                .setComputerId(computer_b.getComputerId())
                .setBrandName(computer_b.getBrandName())
                .setStatus(computer_b.getStatus())
                .build();


        assertNotNull(updateComputer);
        assertNotSame(computer_b,updateComputer);
        assertNotSame(computer_b.getComputerId() ,updateComputer.getComputerId());
        assertNotSame(computer_b.getBrandName() , updateComputer.getBrandName());
        assertNotSame(computer_b.getStatus() , updateComputer.getStatus());


        System.out.println(computer_b.getComputerId() + "Updated");
        System.out.println(computerRepository.update(updateComputer));
        System.out.println();


    }

    @Test
    void e_deleteComputer() {

        boolean success = ComputerRepository.getInstance().delete(computer_b.getComputerId());
        assertNotNull(success);

        System.out.println("Delete Success" + success);
        System.out.println();

    }

    @Test
    void d_getAllTest() {

        System.out.println("Getting all Computers");
        System.out.println(computerRepository.getAll()  );
        System.out.println();
    }
}
