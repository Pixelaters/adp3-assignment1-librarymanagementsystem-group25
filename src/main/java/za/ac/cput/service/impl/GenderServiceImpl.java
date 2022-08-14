package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Gender;
import za.ac.cput.repository.GenderRepository;
import za.ac.cput.service.GenderService;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {


    private final GenderRepository genderRepository;

    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public Gender create(Gender gender){
        return this.genderRepository.save(gender);
    }

    @Override
    public Gender update(Gender gender){
        return this.genderRepository.save(gender);
    }

    @Override
    public Gender read(String id){
        return this.genderRepository.getReferenceById(id);
    }

    @Override
    public void delete(String id){
         this.genderRepository.deleteById(id);
    }

    @Override
    public List<Gender> getAll(){
        return this.genderRepository.findAll();
    }

    public Gender findGenderById(String genderId){
        return this.genderRepository.findGenderById(genderId);
    }
}
