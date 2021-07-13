package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.ExamRegistration;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.dto.ExamRegistrationDto;
import com.uni.UniversityWebService.services.ExamRegistrationService;
import com.uni.UniversityWebService.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.UniversityWebService.repositories.ExamRegistrationRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExamRegistrationController {

	@Autowired
	private ExamRegistrationService examRegistrationService;

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/examRegistrations/me")
	public ResponseEntity<List<ExamRegistrationDto>> getLoggedInStudentExamRegistrations(@AuthenticationPrincipal UserDetails userDetails){
		Student student = studentService.findByUserUsername(userDetails.getUsername());


		List<ExamRegistration> examRegistrations = examRegistrationService.getExamRegistrationsByStudent(student);

		List<ExamRegistrationDto> examRegistrationDtos = new ArrayList<>();
		for (ExamRegistration examRegistration: examRegistrations) {
			examRegistrationDtos.add(new ExamRegistrationDto(examRegistration));
		}
		return new ResponseEntity<List<ExamRegistrationDto>>(examRegistrationDtos, HttpStatus.OK);
	}
}
