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
                263404840,211202101,"",true,false);

        assertEquals(student_a.getCustomerID(),student1.getCustomerID());
        assertSame(student1,student2);
        assertNotSame(student1,student3);
        assertNotNull(student_a);
        //assertNull(student_a); //fail test
        System.out.println("Student created...");
        System.out.println();

    }

    @Test
    void b_ReadCustomerTest(){
        Student showStudent = studentRepository.read(student_a.getCustomerID());
        Student showsStudent2 = showStudent;

        assertNotNull(showStudent);
        assertSame(showStudent,showsStudent2);
        assertEquals(student_a.getCustomerID(),showStudent.getCustomerID());

        System.out.println("Read from student list...");
        System.out.println(studentRepository.read(121));
        System.out.println();
    }

    @Test
    void c_UpdateStudentTest(){
        Student updateStudent1 = (Student) new Student.Builder().copy(student_a)
                .setCourse("App Development")
                .setAddress("Green ave")
                .build();
        Student identicalStudent = updateStudent1;

        assertNotNull(updateStudent1);
        assertNotNull(identicalStudent);
        assertSame(updateStudent1,identicalStudent);
        assertNotSame(student_a,updateStudent1);

        System.out.println("Student details has been updated...");
        System.out.println(studentRepository.update(updateStudent1));
        System.out.println();
    }

    @Test
    void e_DeleteStudentTest(){
        boolean success = StudentRepository.getInstance().delete(student_a.getCustomerID());
        assertNotNull(success);
        System.out.println("Delete success?: " + success);
        System.out.println();
    }

    @Test
    void d_getAllStudents(){
        System.out.println("Getting all...");
        System.out.println(studentRepository.getAll());
        System.out.println();
    }
}