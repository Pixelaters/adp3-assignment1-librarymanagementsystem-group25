package za.ac.cput.entity;


/*
   Ethan George (218008430)
   ADP3 - Assignment 1: Group 25
   Date: 28 March 2022
 */


public class CustomerComputer extends Computer {

    private String computerId;
    private Long customerId;
    private String activity;

    public CustomerComputer(Builder b) {
        super(b);
        this.computerId = b.computerId;
        this.customerId = b.customerId;
        this.activity = b.activity;


    }

    @Override
    public String getComputerId() {
        return computerId;
    }

    @Override
    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return super.toString() +  "CustomerComputer{" +
                "computerId='" + computerId + '\'' +
                ", customerId=" + customerId +
                ", activity='" + activity + '\'' +
                '}';
    }

    public static class Builder extends Computer.Builder{

        private String computerId;
        private Long customerId;
        private String activity;


        @Override
        public Computer.Builder setComputerId(String computerId) {
            this.computerId = computerId;
            return null;
        }

        public Builder setCustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setActivity(String activity) {
            this.activity = activity;
            return this;
        }

        public  Builder copy(CustomerComputer c){
            this.computerId = c.computerId;
            this.customerId = c.customerId;
            this.activity = c.activity;
            return this;

        }

        public CustomerComputer build(){
            return  new CustomerComputer(this );
        }
    }
}
