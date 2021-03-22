package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.Role;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.User;
import com.uni.UniversityWebService.services.StudentService;
import com.uni.UniversityWebService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/users")
    public @ResponseBody ResponseEntity<?> getAllUsers(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public @ResponseBody ResponseEntity<?> addUser(@RequestBody User user){
        User newUser = userService.saveUser(user);

        return new ResponseEntity(newUser, HttpStatus.OK);
    }

    @GetMapping(path = "/teachers")
    public @ResponseBody ResponseEntity<?> getAllTeachers(){
        return new ResponseEntity(userService.findAllTeachers(), HttpStatus.OK);
    }

    @PostMapping(path = "/teachers")
    public @ResponseBody ResponseEntity<?> addTeacher(@RequestBody Teacher teacher){
        if(!teacher.getUser().getRole().equals(Role.Teacher)) {
            return new ResponseEntity("Teacher must have a teacher role", HttpStatus.BAD_REQUEST);
        }else{
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
}
