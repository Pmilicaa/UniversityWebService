package com.uni.UniversityWebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.repositories.ExamPartRepository;

@Service
public class ExamPartService {

	@Autowired
	ExamPartRepository examPartRepository;
	
	
	public List<ExamPart> findAll() {
		return examPartRepository.findAll();
	}
	
	public ExamPart findOne(Long id) {
		return examPartRepository.findById(id).orElse(null);
	}
	
	public ExamPart save (ExamPart examPart) {
		return examPartRepository.save(examPart);
	}
	
	public void remove(ExamPart examPart) {
		examPartRepository.delete(examPart);
	}
}
