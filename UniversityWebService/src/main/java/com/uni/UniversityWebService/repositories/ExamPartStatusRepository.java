package com.uni.UniversityWebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.ExamPartStatus;

public interface ExamPartStatusRepository extends JpaRepository<ExamPartStatus, Long>{
    public ExamPartStatus findByCode(String code);
}
