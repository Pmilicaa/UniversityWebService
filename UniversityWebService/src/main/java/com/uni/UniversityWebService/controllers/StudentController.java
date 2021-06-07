package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.*;
import com.uni.UniversityWebService.model.dto.CourseSpecificationDto;
import com.uni.UniversityWebService.model.dto.EnrollmentDto;
import com.uni.UniversityWebService.model.dto.StudentDto;
import com.uni.UniversityWebService.services.StudentService;

import java.util.ArrayList;
import java.util.List;

import com.uni.UniversityWebService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/students")
    public @ResponseBody
    ResponseEntity<?> getAllStudents(){
        return new ResponseEntity(studentService.findAllStudents(), HttpStatus.OK);
    }
    
    @GetMapping(path = "students/me")
    public ResponseEntity<?> getMe(@AuthenticationPrincipal UserDetails userDetails){
        Student student = studentService.findByUserUsername(userDetails.getUsername());

        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping(path = "/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
    	Student student = studentService.findById(id);
    	if(student == null) {
    		return new ResponseEntity<StudentDto>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity(student, HttpStatus.OK);
    }
    
    
    //This is my way how to show unpassed exams with information of the courses
    @GetMapping(path = "/students/{studentId}/exams", consumes="application/json")
    public ResponseEntity<List<CourseSpecificationDto>> getStudentRemainingExams(@PathVariable("studentId") Long studentId) {
    	List<CourseSpecification> studentRemainingExams = studentService.getRemainingExamsByStudent(studentId);
    	List<CourseSpecificationDto> courseSpecificationsDto = new ArrayList<CourseSpecificationDto>();
    	for(CourseSpecification cs : studentRemainingExams) {
    		courseSpecificationsDto.add(new CourseSpecificationDto(cs));
    	}
		return new ResponseEntity<List<CourseSpecificationDto>>(courseSpecificationsDto, HttpStatus.OK);
    }
    
    
    //This is teachers example how to show student courses
    @GetMapping(path = "/students/{studentId}/courses", consumes="application/json")
    public ResponseEntity<List<EnrollmentDto>> getStudentCourses(
			@PathVariable("studentId") Long studentId) {
		Student student = studentService.findById(studentId);
		List<Enrollment> enrollments = student.getEnrollments();
		List<EnrollmentDto> enrollmentsDTO = new ArrayList<>();
		for (Enrollment e: enrollments) {
			EnrollmentDto enrollmentDTO = new EnrollmentDto();
			enrollmentDTO.setId(e.getId());
			enrollmentDTO.setCourseSpecificationDto(new CourseSpecificationDto(e.getCourseSpecification()));
			//we leave student and exam fields empty
			
			enrollmentsDTO.add(enrollmentDTO);
		}
		return new ResponseEntity<List<EnrollmentDto>>(enrollmentsDTO, HttpStatus.OK);
	}
    

    @PostMapping(path = "/api/students")
    public @ResponseBody ResponseEntity<?> addStudent(@RequestBody Student student){
        if(!student.getUser().getRole().equals(Role.ROLE_STUDENT)){
            return new ResponseEntity("Student must have a student role", HttpStatus.BAD_REQUEST);
        }else{
            Student newStudent = studentService.saveStudent(student);
            studentService.initEnrollments(student);
            return new ResponseEntity(newStudent, HttpStatus.OK);
        }
    }
    
    @PutMapping(path = "/api/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable("id") Long studentId) {
    	if(!studentId.equals(studentDto.getId())) {
    		return new ResponseEntity<StudentDto>(HttpStatus.NOT_FOUND);
    	}
    	Student student = studentService.findByOne(studentId);
    	if(student == null) {
    		return new ResponseEntity<StudentDto>(HttpStatus.BAD_REQUEST);
    	}
    	
    	Student izmenjenStudent = studentDto.convertStudentDtoToStudent(student);
    	User user = userService.findById(student.getUser().getId());
    	izmenjenStudent.setUser(user);
    	student = studentService.saveStudent(izmenjenStudent);
    	return new ResponseEntity<StudentDto>(new StudentDto(student), HttpStatus.OK);
    }

    
    @PutMapping(path = "/students")
    public @ResponseBody ResponseEntity<?> updateStudent(@RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(student);

        return new ResponseEntity(updatedStudent, HttpStatus.OK);
    }
    
    @DeleteMapping(path ="/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
    	Student student = studentService.findById(id);
    	if (student == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    	studentService.remove(student);
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
