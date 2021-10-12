package com.spring.nmsjpa.repository;

import com.spring.nmsjpa.entity.CourseMaterial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long>{
    
}
