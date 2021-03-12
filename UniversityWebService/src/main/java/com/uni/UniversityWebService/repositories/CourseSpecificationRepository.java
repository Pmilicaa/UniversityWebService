package com.uni.UniversityWebService.repositories;
import com.uni.UniversityWebService.model.CourseSpecification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpecificationRepository extends JpaRepository<CourseSpecification, Long> {
}
