package com.spring.nmsjpa.repository;

import com.spring.nmsjpa.entity.Course;
import com.spring.nmsjpa.entity.CourseMaterial;
import com.spring.nmsjpa.entity.Teacher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = new Course("Data Structure Algorithm", 10, new Teacher("Baten", "Mollah"));
        CourseMaterial courseMaterial = new CourseMaterial("www.DSA.com", course);

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMatrial(){
        System.out.println(courseMaterialRepository.findAll());
    }
}
