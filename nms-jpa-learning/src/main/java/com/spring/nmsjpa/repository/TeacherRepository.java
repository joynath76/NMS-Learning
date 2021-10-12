package com.spring.nmsjpa.repository;

import com.spring.nmsjpa.entity.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
