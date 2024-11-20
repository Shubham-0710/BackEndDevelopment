package com.svj.studentDetails.restController;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.svj.studentDetails.apiResponse.ApiResponse;
import com.svj.studentDetails.customException.ResourceNotFoundException;
import com.svj.studentDetails.dto.StudentDto;
import com.svj.studentDetails.service.IStudentService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/Student")
@RequiredArgsConstructor
public class StudentController {
	
	private final IStudentService studentService;
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<ApiResponse> getStudent(@PathVariable int id) throws ResourceNotFoundException {

			StudentDto studentDto = studentService.getStudentById(id);
			
			return ResponseEntity.ok(new ApiResponse("Student Found!!",studentDto));
	
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<ApiResponse> addStudent(@Valid @RequestBody StudentDto studentDto, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("All fields are not properly filled",null));
		}
		
		StudentDto studentDtoS = studentService.addStudent(studentDto);
		
		return ResponseEntity.ok(new ApiResponse("Student Added !!",studentDtoS));
		
		

	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<ApiResponse> updateStudent(@Valid @RequestBody StudentDto studentDto,@RequestParam int id, BindingResult bindingResult) throws ResourceNotFoundException{
		
		if(bindingResult.hasErrors()) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("All fields are not properly filled",null));
	
		}	

		StudentDto studentDtoS = studentService.updateStudent(studentDto,id);
			
		return ResponseEntity.ok(new ApiResponse("Student updated !!",studentDtoS));

	}
	
	
	@DeleteMapping("/deleteStudent/{id}")
	
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable int id) throws ResourceNotFoundException{

			studentService.removeStudent(id);
			return ResponseEntity.ok(new ApiResponse("Student Deleted", null));

	}

}
