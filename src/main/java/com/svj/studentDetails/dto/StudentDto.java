package com.svj.studentDetails.dto;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

	private int studentId;
	@NotBlank
	private String firstName;	
	@NotBlank
	private String lastName;
	@Nonnull
	private LocalDate date;	
	@NotBlank
	private String gender;
	@NotBlank
	private String grade;
	@Size(min = 10, max=10)
	private String contactNo;
	@Email
	private String email;	
	@NotBlank
	private String address;	
	@NotBlank
	private String emergencyContact;

}
