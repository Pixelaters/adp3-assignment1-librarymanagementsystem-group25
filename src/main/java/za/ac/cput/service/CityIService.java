package za.ac.cput.service;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Service: CityIService
 * Date: 2022/08/21
 * */
import za.ac.cput.domain.City;

import java.util.List;

public interface CityIService  extends IService<City, String> {
    public List<City> getAll();

    public List<City> findCitiesById(String id);
}
