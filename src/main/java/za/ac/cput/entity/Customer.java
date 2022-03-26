package za.ac.cput.entity;
/*
   Breyton Ernstzen (217203027)
   Date: 26 March 2022
 */
public class Customer {
    private int customerID;
    private String customerName;
    private String customerSurname;
    private String address;
    private long cellNo;

    //Private constructor comes here
    private Customer(Builder b){
        this.customerID = b.customerID;
        this.customerName = b.customerName;
        this.customerSurname = b.customerSurname;
        this.address = b.address;
        this.cellNo = b.cellNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCellNo() {
        return cellNo;
    }

    public void setCellNo(long cellNo) {
        this.cellNo = cellNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", address='" + address + '\'' +
                ", cellNo=" + cellNo +
                '}';
    }

    public static class Builder{
        private int customerID;
        private String customerName;
        private String customerSurname;
        private String address;
        private long cellNo;

        public Builder setCustomerID(int customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setCustomerSurname(String customerSurname) {
            this.customerSurname = customerSurname;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCellNo(long cellNo) {
            this.cellNo = cellNo;
            return this;
        }

        public Builder copy(Customer c){
            this.customerID = c.customerID;
            this.customerName = c.customerName;
            this.customerSurname = c.customerSurname;
            this.address = c.address;
            this.cellNo = c.cellNo;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
