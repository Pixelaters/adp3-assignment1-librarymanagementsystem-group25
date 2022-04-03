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

    //First checks to see if a repository is already created or not. If it is not created yet, then it creates one
    //Uses the singleton pattern
    public static StudentRepository getInstance(){

        if(studentRepository == null){
            studentRepository = new StudentRepository();
        }

        return studentRepository;
    }

    //adds a new student to the database
    @Override
    public Student create(Student addStudent) {
        boolean success = studentsDB.add(addStudent);

        if(!success)//if not a success then still add new customer
            return null;
        return addStudent;
    }

    @Override
    public Student read(Integer studentID) {

        //Loops through the student list, and check if student id match in the database
        for(Student student: studentsDB){
            if(student.getCustomerID() == studentID)
                return student;
        }
        return null;
    }

    @Override
    public Student update(Student updateStudent) {
        //first read from the database and see if the student id is there
        Student oldStudent = read(updateStudent.getCustomerID());

        if(oldStudent != null) {//if the customer data is not empty
            studentsDB.remove(oldStudent);//removes old customer data
            studentsDB.add(updateStudent);//replace it with the updated data
            return updateStudent;//updates customer data
        }
        return null;
    }

    @Override
    public boolean delete(Integer studentID) {
        Student deleteStudent = read(studentID);//read through the database

        if(deleteStudent == null)
            return false;
            studentsDB.remove(deleteStudent);//removes student
            return true;
    }

    @Override
    public Set<Student> getAll() {
        return studentsDB;
    }
}
