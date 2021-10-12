package com.spring.nmsjpa.repository;

import java.util.List;

import com.spring.nmsjpa.entity.Guardian;
import com.spring.nmsjpa.entity.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithGuardian(){
    	Guardian guardian = new Guardian("Lankeswar Barman", "lankeswar.bar@gmail.com", "89756784677");
        Student student = new Student("Joynath","Barman", "joynath@gmail.com", guardian);
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("joynath");
        System.out.println(students);
    }

    @Test
    public void printStudentByEmailId(){
        Student student = studentRepository.findByEmailId("jogobarman");
        System.out.println(student);
    }

    @Test
    public void printStudentByFirstNameContains(){
        List<Student> students = studentRepository.findByFirstNameContains("jo");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameStartingWith(){
        List<Student> students = studentRepository.findByFirstNameStartingWith("jo");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameEndingWith(){
        List<Student> students = studentRepository.findByFirstNameEndingWith("go");
        System.out.println(students);
    }

    @Test
    public void printAllStudentByLastNameOrderByFirstName(){
        List<Student> students = studentRepository.findByLastNameOrderByFirstName("Barman");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameAndLastNameAndEmailId(){
        List<Student> students = studentRepository.findByFirstNameAndLastNameAndEmailId("jogo","Barman", "jogobarman@gmail.com");
        System.out.println(students);
    }

    @Test
    public void printAllStudentOrderByFirstName(){
        List<Student> students = studentRepository.getAllStudentOrderByFirstName();
        System.out.println(students);
    }

    @Test
    public void printFullNameOfAllStudents(){
        List<String> names = studentRepository.getFullNameOfAllStudents();
        System.out.println(names);
    }

    @Test
    public void printFullNameOfStudentsByEmailId(){
        List<String> names = studentRepository.getFullNameOfStudentsByEmailId("jogobarman@gmail.com");
        System.out.println(names);
    }

    @Test
    public void printFullNameOfAllStudentsByNativeQuery(){
        List<String> names = studentRepository.getFullNameOfAllStudentsByNativeQuery();
        System.out.println("Full Names = " + names);
    }

    @Test
    public void printFullNameOfStudentsByEmailIdNativeQueryParams(){
        List<String> names = studentRepository.getFullNameOfStudentsByEmailIdNativeQueryParams("jogobarman@gmail.com");
        System.out.println(names);
    }

    @Test
    public void updateFirstNameHavingEmailId(){
        studentRepository.updateFirstNameHavingEmailId("jogonath", "jogobarman@gmail.com");
    }
}
