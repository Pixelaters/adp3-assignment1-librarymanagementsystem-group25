package za.ac.cput.domain;

/*
 Name : Ethan George
 Student Number : 218008430
 Project: Library Management
 Date : 2022/08/08
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ClientGenderId.class)
public class ClientGender implements Serializable {
//    @Id
//    @Column(name = "clientGenderId")
//    private String clientGenderId;

//    @Id
//    @Column(name = "clientId")
//    private String clientId;
//
//    @Id
//    @Column(name = "genderId")
//    private String genderId;

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "clientId",referencedColumnName = "clientId")
    private Client client;

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "genderId",referencedColumnName = "genderId")
    private Gender gender;

    protected ClientGender() {
    }

    private ClientGender(Builder b){
        this.client = b.client;
        this.gender = b.gender;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ClientGender{" +
                "client=" + client +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientGender that)) return false;
        return client.equals(that.client) && gender.equals(that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, gender);
    }

    public static class Builder{
        private Client client;
        private Gender gender;

        public Builder Client(Client client){
            this.client = client;
            return this;
        }

        public Builder Gender(Gender gender){
            this.gender = gender;
            return this;
        }

        public Builder copy(ClientGender clientGender){
            this.client= clientGender.client;
            this.gender = clientGender.gender;
            return this;
        }

        public ClientGender build(){
            return new ClientGender(this);
        }
    }
}
