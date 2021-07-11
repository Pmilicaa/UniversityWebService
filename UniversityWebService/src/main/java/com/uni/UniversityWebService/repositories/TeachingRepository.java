package com.uni.UniversityWebService.repositories;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachingRepository extends JpaRepository<Teaching, Long> {
	
	
	List<Teaching> findByTeacher_id(Long id);
	List<Teaching> findByCourseSpecification_id(Long id);
}
