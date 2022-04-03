package za.ac.cput.factory;
/*
    Breyton Ernstzen (217203027)
    ADP3 - Assignment 1: Group 25
    Date: 29 March 2022
 */
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Student;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    public void addStudentTest1(){
        Student newStudent = StudentFactory.createStudent(100,"Jane","Rice","Cat Ave",
                321654987, 217203027,"Accounting",false,true);

        System.out.println("Student added");
        assertNotNull(newStudent);
    }

    @Test
    public void addStudent2(){
        //adds a new student, but with some missing values
        Student newStudent = (Student) new Student.Builder()
                .setStudentNumber(12345789)
                .setUniversity(true)
                .setCustomerID(2)
                .setCustomerName("Ben")
                .setCustomerSurname("Welsh")
                .setAddress("Wonderland")
                .build();

        System.out.println("New student added!...");
        assertNotNull(newStudent);
       //assertNull(newStudent);//fail test

        Student newStudent1 = null;
        assertNull(newStudent1); //Object that is null

    }

    @Test
    public void showStudents(){
        Student newStudent = StudentFactory.createStudent(100,"Jane","Rice","Cat Ave",
                321654987, 217203027,"Accounting",false,true);

        System.out.println(newStudent);
        assertNotNull(newStudent);//pass test
        //assertNull(newStudent); //fail test
    }

    @Test
    //@Disabled
    public void testObjectIdentity(){
        //Test for object identity
        Student student1 = StudentFactory.createStudent(100,"Jane","Rice","Cat Ave",
                321654987, 217203027,"Accounting",false,true);
        Student student2 = StudentFactory.createStudent(101,"Tim","Dixon","Lalaland",
        246810121,219083479,"Marketing",false,true);
        Student student3 = student1;

        //assertSame(student1,student2); //failed test
        assertSame(student1,student3);
        assertSame(student1.getCustomerID(),student3.getCustomerID());
        assertSame(student1.getCustomerName(),student3.getCustomerName());
        assertSame(student1.getCustomerSurname(),student3.getCustomerSurname());
        assertSame(student1.getAddress(),student3.getAddress());
        assertSame(student3,student1);
        assertSame(student1.isHighSchool(),student2.isHighSchool());
        assertSame(student1.isUniversity(),student2.isUniversity());

        //assertNotSame(student1,student3);//failed test
        assertNotSame(student1.getCustomerID(),student2.getCustomerID());
        assertNotSame(student1.getCustomerName(),student2.getCustomerName());
        assertNotSame(student1.getCustomerSurname(),student2.getCustomerSurname());
        assertNotSame(student1.getAddress(),student2.getAddress());
        assertNotSame(student1.getCellNo(),student2.getCellNo());
        assertNotSame(student1.getStudentNumber(),student2.getStudentNumber());
        assertNotSame(student1,student2);
        assertNotSame(student2,student1);
        assertNotSame(student2,student3);
        assertNotSame(student3,student2);
        System.out.println("Test passed...");
    }

    @Test
    public void testObjectEquality(){
        Student student1 = StudentFactory.createStudent(100,"Jane","Rice","Cat Ave",
                321654987, 217203027,"Accounting",false,true);
        Student student2 = StudentFactory.createStudent(101,"Tim","Dixon","Lalaland",
                246810121,219083479,"Marketing",false,true);
        Student student3 = student1;
        Student student4 = student2;

        //assertEquals(student1,student2); //fail test
        assertEquals(student1,student3);
        assertEquals(student3,student1);
        assertEquals(student4,student2);
        assertEquals(student2,student4);

        assertNotEquals(student1.getCustomerID(),student2.getCustomerID());
        assertNotEquals(student1.getStudentNumber(),student2.getStudentNumber());
        assertNotEquals(student1.getCellNo(),student2.getCellNo());

        assertEquals(true,student1.isUniversity());
        //assertEquals(true,student1.isHighSchool()); //failed test
        assertEquals(false,student1.isHighSchool());
        //assertEquals(false,student1.isUniversity()); //failed test

        assertEquals(true,student2.isUniversity());
        //assertEquals(true,student2.isHighSchool()); //failed test
        assertEquals(false,student2.isHighSchool());
        //assertEquals(false,student2.isUniversity()); //failed test

        System.out.println("All tests passed...");
    }

}