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
    @Id
    @Column(name = "clientGenderId")
    private String clientGenderId;

    @Id
    @Column(name = "clientId")
    private String clientId;

    @Id
    @Column(name = "genderId")
    private String genderId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "clientId",referencedColumnName = "clientId")
    private Client client;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "genderId",referencedColumnName = "genderId")
    private Gender gender;

    protected ClientGender() {
    }

    private ClientGender(Builder b){

        this.genderId = b.genderId;
        this.clientId = b.clientId;
    }


    public String getClientId() {
        return clientId;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public String toString(){
        return "ClientGender" + "clientId " + clientId + "\'" +
                "genderId" + genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientGender that)) return false;
        return clientId.equals(that.clientId) && genderId.equals(that.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, genderId);
    }

    public static class Builder{


        private String clientId;

        private String genderId;

        public Builder clientId(String clientId){

            this.clientId = clientId;
            return this;
        }

        public Builder genderId(String genderId){
            this.genderId = genderId;
            return this;
        }

        public Builder copy(ClientGender clientGender){
            this.genderId = clientGender.genderId;
            this.clientId= clientGender.clientId;
            return this;
        }

        public ClientGender build(){
            return new ClientGender(this);
        }
    }
}
