package za.ac.cput.domain;

import java.io.Serializable;
import java.util.Objects;

public class ClientGenderId implements Serializable {
    private Client client;
    private Gender gender;

    public ClientGenderId(){
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
        return "ClientGenderId{" +
                "client=" + client +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientGenderId that)) return false;
        return client.equals(that.client) && gender.equals(that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, gender);
    }
}
