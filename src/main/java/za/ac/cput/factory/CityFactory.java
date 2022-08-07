package za.ac.cput.factory;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Factory: CityFactory
 * Date: 2022/08/06
 * */

import za.ac.cput.Helper.StringHelper;
import za.ac.cput.domain.City;

public class CityFactory {
    public static City createCity(String id, String name, String suburb){
        if (id.isEmpty())
            throw new IllegalArgumentException("Id must have a value");
        StringHelper.checkStringParam("12345",id);
        StringHelper.checkStringParam("Cape Town",name);
        StringHelper.checkStringParam("Kuilsriver",suburb);
        return new City.CityBuilder().Id(id).Name(name).Suburb(suburb).build();

    }
}
