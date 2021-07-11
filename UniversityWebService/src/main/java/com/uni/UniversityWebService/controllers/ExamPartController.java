package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.ExamPartStatus;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.repositories.ExamPartStatusRepository;
import com.uni.UniversityWebService.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		try{
			ExamPart examPart = examPartService.findById(id);
			if(examPart.getExamPartStatus().getName().equals("Registered")){
				return new ResponseEntity("Exam is already registered.", HttpStatus.BAD_REQUEST);
			}
			examPart.setExamPartStatus(registeredStatus);
			ExamPart newExamPart = examPartService.save(examPart);

			Student student = studentService.findByUserUsername(userDetails.getUsername());
			studentService.decreaseStudentBalance(student, 200);
			studentService.saveStudent(student);

			return new ResponseEntity(newExamPart, HttpStatus.OK);
		}catch(NullPointerException e){
			return new ResponseEntity("Exam part with the specified id does not exist.", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(path = "/examParts/cancel/{id}")
	public ResponseEntity<?> cancelExamPart(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(value = "id") Long id){
		ExamPartStatus notRegisteredStatus = examPartStatusRepository.findByCode("N");

		try{
			ExamPart examPart = examPartService.findById(id);
			if(!examPart.getExamPartStatus().getName().equals("Registered")){
				return new ResponseEntity("You can only cancel a registered exam.", HttpStatus.BAD_REQUEST);
			}
			examPart.setExamPartStatus(notRegisteredStatus);
			ExamPart newExamPart = examPartService.save(examPart);

			Student student = studentService.findByUserUsername(userDetails.getUsername());
			studentService.increaseStudentBalance(student, 200);
			studentService.saveStudent(student);

			return new ResponseEntity(newExamPart, HttpStatus.OK);
		}catch (NullPointerException e){
			return new ResponseEntity("Exam part with the specified id does not exist.", HttpStatus.BAD_REQUEST);
		}
	}

	// Test endpoint za paging
	@GetMapping(path = "/examParts/paged")
	public ResponseEntity<?> getAllPartsPaged(){
		Pageable fiveElementsPerPage = PageRequest.of(0, 5);

		Page<ExamPart> allExamParts = examPartRepository.findAll(fiveElementsPerPage);
		return new ResponseEntity(allExamParts, HttpStatus.OK);
	}
	 
}
