package za.ac.cput.service;

import za.ac.cput.domain.Gender;

import java.util.List;

public interface GenderService extends IService<Gender , String> {
    List<Gender> getAll();
    Gender findGenderByGenderId(String genderId);
}
