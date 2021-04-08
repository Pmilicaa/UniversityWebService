package com.uni.UniversityWebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.ExamPeriod;
import com.uni.UniversityWebService.repositories.ExamPeriodRepository;

@Service
public class ExamPeriodService {

	@Autowired
	ExamPeriodRepository examPeriodRepository;
	
	
	public List<ExamPeriod> findAll() {
		return examPeriodRepository.findAll();
	}
	
	public ExamPeriod findOne(Long id) {
		return examPeriodRepository.findById(id).get();
	}
	
	public ExamPeriod save(ExamPeriod examPeriod) {
		return examPeriodRepository.save(examPeriod);
	}
	
	public void remove(ExamPeriod examPeriod) {
		examPeriodRepository.delete(examPeriod);
	}
	
}
