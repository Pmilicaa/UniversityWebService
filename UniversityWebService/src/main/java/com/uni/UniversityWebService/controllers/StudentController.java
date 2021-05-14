package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.model.Role;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.dto.CourseSpecificationDto;
import com.uni.UniversityWebService.model.dto.EnrollmentDto;
import com.uni.UniversityWebService.services.CourseService;
import com.uni.UniversityWebService.services.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @GetMapping(path = "/students")
    public @ResponseBody
    ResponseEntity<?> getAllStudents(){
        return new ResponseEntity(studentService.findAllStudents(), HttpStatus.OK);
    }
    
    
    //This is my way how to show unpassed exams with information of the courses
    @GetMapping(path = "students/{studentId}/exams", consumes="application/json")
    public ResponseEntity<List<CourseSpecificationDto>> getStudentRemainingExams(@PathVariable("studentId") Long studentId) {
    	List<CourseSpecification> studentRemainingExams = studentService.getRemainingExamsByStudent(studentId);
    	List<CourseSpecificationDto> courseSpecificationsDto = new ArrayList<CourseSpecificationDto>();
    	for(CourseSpecification cs : studentRemainingExams) {
    		courseSpecificationsDto.add(new CourseSpecificationDto(cs));
    	}
		return new ResponseEntity<List<CourseSpecificationDto>>(courseSpecificationsDto, HttpStatus.OK);
    }
    
    
    //This is teachers example how to show student courses
    @GetMapping(path = "students/{studentId}/courses", consumes="application/json")
    public ResponseEntity<List<EnrollmentDto>> getStudentCourses(
			@PathVariable("studentId") Long studentId) {
		Student student = studentService.findByOne(studentId);
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
    

    @PostMapping(path = "/students")
    public @ResponseBody ResponseEntity<?> addStudent(@RequestBody Student student){
        if(!student.getUser().getRole().equals(Role.ROLE_STUDENT)){
            return new ResponseEntity("Student must have a student role", HttpStatus.BAD_REQUEST);
        }else{
            Student newStudent = studentService.saveStudent(student);
            return new ResponseEntity(newStudent, HttpStatus.OK);
        }
    }

    @PutMapping(path = "/students")
    public @ResponseBody ResponseEntity<?> updateStudent(@RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(student);

        return new ResponseEntity(updatedStudent, HttpStatus.OK);
    }

}
