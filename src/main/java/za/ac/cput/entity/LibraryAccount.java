package za.ac.cput.entity;
/**
 * LibraryAccount.java
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 27 March 2022
 */
public class LibraryAccount {
    private String account_ID;
    private String transaction_ID;
    private int customer_ID;

private LibraryAccount(LibraryAccountBuilder lab){
    this.account_ID = lab.account_ID;
    this.transaction_ID = lab.transaction_ID;
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

    public String getTransaction_ID()
    {
        return transaction_ID;
    }

    public void setTransaction_ID(String transaction_ID)
    {
        this.transaction_ID = transaction_ID;
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
                ", transaction='" + transaction_ID + '\'' +
                ", customer_ID=" + customer_ID +
                '}';
    }
    public static class LibraryAccountBuilder{
        private String account_ID;
        private String transaction_ID;
        private int customer_ID;

        public LibraryAccountBuilder setAccount_ID(String account_ID) {
            this.account_ID = account_ID;
            return this;
        }

        public LibraryAccountBuilder setTransaction_ID(String transaction_ID) {
            this.transaction_ID = transaction_ID;
            return this;
        }

        public LibraryAccountBuilder setCustomer_ID(int customer_ID) {
            this.customer_ID = customer_ID;
            return this;
        }

        public LibraryAccountBuilder copy(LibraryAccount la){
            this.account_ID = la.account_ID;
            this.transaction_ID = la.transaction_ID;
            this.customer_ID = la.customer_ID;
            return  this;
        }
        public LibraryAccount build(){
            return new LibraryAccount(this);
        }
    }


}





