package com.uni.UniversityWebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.repositories.CourseInstanceRepository;
import com.uni.UniversityWebService.repositories.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	
	public List<Enrollment> findAllByStudent(Long id) {
		return enrollmentRepository.findByStudent_id(id);
	}
	
	public List<Enrollment> findAllByCourceInstance(Long id) {
		return enrollmentRepository.findByCourseInstance_id(id);
	}
	
	public Enrollment findOne(Long id) {
		return enrollmentRepository.findById(id).orElse(null);
	}
	
	//mislim da nam ovo ne treba
	public Enrollment save(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}
	
	
	//mislim da nam i ovo ne treba za enrollment
	public void remove(Enrollment enrollment) {
		enrollmentRepository.delete(enrollment);
	}
	
}