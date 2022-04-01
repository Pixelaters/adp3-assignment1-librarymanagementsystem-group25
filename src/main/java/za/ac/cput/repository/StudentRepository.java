package za.ac.cput.repository;

import za.ac.cput.entity.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentRepository implements StudentRepositoryInterface{
    private static StudentRepository studentRepository = null;
    private Set<Student> studentsDB = null;

    private StudentRepository(){
        studentsDB = new HashSet<Student>();
    }

    public static StudentRepository getInstance(){

        if(studentRepository == null){
            studentRepository = new StudentRepository();
        }

        return studentRepository;
    }

    @Override
    public Student create(Student student) {
        return null;
    }

    @Override
    public Student read(Integer integer) {
        return null;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Set<Student> getAll() {
        return null;
    }
}
