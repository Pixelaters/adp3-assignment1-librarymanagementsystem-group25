package main.java.za.ac.cput.entity;
/**
 * Raeece Samuels (217283764)
 * ADP3 - Assignment1: Group 25
 * Date: 27 March 2022
 */
import java.util.Date;

public class Transaction {
    private String transaction_ID;
    private Date date;
    private String details;

    private Transaction(TransactionBuilder tb){
        this.transaction_ID = tb.transaction_ID;
        this.date = tb.date;
        this.details = tb.details;
    }

    public String getTransaction_ID() {
        return transaction_ID;
    }

    public void setTransaction_ID(String transaction_ID) {
        this.transaction_ID = transaction_ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_ID='" + transaction_ID + '\'' +
                ", date=" + date +
                ", details='" + details + '\'' +
                '}';
    }
    private static class TransactionBuilder{
        private String transaction_ID;
        private Date date;
        private String details;

        public TransactionBuilder setTransaction_ID(String transaction_ID) {
            this.transaction_ID = transaction_ID;
            return this;
        }

        public TransactionBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public TransactionBuilder setDetails(String details) {
            details = details;
            return this;
        }

        public TransactionBuilder copy(Transaction t){
            this.transaction_ID = t.transaction_ID;
            this.date = t.date;
            this.details = t.details;
            return this;
        }
        public Transaction build(){
            return new Transaction(this);
        }
    }


}
