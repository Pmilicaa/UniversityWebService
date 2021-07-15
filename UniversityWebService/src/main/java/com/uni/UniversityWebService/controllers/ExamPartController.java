package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.*;

import com.uni.UniversityWebService.repositories.ExamPartStatusRepository;
import com.uni.UniversityWebService.services.EnrollmentService;
import com.uni.UniversityWebService.services.ExamRegistrationService;
import com.uni.UniversityWebService.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.uni.UniversityWebService.repositories.ExamPartRepository;
import com.uni.UniversityWebService.services.ExamPartService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

	@Autowired
	private EnrollmentService enrollmentService;

	@Autowired
	private ExamRegistrationService examRegistrationService;


	@GetMapping(path="/examParts")
	public @ResponseBody ResponseEntity<?> getExamParts(){
		return new ResponseEntity(examPartRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/examParts/register/{id}/{enrollmentId}")
	public ResponseEntity<?> registerExamPart(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(value = "id") Long id,
											  @PathVariable(value = "enrollmentId") Long enrollmentId){
		ExamPartStatus registeredStatus = examPartStatusRepository.findByCode("R");
		// TODO: Check whether this exam part belongs to the user that's logged in
		try{
			Enrollment enrollment = enrollmentService.findOne(enrollmentId);
			ExamPart examPart = examPartService.findById(id);
			if(examPart.getExamPartStatus().getName().equals("Registered")){
				return new ResponseEntity("Exam is already registered.", HttpStatus.BAD_REQUEST);
			}
			examPart.setExamPartStatus(registeredStatus);
			ExamPart newExamPart = examPartService.save(examPart);

			Student student = studentService.findByUserUsername(userDetails.getUsername());


			studentService.decreaseStudentBalance(student, 200);
			//studentService.saveStudent(student);



			return new ResponseEntity(newExamPart, HttpStatus.OK);
		}catch(NullPointerException e){
			return new ResponseEntity("Exam part or enrollment with the specified id does not exist.", HttpStatus.BAD_REQUEST);
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

	@PostMapping(path = "/examParts/dates")
	public ResponseEntity<String> changeDates(@RequestBody ChangeDateDto changeDateDto){
		System.out.println("Date in controller: " + changeDateDto.getDate());

		Dates dates = datesRepository.findByCourseTitleAndPeriod(changeDateDto.getTitle(), changeDateDto.getPeriod());
		Dates savedDates = examPartService.saveDates(dates, changeDateDto);
		try {
			examPartService.refreshDates(dates);
		}catch (NullPointerException e){
			return new ResponseEntity<>("Problem with parsing dates", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("Successfully changed dates", HttpStatus.OK);
	}

	// Test endpoint za paging
	@GetMapping(path = "/examParts/paged/{pageId}/{sortType}/{sortBy}")
	public ResponseEntity<?> getAllPartsPaged(@PathVariable(value = "pageId") int pageId, @PathVariable(value = "sortType") int sortType, @PathVariable(value = "sortBy") String sortBy){
		Pageable fiveElementsPerPage = null;
		
		if(sortType == 0) {
			fiveElementsPerPage =  PageRequest.of(pageId, 5);
		}else if(sortType == 1) {
			fiveElementsPerPage = PageRequest.of(pageId, 5, Sort.by(sortBy));
		}else if(sortType == 2) {
			fiveElementsPerPage = PageRequest.of(pageId, 5, Sort.by(sortBy).descending());
		}else {
			return new ResponseEntity("Sort type not found", HttpStatus.BAD_REQUEST);
		}
		 
		Page<ExamPart> allExamParts = examPartRepository.findAll(fiveElementsPerPage);
		return new ResponseEntity(allExamParts, HttpStatus.OK);
	}
	 
}
