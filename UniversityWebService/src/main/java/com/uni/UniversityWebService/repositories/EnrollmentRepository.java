package com.uni.UniversityWebService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.Enrollment;


public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

	List<Enrollment> findByStudent_id(Long id);
	
	List<Enrollment> findByCourseInstance_id(Long id);
	
}
