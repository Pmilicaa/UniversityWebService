package com.uni.UniversityWebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
