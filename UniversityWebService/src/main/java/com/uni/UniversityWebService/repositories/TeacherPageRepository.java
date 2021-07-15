package com.uni.UniversityWebService.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.uni.UniversityWebService.model.Teacher;

public interface TeacherPageRepository extends PagingAndSortingRepository<Teacher, Long>{

	Page<Teacher> findByActive(boolean active, Pageable page);
	
}
