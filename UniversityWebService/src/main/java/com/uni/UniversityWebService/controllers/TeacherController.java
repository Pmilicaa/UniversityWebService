package com.uni.UniversityWebService.controllers;

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
import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.Role;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.TeachingType;
import com.uni.UniversityWebService.model.dto.TeachingDto;
import com.uni.UniversityWebService.repositories.CourseInstanceRepository;
import com.uni.UniversityWebService.repositories.CourseSpecificationRepository;
import com.uni.UniversityWebService.repositories.TeacherRepository;
import com.uni.UniversityWebService.repositories.TeachingRepository;
import com.uni.UniversityWebService.services.ExamPartService;
import com.uni.UniversityWebService.services.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CourseSpecificationRepository courseSpecificationRepository;
	
	@Autowired
	private TeachingRepository teachingRepository;
	
	@Autowired
	private CourseInstanceRepository courseInstanceRepository;
	
	@Autowired
	private ExamPartService examPartService;
	
	@GetMapping(path="teachers/{teacherId}/courses")
	public @ResponseBody ResponseEntity<?> getTeacherCourses(@PathVariable(value="teacherId") Long id){
		
		return new ResponseEntity(teacherService.findTeacherCourses(id), HttpStatus.OK);
	}
	
	@PostMapping(path="teachers/{teacherId}/teaching/{courseSpecId}")
	public @ResponseBody ResponseEntity<?> addTeacherTeaching(@PathVariable(value="teacherId") Long id, @PathVariable(value="courseSpecId") Long courseSpecId){
		
		CourseSpecification courseSpecification = courseSpecificationRepository.findById(courseSpecId).get();
		
		CourseInstance newCourseInstance = new CourseInstance(new Date(),new Date(),courseSpecification, new ArrayList<Teaching>(), new ArrayList<Enrollment>());
		Teacher teacher = teacherService.findById(id);
		
		Teaching newTeaching = new Teaching(newCourseInstance,new TeachingType(),"ma",teacher);
		
		newCourseInstance.getTeachings().add(newTeaching);
		
		teachingRepository.save(newTeaching);
		courseInstanceRepository.save(newCourseInstance);
		courseSpecification.getCourseInstances().add(newCourseInstance);
		courseSpecificationRepository.save(courseSpecification);
		teacher.getTeachings().add(newTeaching);
		teacherService.save(teacher);
		return new ResponseEntity(new TeachingDto(teacherService.addTeacherTeachings(newTeaching,id)), HttpStatus.OK);
	}
	

	@GetMapping(path="teachers/examparts")
	public @ResponseBody ResponseEntity<?> getTeachersExamParts(){
		return new ResponseEntity (teacherService.findExamParts(), HttpStatus.OK);
	}
	

}
