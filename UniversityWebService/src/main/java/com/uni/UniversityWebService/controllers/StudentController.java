package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.Role;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.services.StudentService;
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

    @PostMapping(path = "/students")
    public @ResponseBody ResponseEntity<?> addStudent(@RequestBody Student student){
        if(!student.getUser().getRole().equals(Role.Student)){
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
