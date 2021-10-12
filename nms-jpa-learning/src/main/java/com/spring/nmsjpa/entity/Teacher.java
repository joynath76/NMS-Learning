package com.spring.nmsjpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Teacher {
    @Id
    @SequenceGenerator(
        name = "teacher_sequence",
        sequenceName = "teacher_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "teacher_sequence"
    )
    private Long teacerId;
    private String firstName;
    private String lastName;


    public Teacher() {
    }

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Teacher [firstName=" + firstName + ", lastName=" + lastName + ", teacerId="
                + teacerId + "]";
    }

    
}
