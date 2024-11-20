package com.svj.studentDetails.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Student Details")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Student ID")
	private int studentId;
	@Column(name="First Name")
	private String firstName;
	@Column(name="Last Name")
	private String lastName;
	@Column(name="Date of Birth")
	private LocalDate date;
	@Column(name="Gender")
	private String gender;
	@Column(name="Grade")
	private String grade;
	@Column(name="Contact Number")
	private String contactNo;
	@Column(name="Email Address", unique=true)
	private String email;
	@Column(name="Address")
	private String address;
	@Column(name="Emergency Contact")
	private String emergencyContact;

}
