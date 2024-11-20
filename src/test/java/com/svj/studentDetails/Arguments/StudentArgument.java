package com.svj.studentDetails.Arguments;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.svj.studentDetails.dto.StudentDto;

public class StudentArgument implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		
		StudentDto s1=StudentDto.builder().firstName("John").lastName("Doe").email("john.doe@example.com").contactNo("9876543210").address("123 Maple St, Pune").date(LocalDate.parse("2005-09-12")).gender("M").grade("10").emergencyContact("Mr. Doe - 9123456789").build();
		StudentDto s2=StudentDto.builder().firstName("Jane").lastName("Smith").email("jane.smith@example.com").contactNo("9876543211").address("456 Oak St, Pune").date(LocalDate.parse("2006-04-23")).gender("F").grade("9").emergencyContact("Mrs. Smith - 9123456790").build();
		StudentDto s3=StudentDto.builder().firstName("Bob").lastName("Brown").email("bob.brown@example.com").contactNo("9876543213").address("321 Pine St, Pune").date(LocalDate.parse("2008-03-09")).gender("M").grade("7").emergencyContact("Mr. Brown - 9123456791").build();
		StudentDto s4=StudentDto.builder().firstName("Ravi").lastName("Sharma").email("ravi.sharma@example.com").contactNo("9876543217").address("321 Maple St, Pune").date(LocalDate.parse("2008-02-28")).gender("M").grade("7").emergencyContact("Mr. Sharma - 9123456796").build();
	
		return Stream.of(
				
				Arguments.of(s1),
				Arguments.of(s2),
				Arguments.of(s3),
				Arguments.of(s4)
				
				);

	}

}
