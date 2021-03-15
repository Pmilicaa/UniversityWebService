package com.uni.UniversityWebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.TransactionType;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long>{

}
