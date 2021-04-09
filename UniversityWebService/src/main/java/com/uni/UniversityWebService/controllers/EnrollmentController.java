package com.uni.UniversityWebService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.dto.EnrollmentDto;
import com.uni.UniversityWebService.services.CourseService;
import com.uni.UniversityWebService.services.EnrollmentService;
import com.uni.UniversityWebService.services.ExamService;
import com.uni.UniversityWebService.services.StudentService;

@RestController
@RequestMapping(value = "enrollment")
public class EnrollmentController {

	@Autowired
	EnrollmentService enrollmentService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	ExamService examService;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<EnrollmentDto> createEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
		if(enrollmentDto.getStudentDto() == null || enrollmentDto.getExamDto() == null || enrollmentDto.getCourseSpecificationDto() == null) {
			return new ResponseEntity<EnrollmentDto>(HttpStatus.BAD_REQUEST);
		}
		Student student = studentService.findByOne(enrollmentDto.getStudentDto().getId());
		CourseSpecification courseSpecification = courseService.findCourseSpecificationById(enrollmentDto.getCourseSpecificationDto().getId());
		Exam exam = examService.findOne(enrollmentDto.getExamDto().getId());
		if(student == null || courseSpecification == null || exam == null) {
			return new ResponseEntity<EnrollmentDto>(HttpStatus.BAD_REQUEST);
		}
		Enrollment enrollment = new Enrollment();
		enrollment.setCourseSpecification(courseSpecification);
		enrollment.setStudent(student);
		enrollment.setExam(exam);
		
		enrollment = enrollmentService.save(enrollment);
		return new ResponseEntity<EnrollmentDto>(new EnrollmentDto(enrollment), HttpStatus.CREATED);
	}
	
	
	/*PUT Method I think is not nedded, because Enrollment only has 
	connections to Exam, Student and CourseSpecifications and it has no attributes of its own*/
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEnrollment(@PathVariable("id") Long id){
		Enrollment enrollment = enrollmentService.findOne(id);
		if (enrollment != null){
			enrollmentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
