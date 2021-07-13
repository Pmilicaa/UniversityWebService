package com.uni.UniversityWebService.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.dto.CourseInstanceDto;
import com.uni.UniversityWebService.model.dto.TeacherDto;
import com.uni.UniversityWebService.model.dto.TeachingDto;
import com.uni.UniversityWebService.repositories.CourseSpecificationRepository;
import com.uni.UniversityWebService.repositories.TeacherRepository;
import com.uni.UniversityWebService.repositories.TeachingRepository;
import com.uni.UniversityWebService.services.TeachingService;

@RestController
public class TeachingController {
	
	 @Autowired
	 private TeachingService teachingService;
	 
	 @Autowired
	 private TeacherRepository teacherRepository;
	 
	 @Autowired
	 private TeachingRepository teachingRepository;
	 
	 @Autowired
	 private CourseSpecificationRepository courseSpecificationRepository;
	 
	 @PostMapping(path ="/teaching/teacher/{id}/{title}/{code}")
	 public @ResponseBody ResponseEntity<?> createTeaching(@PathVariable("id") Long id,@PathVariable("title") String title, @PathVariable("code") String code){
		 Teacher teacher = teacherRepository.findById(id).get();
		 return new ResponseEntity(teachingService.addTeaching(id,title, code), HttpStatus.OK);
	 }
	 
	 @GetMapping(path = "/teaching/{teacherId}/teachings")
	 public @ResponseBody ResponseEntity<List<TeachingDto>> getAllTeachingByTeacherId(@PathVariable("teacherId") Long teacherId) {
		 List<Teaching> teachings = teachingService.findAllByTeacher(teacherId);
		 List<TeachingDto> teachingsDto = new ArrayList<TeachingDto>();
		 for (Teaching teaching : teachings) {
			 teachingsDto.add(new TeachingDto(teaching));
		 }	 
		 return new ResponseEntity<List<TeachingDto>>(teachingsDto, HttpStatus.OK);
		 
	 }
	 
	 
	 
	 @GetMapping(path = "/teaching")
	 public @ResponseBody ResponseEntity<List<TeachingDto>> getAllTeachingCourses() {
		 List<Teaching> teachings = teachingService.findAllTeaching();
		 List<TeachingDto> teachingsDto = new ArrayList<TeachingDto>();
		 for (Teaching teaching : teachings) {
			 teachingsDto.add(new TeachingDto(teaching));
		 }
		 return new ResponseEntity<List<TeachingDto>>(teachingsDto, HttpStatus.OK);
	 }
	 



}
