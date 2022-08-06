/*
    Breyton Ernstzen (217203027)
    Applications Development
 */
package za.ac.cput.domain;

import java.util.Objects;

public class Client {
    private String id;
    private Name name;
    private boolean isRented;

    protected Client(){
        //empty constructor
    }

    private Client(Builder b){

    }

    public String getId() {
        return id;
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
                "id='" + id + '\'' +
                ", name=" + name +
                ", isRented=" + isRented +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
            this.id = c.id;
            this.name = c.name;
            this.isRented = c.isRented;
            return this;
        }

        public Client build(){
            return new Client(this);
        }
    }

}
