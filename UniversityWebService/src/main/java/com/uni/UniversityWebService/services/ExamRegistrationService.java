package com.uni.UniversityWebService.services;

import java.util.List;

import com.uni.UniversityWebService.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.ExamRegistration;
import com.uni.UniversityWebService.repositories.ExamRegistrationRepository;

@Service
public class ExamRegistrationService {

	@Autowired
	private ExamRegistrationRepository examRegistrationRepository;


	public ExamRegistration findByIdExamRegistration(long id) {
		return examRegistrationRepository.findById(id).get();
	}

	public List<ExamRegistration> getAllExamRegistration() {
		return examRegistrationRepository.findAll();
	}

	public ExamRegistration saveExamRegistration(ExamRegistration examRegistration) {
		return examRegistrationRepository.save(examRegistration);
	}

	public List<ExamRegistration> getExamRegistrationsByStudent(Student student){
		return examRegistrationRepository.findByStudent(student);
	}
}
