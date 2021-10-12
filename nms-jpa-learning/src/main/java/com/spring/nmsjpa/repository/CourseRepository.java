package com.spring.nmsjpa.repository;

import java.util.List;

import com.spring.nmsjpa.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    public List<Course> findByTitle(String title);
}
