package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.City;
import za.ac.cput.repository.CityIRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.class)
class CityServiceTest {
    @Mock
    CityIRepository cityIRepository;

    @Autowired
    CityService cityService;

    private static City city1, updateCity1;

    @BeforeEach
    void setUp(){
        cityService = new CityService(cityIRepository);

        city1 = new City.CityBuilder().Id("2").Name("CPT").Suburb("Modderdam").build();

        updateCity1 = new City.CityBuilder().copy(city1).Suburb("Parow").build();
    }

    @Test
    void a_create() {
        cityService.create(city1);
        assertNotNull(city1);
        System.out.println(city1);
    }

    @Test
    void b_read() {
        cityService.read(city1.getId());

        assertNotNull(city1);
        System.out.println(city1);

    }

    @Test
    void c_update() {
        cityService.create(updateCity1);
        assertNotSame(city1.getSuburb(),updateCity1.getSuburb());
        System.out.println("Successfully updated details");
        System.out.println(updateCity1);
    }

    @Test
    void f_delete() {
        cityService.delete(updateCity1.getId());

        System.out.println("Successful deletion");
    }

    @Test
    void e_getAll() {
        System.out.println(cityService.getAll());
        assertNotNull(cityService.getAll());

        System.out.println("Found all entries");
    }

    @Test
    void d_findCityById() {
        cityService.findCityById("2");

        assertNotNull(updateCity1);
        System.out.println(cityService.findCityById("2"));
    }
}