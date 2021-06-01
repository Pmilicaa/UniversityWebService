package com.uni.UniversityWebService.repositories;

import com.uni.UniversityWebService.model.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.ExamPartStatus;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	public Teacher findByUser_UserName(String username);
}
