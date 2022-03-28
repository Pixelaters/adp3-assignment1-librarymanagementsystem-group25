package main.java.za.ac.cput.account;
/**
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 27 March 2022
 */
public class LibraryAccount {
    private String account_ID;
    private String transaction;
    private int customer_ID;

private LibraryAccount(LibraryAccountBuilder lab){
    this.account_ID = lab.account_ID;
    this.transaction = lab.transaction;
    this.customer_ID = lab.customer_ID;
}

    public String getAccount_ID()
    {
        return account_ID;
    }

    public void setAccount_ID(String account_ID)
    {
        this.account_ID = account_ID;
    }

    public String getTransaction()
    {
        return transaction;
    }

    public void setTransaction(String transaction)
    {
        this.transaction = transaction;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    @Override
    public String toString() {
        return "LibraryAccount{" +
                "account_ID='" + account_ID + '\'' +
                ", transaction='" + transaction + '\'' +
                ", customer_ID=" + customer_ID +
                '}';
    }
    public static class LibraryAccountBuilder{
        private String account_ID;
        private String transaction;
        private int customer_ID;

        public LibraryAccountBuilder setAccount_ID(String account_ID) {
            this.account_ID = account_ID;
            return this;
        }

        public LibraryAccountBuilder setTransaction(String transaction) {
            this.transaction = transaction;
            return this;
        }

        public LibraryAccountBuilder setCustomer_ID(int customer_ID) {
            this.customer_ID = customer_ID;
            return this;
        }

        public LibraryAccountBuilder copy(LibraryAccount la){
            this.account_ID = la.account_ID;
            this.transaction = la.transaction;
            this.customer_ID = la.customer_ID;
            return  this;
        }
        public LibraryAccount build(){
            return new LibraryAccount(this);
        }
    }


}





