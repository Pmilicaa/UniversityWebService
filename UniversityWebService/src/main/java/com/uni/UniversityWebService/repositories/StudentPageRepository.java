package com.uni.UniversityWebService.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.uni.UniversityWebService.model.Student;

public interface StudentPageRepository extends PagingAndSortingRepository<Student, Long>{

	Page<Student> findByActive(boolean active, Pageable page);
	
}
