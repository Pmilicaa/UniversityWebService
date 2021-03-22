package com.uni.UniversityWebService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findOne(Long id);

}
