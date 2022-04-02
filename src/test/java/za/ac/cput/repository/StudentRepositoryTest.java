package za.ac.cput.repository;
/*
    Breyton Ernstzen (217203027)
    ADP 3 - Assignment 1: Group 25
    Date: 1 April 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class StudentRepositoryTest {
    private static StudentRepository studentRepository = StudentRepository.getInstance();
    private static Student student_a = StudentFactory.createStudent(121,"Breyton","Ernstzen",
            "Porterville",277135142,217203027,"Accounting",false,true);

    @Test
    void a_CreateStudentTest(){
        Student student1 = studentRepository.create(student_a);
        Student student2 = student1;
        Student student3 = StudentFactory.createStudent(174,"Sam","Sung","Nest street",
                263404840,211202101,null,true,false);

        assertEquals(student_a.getCustomerID(),student1.getCustomerID());
        assertSame(student_a.isHighSchool(),student1.isHighSchool());
        assertNotSame(student1.isUniversity(),student3.isUniversity());
        assertNotSame(student1.getStudentNumber(),student3.getStudentNumber());
        assertNotSame(student1.getCourse(),student3.getCourse());
        assertSame(student1,student2);
        assertNull(student3.getCourse());
        assertNotSame(student_a.getCustomerID(),student3.getCustomerID());
        assertNotSame(student1,student3);
        assertNotNull(student_a);
        assertNotNull(student1);
        assertNotNull(student2);
        assertNotNull(student3);
        //assertNull(student_a); //fail test
        System.out.println("Student created...");
        System.out.println();

    }

    @Test
    void b_ReadCustomerTest(){
        Student showStudent = studentRepository.read(student_a.getCustomerID());
        Student showsStudent2 = showStudent;
        Student student3 = StudentFactory.createStudent(174,"Sam","Sung","Nest street",
                263404840,211202101,"",true,false);

        assertNotNull(showStudent);
        assertNotNull(showsStudent2);
        assertSame(showStudent,showsStudent2);
        assertSame(student_a.getCustomerID(),showStudent.getCustomerID());
        assertNotSame(showStudent.getStudentNumber(),student3.getStudentNumber());
        assertNotSame(showStudent.getCustomerID(),student3.getCustomerID());
        assertEquals(student_a.getCustomerID(),showStudent.getCustomerID());

        System.out.println("Read from student list...");
        System.out.println(studentRepository.read(121));
        System.out.println();
    }

    @Test
    void c_UpdateStudentTest(){
        Student updateStudent1 = (Student) new Student.Builder().copy(student_a)
                .setStudentNumber(student_a.getStudentNumber())
                .setCourse("App Development")
                .setHighSchool(student_a.isHighSchool())
                .setUniversity(student_a.isUniversity())
                .setCustomerID(student_a.getCustomerID())
                .setCustomerName(student_a.getCustomerName())
                .setCustomerSurname(student_a.getCustomerSurname())
                .setAddress("Green ave")
                .setCellNo(student_a.getCellNo())
                .build();
        Student identicalStudent = updateStudent1;

        assertNotNull(updateStudent1);
        assertNotNull(identicalStudent);
        assertSame(updateStudent1,identicalStudent);
        assertNotSame(student_a,updateStudent1);
        assertNotSame(student_a.getCourse(),updateStudent1.getCourse());
        assertNotSame(student_a.getAddress(),updateStudent1.getAddress());
        assertEquals(student_a.getCustomerID(),updateStudent1.getCustomerID());

        System.out.println("Student details has been updated...");
        System.out.println(studentRepository.update(updateStudent1));
        System.out.println();
    }

    @Test
    void e_DeleteStudentTest(){
        boolean success = StudentRepository.getInstance().delete(student_a.getCustomerID());
        assertNotNull(success);
        assertNotSame(success,student_a);
        System.out.println("Delete success?: " + success);
        System.out.println();
    }

    @Test
    void d_getAllStudents(){
        System.out.println("Getting all...");
        assertNotNull(studentRepository.getAll());
        //assertNull(studentRepository.getAll()); //fails test
        System.out.println(studentRepository.getAll());
        System.out.println();
    }
}