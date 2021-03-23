package com.uni.UniversityWebService.repositories;
import com.uni.UniversityWebService.model.CourseInstance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
	
	List<CourseInstance> findByEnrollment_id(Long id);
}
