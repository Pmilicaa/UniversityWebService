package com.uni.UniversityWebService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.uni.UniversityWebService.repositories.ExamPartRepository;
import com.uni.UniversityWebService.services.ExamPartService;

import org.springframework.web.bind.annotation.*;

@RestController
public class ExamPartController {
	

	@Autowired
	private ExamPartRepository examPartRepository;
	
	@Autowired
	private ExamPartService examPartService;
	
	@GetMapping(path="/examParts")
	public @ResponseBody ResponseEntity<?> getExamParts(){
		return new ResponseEntity(examPartRepository.findAll(), HttpStatus.OK);
	}
	
	 
}
