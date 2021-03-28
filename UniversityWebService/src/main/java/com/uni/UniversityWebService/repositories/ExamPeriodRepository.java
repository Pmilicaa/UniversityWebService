package com.uni.UniversityWebService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.ExamPeriod;

public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long>{

	
}
