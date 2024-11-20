package com.svj.studentDetails.serviceTest;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.svj.studentDetails.Arguments.StudentArgument;
import com.svj.studentDetails.Arguments.StudentUpdateArgument;
import com.svj.studentDetails.customException.ResourceNotFoundException;
import com.svj.studentDetails.dto.StudentDto;
import com.svj.studentDetails.service.IStudentService;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	IStudentService studentService;
	
	
	@ParameterizedTest
	@ValueSource(ints = {3,5,6})
	void getStudentByIdTest(int id) throws ResourceNotFoundException{
	
		StudentDto studentDto = studentService.getStudentById(id);
		
		assertNotNull(studentDto);
		
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = {-1,0,25,65})
	void getStudentByIdTestException(int id){
	
	assertThatExceptionOfType(ResourceNotFoundException.class).isThrownBy(()->studentService.getStudentById(id));

	}
	
	@Disabled
	@ParameterizedTest
	@ArgumentsSource(StudentArgument.class)
	void addStudentTest(StudentDto studentDto){
	//student add test done
		StudentDto studentDto1 = studentService.addStudent(studentDto);
		
		assertNotNull(studentDto1);
	}
	
	@Test
	void addStudentTest(){
		//student add test done
		StudentDto s1=StudentDto.builder().firstName("John").lastName("Doe").email("john.doe@example1.com").contactNo("9876543210").address("123 Maple St, Pune").date(LocalDate.parse("2005-09-12")).gender("M").grade("10").emergencyContact("Mr. Doe - 9123456789").build();
			
		StudentDto studentDto = studentService.addStudent(s1);
			assertNotNull(studentDto);
		}
	
	
	@ParameterizedTest
	@ArgumentsSource(StudentArgument.class)
	void addStudentTestExceptiono(StudentDto studentDto){
	
		assertThatExceptionOfType(Exception.class).isThrownBy(()-> studentService.addStudent(studentDto));
	}
	
	
	@ParameterizedTest
	@ArgumentsSource(StudentUpdateArgument.class)
	void updateStudentTest(StudentDto studentDto) throws ResourceNotFoundException{
	
		StudentDto updateStudent = studentService.updateStudent(studentDto, studentDto.getStudentId());
		
		assertNotNull(updateStudent);
		
	}
	
	@Test
	void updateStudentExceptionTest(){
		
		StudentDto s1=StudentDto.builder().studentId(29).firstName("John").lastName("Doe").email("john.doe@example.com").contactNo("9876543210").address("123 Maple St, Pune").date(LocalDate.parse("2005-09-12")).gender("M").grade("10").emergencyContact("Mr. Doe - 9123456789").build();

		assertThatExceptionOfType(ResourceNotFoundException.class).isThrownBy(()->	 studentService.updateStudent(s1, s1.getStudentId()));
	
	}
	
	
	@Test
	void deleteStudentExceptionTest(){
		
		assertThatExceptionOfType(ResourceNotFoundException.class).isThrownBy(()->	 studentService.removeStudent(9));
	
	}
	
	@Test
	void deleteStudentTest(){
		
	assertThatNoException().isThrownBy(()->studentService.removeStudent(39));
	
	}
	
}
