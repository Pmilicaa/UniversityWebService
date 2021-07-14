package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.*;
import com.uni.UniversityWebService.model.dto.RegisterExamDto;
import com.uni.UniversityWebService.services.StudentService;
import com.uni.UniversityWebService.services.UserService;
import com.uni.UniversityWebService.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;


    @Autowired
	private PasswordEncoder bCryptPasswordEncoder;

    @GetMapping(path = "/users")
    public @ResponseBody ResponseEntity<?> getAllUsers(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public @ResponseBody ResponseEntity<?> addUser(@RequestBody User user){
        User newUser = new User(user.getUserName(),  bCryptPasswordEncoder.encode(user.getPassword()), Role.ROLE_ADMIN);

        return new ResponseEntity(userService.saveUser(newUser), HttpStatus.OK);
    }



    @PostMapping(path = "/teachers")
    public @ResponseBody ResponseEntity<?> addTeacher(@RequestBody Teacher teacher){
        if(!teacher.getUser().getRole().equals(Role.ROLE_TEACHER)) {
            return new ResponseEntity("Teacher must have a teacher role", HttpStatus.BAD_REQUEST);
        }else{
        	User user = new User(teacher.getUser().getUserName(), bCryptPasswordEncoder.encode(teacher.getUser().getPassword()), Role.ROLE_TEACHER);
        	teacher.setUser(user);
            Teacher newTeacher = userService.saveTeacher(teacher);
            return new ResponseEntity(newTeacher, HttpStatus.OK);
        }
    }

    @PutMapping(path = "/users")
    public @ResponseBody ResponseEntity<?> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);

        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    @PutMapping(path = "/teachers")
    public @ResponseBody ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher){
        Teacher updateTeacher = userService.updateTeacher(teacher);

        return new ResponseEntity(updateTeacher, HttpStatus.OK);
    }

    @DeleteMapping(path ="/teachers/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("id") Long id) {
        Teacher teacher = teacherService.findById(id);
        if (teacher == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
       userService.deleteTeacher(teacher);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(path = "/examRegistery")
    public ResponseEntity<?> getAllRegisterExams(){

        return new ResponseEntity(userService.getAllRegisterExams(), HttpStatus.OK);
    }
    @PutMapping(path = "/examRegistery")
    public @ResponseBody ResponseEntity<?> updateExamPart(@RequestBody RegisterExamDto registerExamDto){
        RegisterExamDto registerExamDto1 = userService.examPartUpdate(registerExamDto);

        return new ResponseEntity(registerExamDto1, HttpStatus.OK);
    }

}
