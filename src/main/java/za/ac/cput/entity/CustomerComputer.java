package za.ac.cput.entity;

public class CustomerComputer extends Computer {

    private String customerId;
    private String customerActivity;

    public CustomerComputer(String computerId, String customerId,String computerBrand, String computerStatus , String computerActivity) {
        super(computerId, computerBrand, computerStatus);

        this.customerId = customerId;
        this.customerActivity = customerActivity;

    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerActivity() {
        return customerActivity;
    }

    public void setCustomerActivity(String customerActivity) {
        this.customerActivity = customerActivity;
    }

    @Override
    public String toString() {
        return super.toString() + "Computer{" +
         "CustomerComputer{" +
                "customerId='" + customerId + '\'' +
                ", customerActivity='" + customerActivity + '\'' +
                '}';
    }




    public Computer build(){
        return new Computer(this);
    }

}
