package com.uni.UniversityWebService.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.Role;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.TeachingType;
import com.uni.UniversityWebService.model.dto.TeacherDto;
import com.uni.UniversityWebService.model.dto.TeachingDto;
import com.uni.UniversityWebService.repositories.CourseInstanceRepository;
import com.uni.UniversityWebService.repositories.CourseSpecificationRepository;
import com.uni.UniversityWebService.repositories.TeacherRepository;
import com.uni.UniversityWebService.repositories.TeachingRepository;
import com.uni.UniversityWebService.repositories.UserRepository;
import com.uni.UniversityWebService.services.ExamPartService;
import com.uni.UniversityWebService.services.ExamService;
import com.uni.UniversityWebService.services.StudentService;
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
	private TeacherRepository teacherRepository;
	
	@Autowired
	private CourseInstanceRepository courseInstanceRepository;
	
	@Autowired
	private ExamPartService examPartService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ExamService examService;
	@GetMapping(path="teachers/courses")
	public @ResponseBody ResponseEntity<?> getTeacherCourses(@AuthenticationPrincipal UserDetails userDetails){
		Teacher teacher = teacherRepository.findByUser_UserName(userDetails.getUsername());
		System.out.println(teacher.getFirstName());
		return new ResponseEntity(teacherService.findTeacherCourseSpec(teacher.getId()), HttpStatus.OK);
	}
	@GetMapping(path="teachers/{teacherId}/examPartsAndSpec/{period}")
	public @ResponseBody ResponseEntity<?> getTeacherCoursesSpecs(@PathVariable(value="teacherId") Long id, @PathVariable(value="period") String period){

		return new ResponseEntity(teacherService.findExamPartsAndCourseSepcificationForTeacher(id,period), HttpStatus.OK);
	}
	
//	@PostMapping(path="teachers/{teacherId}/teaching/{courseSpecId}")
//	public @ResponseBody ResponseEntity<?> addTeacherTeaching(@PathVariable(value="teacherId") Long id, @PathVariable(value="courseSpecId") Long courseSpecId){
//		
//		CourseSpecification courseSpecification = courseSpecificationRepository.findById(courseSpecId).get();
//		
//		Teacher teacher = teacherService.findById(id);
//		Teaching newTeaching = new Teaching(courseSpecification,new TeachingType(),"ma",teacher, new HashSet<Exam>());
//		
//		courseSpecification.getTeachings().add(newTeaching);
//		//CourseInstance newCourseInstance = new CourseInstance(new Date(),new Date(),courseSpecification);
//
//		teachingRepository.save(newTeaching);
//		courseSpecificationRepository.save(courseSpecification);
//		teacher.getTeachings().add(newTeaching);
//		teacherService.save(teacher);
//		return new ResponseEntity(new TeachingDto(teacherService.addTeacherTeachings(newTeaching,id)), HttpStatus.OK);
//	}
	

	@GetMapping(path="teachers/examparts")
	public @ResponseBody ResponseEntity<?> getTeachersExamParts(){
		return new ResponseEntity (teacherService.findExamParts(), HttpStatus.OK);
	}
	
	@GetMapping(path="teachers/courses/{id}/students")
	public @ResponseBody ResponseEntity<?> getAllTeacherStudents(@PathVariable(value="id") Long id){
		CourseSpecification courseSpec = courseSpecificationRepository.findById(id).get();
		return new ResponseEntity (teacherService.findTeacherStudents(courseSpec), HttpStatus.OK);
	}
	@GetMapping(path="teachers/{teacherId}/examParts")
	public @ResponseBody ResponseEntity<?> getTeacherExamParts(@PathVariable(value="teacherId") Long teacherId){		
		return new ResponseEntity (teacherService.findTeacherExamParts(teacherId), HttpStatus.OK);
	}
	@GetMapping(path="/teachers/me")
	public @ResponseBody ResponseEntity<?> getLoggedTeacher(@AuthenticationPrincipal UserDetails userDetails){
		Teacher teacher = teacherRepository.findByUser_UserName(userDetails.getUsername());
		return new ResponseEntity(new TeacherDto(teacher), HttpStatus.OK);
	}
	@GetMapping(path = "/teachers")
	public @ResponseBody
	ResponseEntity<?> getAllTechers(){
		return new ResponseEntity(teacherService.findAllTeachers(), HttpStatus.OK);
	}
}
