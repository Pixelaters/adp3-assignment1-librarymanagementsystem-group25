package za.ac.cput.factory;



import za.ac.cput.entity.CustomerComputer;


public class CustomerComputerFactory {

    public static CustomerComputer createCustomerComputer(String computerId , String customerId , String activity , String id , String brandName , String status )
    {
        CustomerComputer newCustomerComputer = (CustomerComputer)  new CustomerComputer.Builder()

                .setComputerId(computerId)
                .setStatus(activity)
                .setComputerId(id)
                .setBrandName(brandName)
                .setStatus(status)

                .build();

        return newCustomerComputer;
    }
}
