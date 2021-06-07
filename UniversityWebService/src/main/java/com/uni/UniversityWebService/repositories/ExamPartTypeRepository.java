package com.uni.UniversityWebService.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.ExamPartType;

public interface ExamPartTypeRepository extends JpaRepository<ExamPartType, Long>{
    public ExamPartType findByCode(String code);
}
