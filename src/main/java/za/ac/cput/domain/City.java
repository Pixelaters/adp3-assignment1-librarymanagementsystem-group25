package za.ac.cput.domain;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Entity: City class
 * Date: 2022/08/06
 * */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class City implements Serializable {
    @Id
    private String id;
    private String name, suburb;

    City(CityBuilder cb){
        this.id=cb.id;
        this.name = cb.name;
        this.suburb = cb.suburb;
    }

    public City() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSuburb() {
        return suburb;
    }



    public static class CityBuilder{
        private String id, name, suburb;

        public CityBuilder Id(String id) {
            this.id = id;
            return this;
        }

        public CityBuilder Name(String name) {
            this.name = name;
            return this;
        }

        public CityBuilder Suburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        @Override
        public String toString() {
            return "CityBuilder{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", suburb='" + suburb + '\'' +
                    '}';
        }

        public CityBuilder copy(City c){
            this.id = c.id;
            this.name = c.name;
            this.suburb = c.suburb;
            return this;

        }

        public City build(){
            return new City(this);
        }
    }
}
