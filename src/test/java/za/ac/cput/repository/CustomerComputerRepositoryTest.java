package za.ac.cput.repository;




import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import za.ac.cput.entity.CustomerComputer;
import za.ac.cput.factory.CustomerComputerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
 class CustomerComputerRepositoryTest {

    private static CustomerComputerRepository customerComputerRepository = CustomerComputerRepository.getInstance();
    private static CustomerComputer customerComputer_a = CustomerComputerFactory.createCustomerComputer("1" ,  "451" , "Research" , "5" , "LG" , "Moderate");

    private static CustomerComputer customerComputer_b = CustomerComputerFactory.createCustomerComputer("2" ,  "452" , "Youtube" , "6" , "Samsung" , "Healthy");

    @Test
    void a_CreateCustomerComputerTest() {

       CustomerComputer newCustomerComputer1 = customerComputerRepository.create(customerComputer_a);
        CustomerComputer newCustomerComputer2 = customerComputerRepository.create(customerComputer_b);
        CustomerComputer newCustomerComputer3 = newCustomerComputer1;
        CustomerComputer newCustomerComputer4 = newCustomerComputer2;

        assertNotNull(newCustomerComputer1);
        assertNotNull(newCustomerComputer2);
        assertEquals(newCustomerComputer1,newCustomerComputer3);
        assertEquals(newCustomerComputer2,newCustomerComputer4);
        assertNotSame(customerComputer_a,customerComputer_b);
        assertSame(customerComputer_a,newCustomerComputer1);
        assertSame(customerComputer_b,newCustomerComputer2);
        assertSame(customerComputer_a.isActive(),customerComputer_b.isActive());
        assertEquals(customerComputer_a.isBrandName(),customerComputer_b.isBrandName());

        System.out.println(" customer computer added...");
        System.out.println();

    }

    @Test
    void b_ReadCustomerComputerTest() {

        CustomerComputer readCustomerComputer = customerComputerRepository.read(customerComputer_a.getComputerId());
        CustomerComputer anotherCustomerComputer = readCustomerComputer;

        assertNotNull(readCustomerComputer);
        assertSame(customerComputer_a,readCustomerComputer);
        assertSame(customerComputer_a.isActive() , readCustomerComputer.isActive());
        assertSame(customerComputer_a.isBrandName() , readCustomerComputer.isBrandName());
        assertNotSame(customerComputer_b,readCustomerComputer);
        assertEquals(customerComputer_a,readCustomerComputer);

        System.out.println("The Customer Computer Data is reading");
        System.out.println(customerComputerRepository.read("9050"));
        System.out.println();


    }

    @Test
    void c_UpdateCustomerComputerTest() {

        CustomerComputer updateCustomerComputer = (CustomerComputer) new CustomerComputer.Builder().copy(customerComputer_b)
                .setComputerId(customerComputer_b.getComputerId())
                .setBrandName(customerComputer_b.getBrandName())
                .setStatus(customerComputer_b.getStatus())
                .build();


        assertNotNull(updateCustomerComputer);
        assertNotSame(customerComputer_b,updateCustomerComputer);
        assertNotSame(customerComputer_b.getCustomerId() ,updateCustomerComputer.getCustomerId());
        assertNotSame(customerComputer_b.getBrandName() , updateCustomerComputer.getBrandName());
        assertNotSame(customerComputer_b.isActive() , updateCustomerComputer.isActive());
        assertNotSame(customerComputer_b.getCustomerId() , updateCustomerComputer.getCustomerId());

        System.out.println(customerComputer_b.getComputerId() + "Updated");
        System.out.println(customerComputerRepository.update(updateCustomerComputer));
        System.out.println();



    }

    @Test
    void e_deleteCustomerComputer() {

        boolean success = CustomerComputerRepository.getInstance().delete(customerComputer_b.getComputerId());
        assertNotNull(success);

        System.out.println("Delete Success" + success);
        System.out.println();

    }

    @Test
    void d_getAllTest() {

        System.out.println("Getting all Customer Computers");
        System.out.println(customerComputerRepository.getAll()  );
        System.out.println();
    }
}
