package com.svj.studentDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.svj.studentDetails.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	

}