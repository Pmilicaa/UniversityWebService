package com.uni.UniversityWebService.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.User;
import com.uni.UniversityWebService.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	User user;
	
	public Student findOne(Long id) {
		return studentRepository.findOne(id);
	}
	
	public void remove(Student student) {
		studentRepository.delete(student);
	}
		
}
