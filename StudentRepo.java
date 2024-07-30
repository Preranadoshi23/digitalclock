package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> 
{
	int countByMarksGreaterThan(int marks);
	List<Student> findByMarksNot(int marks);
	List<Student> findByMarks(int marks);
	List<Student> findByMarksGreaterThan(int marks);
	List<Student> findByMarksLessThan(int marks);
	List<Student> findByMarksIsNotNull();
	List<Student> findByMarksIsNull();
	int countByMarksGreaterThanAndMarksLessThan(int min,int max);
	List<Student> findByIdNot(int id);
	List<Student> findByIdGreaterThan(int id);
}
