package za.ac.cput.service;

import za.ac.cput.domain.Gender;

import java.util.List;

public interface GenderService {
    Gender create(Gender gender);

    Gender update(Gender gender);

    Gender read(String id);

    void delete(String id);

    List<Gender> getAll();
}
