package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.TransactionType;


public class TransactionDto {


		private Long id;
		private Integer amount;
		private TransactionType transactionType;
		private Long studentId;

	public TransactionDto(Long id, Integer amount, TransactionType transactionType, Long studentId) {
		this.id = id;
		this.amount = amount;
		this.transactionType = transactionType;
		this.studentId = studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public Integer getAmount() {
		return amount;
	}

	public Long getId() {
		return id;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}
}
