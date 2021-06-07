package com.uni.UniversityWebService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.uni.UniversityWebService.repositories.ExamRegistrationRepository;

@RestController
public class ExamRegistrationController {
	
	@Autowired
	private ExamRegistrationRepository examRegistrationRepository;
	

}
