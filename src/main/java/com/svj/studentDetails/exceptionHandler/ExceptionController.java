package com.svj.studentDetails.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.svj.studentDetails.apiResponse.ApiResponse;
import com.svj.studentDetails.customException.ResourceNotFoundException;

@RestControllerAdvice
public class ExceptionController {
	
    @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleException(ResourceNotFoundException e){
		
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Student Not Found",null));
    			
		
	}
	
    
    @ExceptionHandler(Exception.class)
  	public ResponseEntity<ApiResponse> handleException(Exception e){
  		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      			
  		
  	}
	

}
