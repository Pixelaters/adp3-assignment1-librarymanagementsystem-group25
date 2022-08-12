package za.ac.cput.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;


public class Name implements Serializable {
    private String firstName;
    private String middleName;
    private String lastName;

    protected Name(){

    }

    public Name(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder FirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder MiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder LastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Name name){
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.lastName= name.lastName;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }
}
