package com.svj.studentDetails.service;

import org.springframework.stereotype.Service;

import com.svj.studentDetails.customException.ResourceNotFoundException;
import com.svj.studentDetails.dto.StudentDto;

@Service
public interface IStudentService {
	
	public StudentDto getStudentById(int id) throws ResourceNotFoundException;
	public StudentDto addStudent(StudentDto studentDto);
	public StudentDto updateStudent(StudentDto studentDto, int id) throws ResourceNotFoundException;
	void removeStudent(int id) throws ResourceNotFoundException;

}
