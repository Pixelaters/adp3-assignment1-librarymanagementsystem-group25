package za.ac.cput.service;

import za.ac.cput.domain.Gender;

import java.util.List;

public interface GenderService extends IService<Gender , String> {


    Gender create(Gender gender);

    Gender update(Gender gender);

    public List<Gender> getAll();
}
