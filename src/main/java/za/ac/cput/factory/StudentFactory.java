package za.ac.cput.factory;

import za.ac.cput.entity.Student;

public class StudentFactory {

    public static Student createStudent(int id,String name,String surname,String address,long cellNo,
                                     long studentNo,String course,boolean high_school,boolean university){

        Student newStudent = (Student) new Student.Builder()
                .setStudentNumber(studentNo)
                .setCourse(course)
                .setHighSchool(high_school)
                .setUniversity(university)
                .setCustomerID(id)
                .setCustomerName(name)
                .setCustomerSurname(surname)
                .setAddress(address)
                .setCellNo(cellNo)
                .build();

        return newStudent;
    }
}
