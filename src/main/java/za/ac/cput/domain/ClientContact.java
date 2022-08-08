/*
Nondumiso Gaga(220430853)
08/08/2022
 */
package za.ac.cput.domain;



public class ClientContact {
    private String contactId;
    private String clientId;

    protected ClientContact(){

    }
    private ClientContact(ClientContact.Builder builder){
        this.contactId = builder.contactId;
        this.clientId = builder.clientId;
    }
    public String getContactId() {
        return contactId;
    }

    public String getLibrarianId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "LibrarianContact{" +
                "contactId='" + contactId + '\'' +
                ", librarianId='" + clientId + '\'' +
                '}';
    }
    public static class Builder{
        private String contactId;
        private String clientId;

        public ClientContact.Builder ContactId(String contactId) {

            this.contactId = contactId;
            return this;
        }

        public ClientContact.Builder ClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        public ClientContact.Builder Copy(ClientContact clientContact){
            this.contactId = contactId;
            this.clientId = clientId;
            return this;
        }
        public ClientContact createClientCont(){
            return new ClientContact(this);
        }


    }
}
