package com.svj.studentDetails.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.svj.studentDetails.customException.ResourceNotFoundException;
import com.svj.studentDetails.dto.StudentDto;
import com.svj.studentDetails.entity.Student;
import com.svj.studentDetails.repository.StudentRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService implements IStudentService{

	private final StudentRepo studentRepo;
	private final ModelMapper modelMapper;
	
	@Override
	public StudentDto getStudentById(int id) throws ResourceNotFoundException {
		
		Student student = studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not found"));
		
		return modelMapper.map(student, StudentDto.class);
	}

	@Override
	public StudentDto addStudent(StudentDto studentDto) {
		
		Student student=modelMapper.map(studentDto,Student.class);
		
		 studentRepo.save(student);
		
		return modelMapper.map(studentRepo.save(student),StudentDto.class);
	}

	@Override
	public void removeStudent(int id ) throws ResourceNotFoundException {
		
		Student student = studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not found"));

		studentRepo.delete(student);
		
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, int id) throws ResourceNotFoundException {
		
		Student student=studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not Found"));

		modelMapper.map(studentDto, student);

		return modelMapper.map(studentRepo.save(student),StudentDto.class);
			
	}


}
