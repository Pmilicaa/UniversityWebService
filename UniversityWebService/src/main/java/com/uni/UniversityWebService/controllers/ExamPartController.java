package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.ExamPartStatus;
import com.uni.UniversityWebService.repositories.ExamPartStatusRepository;
import com.uni.UniversityWebService.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.uni.UniversityWebService.repositories.ExamPartRepository;
import com.uni.UniversityWebService.services.ExamPartService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExamPartController {
	

	@Autowired
	private ExamPartRepository examPartRepository;
	
	@Autowired
	private ExamPartService examPartService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ExamPartStatusRepository examPartStatusRepository;

	@GetMapping(path="/examParts")
	public @ResponseBody ResponseEntity<?> getExamParts(){
		return new ResponseEntity(examPartRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/examParts/register/{id}")
	public ResponseEntity<?> registerExamPart(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(value = "id") Long id){
		ExamPartStatus registeredStatus = examPartStatusRepository.findByCode("R");
		// TODO: Check whether this exam part belongs to the user that's logged in
		// TODO: Decrease student balance after registration by 200
		try{
			ExamPart examPart = examPartService.findById(id);
			examPart.setExamPartStatus(registeredStatus);
			ExamPart newExamPart = examPartService.save(examPart);

			return new ResponseEntity(newExamPart, HttpStatus.OK);
		}catch(NullPointerException e){
			return new ResponseEntity("Exam part with the specified id does not exist.", HttpStatus.OK);
		}

	}
	
	 
}
