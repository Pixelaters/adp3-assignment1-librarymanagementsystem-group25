package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.repository.CityIRepository;

@Service
public class CityService implements CityIService{

    private final CityIRepository cityIRepository;

    @Autowired
    public CityService(CityIRepository cityIRepository){
        this.cityIRepository = cityIRepository;

    }

    @Override
    public City create(City city) {
        return null;
    }

    @Override
    public City read(String s) {
        return null;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
