package com.uni.UniversityWebService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.Enrollment;


public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

	List<Enrollment> findByStudent_id(Long id);
	List<Enrollment> findByStudent_User_UserName(String username);
	List<Enrollment> findByCourseSpecification_Title(String title);
	
}
