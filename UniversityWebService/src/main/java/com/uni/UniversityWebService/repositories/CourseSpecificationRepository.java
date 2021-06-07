package com.uni.UniversityWebService.repositories;
import com.uni.UniversityWebService.model.CourseSpecification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpecificationRepository extends JpaRepository<CourseSpecification, Long> {
	
	List<CourseSpecification> findByCourseInstances_id(Long id);
	CourseSpecification findByTitle(String title);
	CourseSpecification findByCode(String code);
}
