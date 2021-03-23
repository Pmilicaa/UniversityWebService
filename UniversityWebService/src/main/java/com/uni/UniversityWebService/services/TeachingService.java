package com.uni.UniversityWebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.repositories.TeachingRepository;

@Service
public class TeachingService {

	@Autowired
	TeachingRepository teachingRepository;
	
	public List<Teaching> findAllByCourceInstance(Long id) {
		return teachingRepository.findByCourseInstance_id(id);
	}
	
	
	public List<Teaching> findAllByTeacher(Long id) {
		return teachingRepository.findByTeacher_id(id);
	}
	
}