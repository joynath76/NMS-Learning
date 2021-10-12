package com.spring.nmsjpa.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_student",
	uniqueConstraints = @UniqueConstraint(
		name = "emailid_unique",
		columnNames = "email_address"
	)
)
public class Student {
	@Id
	@SequenceGenerator(
		name = "student_sequence",
		sequenceName = "student_sequence",
		allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "student_sequence"
	)
	private Long studentId;
	private String firstName;
	private String lastName;

	@Column(name = "email_address", nullable = false)
	private String emailId;

	@Embedded
	private Guardian guardian;

	
	public Student() {
	}

	public Student(String firstName, String lastName, String emailId, Guardian guardian) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.guardian = guardian;
	}

	@Override
	public String toString() {
		return "Student [emailId=" + emailId + ", firstName=" + firstName + ", guardian=" + guardian + ", lastName="
				+ lastName + ", studentId=" + studentId + "]";
	}	
	
	
}
