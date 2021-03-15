package com.uni.UniversityWebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.UniversityWebService.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
