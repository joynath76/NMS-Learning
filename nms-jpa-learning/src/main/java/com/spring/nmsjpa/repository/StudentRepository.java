package com.spring.nmsjpa.repository;

import java.util.List;

import com.spring.nmsjpa.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    public List<Student> findByFirstName(String firstName);

    public Student findByEmailId(String emailId);

    public List<Student> findByFirstNameContains(String S);

    public List<Student> findByFirstNameStartingWith(String S);
    
    public List<Student> findByFirstNameEndingWith(String S);

    public List<Student> findByLastNameOrderByFirstName(String lastName);

    public List<Student> findByFirstNameAndLastNameAndEmailId(String firstName, String lastName, String emailId);

    //JPQL Query
    @Query("select s from Student s order by s.firstName desc")
    public List<Student> getAllStudentOrderByFirstName();

    @Query("select concat(s.firstName, ' ', s.lastName) from Student s")
    public List<String> getFullNameOfAllStudents();

    @Query("select concat(s.firstName, ' ', s.lastName) from Student s where s.emailId = ?1")
    public List<String> getFullNameOfStudentsByEmailId(String emailId);

    //Native Query
    @Query(
        value = "select concat(first_name, ' ', last_name) from tbl_student;",
        nativeQuery = true
    )
    public List<String> getFullNameOfAllStudentsByNativeQuery();

    //Native Query
    @Query(
        value = "select concat(first_name, ' ', last_name) from tbl_student s where s.email_address = :emailId",
        nativeQuery = true
    )
    public List<String> getFullNameOfStudentsByEmailIdNativeQueryParams(@Param("emailId") String emailID);

    @Modifying
    @Transactional
    @Query(
        value = "update Student s set s.firstName = ?1 where s.emailId = ?2"
    )
    public int updateFirstNameHavingEmailId(String firstName, String emailId);
}
