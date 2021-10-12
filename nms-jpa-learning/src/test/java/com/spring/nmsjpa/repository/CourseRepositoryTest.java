package com.spring.nmsjpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourse(){
        System.out.println(courseRepository.findAll());
    }
}
