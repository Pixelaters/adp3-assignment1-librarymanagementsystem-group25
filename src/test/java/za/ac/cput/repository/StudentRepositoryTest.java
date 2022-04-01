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
}