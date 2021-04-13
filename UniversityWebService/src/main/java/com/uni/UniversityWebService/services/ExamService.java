package com.uni.UniversityWebService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.ExamPeriod;
import com.uni.UniversityWebService.repositories.ExamPeriodRepository;
import com.uni.UniversityWebService.repositories.ExamRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	ExamPeriodRepository examPeriodRepository;
	
	public List<Exam> findAll() {
		return examRepository.findAll();
	}
	
	public Exam findOne(Long id) {
		return examRepository.findById(id).orElse(null);
	}
	
	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}
	
	public void remove (Long id) {
		examRepository.deleteById(id);
	}
	
	public List<Exam> findExamsByExamPeriod(Long examPeriodId) {
		List<Exam> exams = new ArrayList<Exam>();
		ExamPeriod examPeriod = examPeriodRepository.findById(examPeriodId).get();
		for(Exam exam : examPeriod.getExams()) {
			exams.add(exam);
		}
		return exams;
	}
	
}
