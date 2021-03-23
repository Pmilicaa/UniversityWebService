package com.uni.UniversityWebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.repositories.ExamRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository examRepository;
	
	public List<Exam> findAllByExamPeriod_id(Long id) {
		return examRepository.findByExamPeriod_id(id);
	}
	
	public Exam findOne(Long id) {
		return examRepository.findById(id).orElse(null);
	}
	
	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}
	
	public void remove (Exam exam) {
		examRepository.delete(exam);
	}
	
}
