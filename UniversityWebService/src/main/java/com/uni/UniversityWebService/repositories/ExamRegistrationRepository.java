package com.uni.UniversityWebService.repositories;

import com.uni.UniversityWebService.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.ExamRegistration;

import java.util.List;

public interface ExamRegistrationRepository extends JpaRepository<ExamRegistration, Long>{
    public List<ExamRegistration> findByStudent(Student student);
    public ExamRegistration findByExamPart(ExamPart examPart);
}
