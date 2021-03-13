package com.uni.UniversityWebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long>{

}
