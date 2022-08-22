package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.City;
import za.ac.cput.service.CityIService;

import javax.validation.Valid;
import java.util.List;

/*
 * Name: Raeece Samuels
 * Project: Library Management
 * Controller: CityController
 * Date: 2022/08/21
 * */
@RestController
@RequestMapping("librarymanagementsystem/cityController")
@Slf4j

public class CityController {

    private final CityIService cityIService;

    public CityController(CityIService cityIService){
        this.cityIService = cityIService;

    }

    @PostMapping("save_City")
    public ResponseEntity<City> create(@Valid @RequestBody City saveCity){
        log.info("Save Request: {}",saveCity);

        try{
            City city = this.cityIService.create(saveCity);
            return ResponseEntity.ok(city);
        }catch(IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());

        }

    }

    @GetMapping("readCity/{id}")
    public ResponseEntity<City> read(@PathVariable String id){
        log.info("Read request: {}",id);

        try{
            City getCity = this.cityIService.read(id);
            return ResponseEntity.ok(getCity);
        }catch(IllegalArgumentException exc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());
        }


    }

    @PostMapping("update_City")
    public ResponseEntity<City> update(@Valid @RequestBody City updateCity){
        log.info("Update request: {}",updateCity);

        try{
            City update = this.cityIService.update(updateCity);
            return ResponseEntity.ok(update);
        }catch(IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @DeleteMapping("deleteCity/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);

        this.cityIService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("getall")
    public ResponseEntity<List<City>> getAll(){
        List<City> cityList = cityIService.getAll();
        return ResponseEntity.ok(cityList);
    }

    @GetMapping("getCitiesById")
    public List<City> findCityById(String id){
        return cityIService.findCitiesById(id);
    }
    }

