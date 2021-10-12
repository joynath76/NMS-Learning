package com.spring.nmsjpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Course {
    @Id
    @SequenceGenerator(
        name = "course_sequence",
        sequenceName = "course_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_sequence"
    )
    private long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
        mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    private Teacher teacher;

    public Course() {
    }

    public Course(String title, Integer credit, Teacher teacher) {
        this.title = title;
        this.credit = credit;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseMaterial=" + courseMaterial + ", credit=" + credit
                + ", teacher=" + teacher + ", title=" + title + "]";
    }
    

}
