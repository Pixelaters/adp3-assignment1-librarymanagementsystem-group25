/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Client implements Serializable {

    @Id
    @Column(name="clientId")
    private String clientId;
    @Embedded
    private Name name;

    @NotNull
    private boolean isRented;

    protected Client(){
        //empty constructor
    }

    private Client(Builder b){
        this.clientId = b.id;
        this.name = b.name;
        this.isRented = b.isRented;
    }

    public String getClientId() {
        return clientId;
    }

    public Name getName() {
        return name;
    }


    public boolean isRented() {
        return isRented;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + clientId + '\'' +
                ", name=" + name +
                ", isRented=" + isRented +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return clientId.equals(client.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    public static class Builder{
        private String id;
        private Name name;
        private boolean isRented;

        public Builder id(String id){
            this.id = id;
            return this;

        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder isRented(boolean isRented){
            this.isRented = isRented;
            return this;
        }

        public Builder copy(Client c){
            this.id = c.clientId;
            this.name = c.name;
            this.isRented = c.isRented;
            return this;
        }

        public Client build(){
            return new Client(this);
        }
    }

}
