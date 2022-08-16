/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ClientAddress {
    @Id
    private String clientId;

    @Embedded
    private Address address;

    protected ClientAddress(){
        //empty constructor
    }
     private ClientAddress(Builder b){
        this.clientId = b.clientId;
        this.address = b.address;
     }

    public String getClientId() {
        return clientId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ClientAddress{" +
                "clientId='" + clientId + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientAddress that)) return false;
        return clientId.equals(that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    public static class Builder{
        private String clientId;
        private Address address;

        public Builder clientId(String id){
            this.clientId = id;
            return this;
        }

        public Builder address(Address address){
            this.address = address;
            return this;
        }

        public Builder copy(ClientAddress clientAddress){
            this.clientId = clientAddress.clientId;
            this.address = clientAddress.address;
            return this;
        }

        public ClientAddress build(){
            return new ClientAddress(this);
        }
    }
}
