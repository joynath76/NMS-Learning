package com.spring.nmsjpa.repository;

import java.util.List;

import com.spring.nmsjpa.entity.Course;
import com.spring.nmsjpa.entity.Teacher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourceByTitle(String title){ 
        return courseRepository.findByTitle(title);
    }

    @Test
    public void saveTeacherData(){
        Teacher teacher = new Teacher(
            "Tarun",
            "Kumar"
        );
        teacherRepository.save(teacher);
    }
}
