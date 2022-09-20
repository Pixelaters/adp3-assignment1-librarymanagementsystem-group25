package za.ac.cput.domain;


/*
 Name : Ethan George
 Student Number : 218008430
 Project: Library Management
 Date : 2022/08/08
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Gender implements Serializable {

    @Id
    @Column(name = "genderId")
    private String genderId;
    @NotNull
    private String name;
    @NotNull
    private String other;

    @OneToMany(mappedBy = "gender")
    private Set<ClientGender> clientGenderSet;

    protected Gender() {
    }

    private Gender(Builder b){

        this.genderId = b.genderId;
        this.other = b.other;
        this.name = b.name;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getOther() {
        return other;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Gender{" + "genderId" + genderId + '\'' + name +
                "other=" + other + '}' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender gender)) return false;
        return genderId.equals(gender.genderId) && name.equals(gender.name) && other.equals(gender.other) && clientGenderSet.equals(gender.clientGenderSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId, name, other, clientGenderSet);
    }

    public static class Builder{

        private String genderId;

        private String name;

        private String other;

        public Builder genderId(String genderId){
            this.genderId = genderId;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder other(String other){
            this.other = other;
            return this;
        }

        public Builder copy(Gender gender){
            this.genderId = gender.genderId;
            this.name = gender.name;
            this.other = gender.other;
            return this;
        }

        public Gender build(){
            return new Gender(this);
        }
    }
}
