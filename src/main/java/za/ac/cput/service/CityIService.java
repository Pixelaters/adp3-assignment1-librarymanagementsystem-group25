package za.ac.cput.service;

import za.ac.cput.domain.City;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Set;

public interface CityIService  extends IService<City, String> {
    public List<City> getAll();

    public City findCityById(String id);
}
