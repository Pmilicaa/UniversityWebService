package com.uni.UniversityWebService.repositories;
import com.uni.UniversityWebService.model.Teaching;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachingRepository extends JpaRepository<Teaching, Long> {
}
