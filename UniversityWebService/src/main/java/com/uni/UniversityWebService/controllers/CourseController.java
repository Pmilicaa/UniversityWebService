package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.dto.CourseInstanceDto;
import com.uni.UniversityWebService.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {


    @Autowired
    private CourseService courseService;

    @GetMapping(path = "/courseInstances")
    public @ResponseBody ResponseEntity<?> getAllInstances(){
        return new ResponseEntity(courseService.findAllCourseInstances(), HttpStatus.OK);
    }

    @GetMapping(path = "/courseSpecifications")
    public @ResponseBody ResponseEntity<?> getAllSpecifications(){
        return new ResponseEntity(courseService.findAllCourseSpecifications(), HttpStatus.OK);
    }

}
