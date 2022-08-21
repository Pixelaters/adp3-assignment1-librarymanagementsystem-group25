package za.ac.cput.service.impl;
/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Service: CityService
 * Date: 2022/08/06
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.repository.CityIRepository;
import za.ac.cput.service.CityIService;

import java.util.List;

@Service
public class CityService implements CityIService {

    private final CityIRepository cityIRepository;

    @Autowired
    public CityService(CityIRepository cityIRepository){
        this.cityIRepository = cityIRepository;

    }

    @Override
    public City create(City city) {

        return this.cityIRepository.save(city);
    }

    @Override
    public City read(String id) {
        return this.cityIRepository.getReferenceById(id);

    }

    @Override
    public City update(City updatecity) {
        return this.cityIRepository.save(updatecity);
    }

    @Override
    public void delete(String id) {
        this.cityIRepository.deleteById(id);

    }

    @Override
    public List<City> getAll() {
        return this.cityIRepository.findAll();
    }

    @Override
    public City findCityById(String id) {
        return this.cityIRepository.findCityById(id);
    }
}
