package za.ac.cput.domain;

/*
 Name : Ethan George
 Student Number : 218008430
 Project: Library Management
 Date : 2022/08/08
 */

import java.util.Objects;

public class ClientGender {

    private String clientId;

    private String genderId;

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
    public int hashCode(){
        return Objects.hash(clientId);
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
