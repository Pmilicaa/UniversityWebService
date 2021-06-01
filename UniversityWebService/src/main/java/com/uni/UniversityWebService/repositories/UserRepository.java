package com.uni.UniversityWebService.repositories;

import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUserName(String username);
}
