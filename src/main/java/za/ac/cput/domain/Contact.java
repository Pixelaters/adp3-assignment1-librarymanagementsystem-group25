package za.ac.cput.domain;

public class Contact {
    private String contactId;
    private String email;
    private String cell;
    private String nextOfKin;

    public Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.email = builder.email;
        this.cell = builder.cell;
        this.nextOfKin = builder.nextOfKin;
    }

    public String getContactId() {
        return contactId;
    }

    public String getEmail() {
        return email;
    }

    public String getCell() {
        return cell;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public static class Builder {
        private String contactId;
        private String email;
        private String cell;
        private String nextOfKin;

        public Builder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setCell(String cell) {
            this.cell = cell;
            return this;
        }

        public Builder setNextOfKin(String nextOfKin) {
            this.nextOfKin = nextOfKin;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
