package com.uni.UniversityWebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

}
