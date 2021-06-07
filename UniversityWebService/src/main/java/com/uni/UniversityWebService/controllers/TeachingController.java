package com.uni.UniversityWebService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.repositories.TeacherRepository;
import com.uni.UniversityWebService.services.TeachingService;

@RestController
public class TeachingController {
	
	 @Autowired
	 private TeachingService teachingService;
	 
	 @Autowired
	 private TeacherRepository teacherRepository;
	 
	 @PostMapping(path ="/teaching/teacher/{id}")
	 public @ResponseBody ResponseEntity<?> createTeaching(@PathVariable("id") Long id){
		 Teacher teacher = teacherRepository.findById(id).get();
		 return new ResponseEntity(teachingService.addTeaching(id), HttpStatus.OK);
	 }



}
