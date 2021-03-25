package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.services.CourseService;
import com.uni.UniversityWebService.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CourseController {


    @Autowired
    private CourseService courseService;


}
