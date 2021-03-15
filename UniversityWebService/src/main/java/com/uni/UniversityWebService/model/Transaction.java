package com.uni.UniversityWebService.model;

public class Transaction {
	
	private Long id;
	private Integer amount;
	private TransactionType transactionType;
	private Student student;
	
	public Transaction() {
		super();
	}

	public Transaction(Long id, Integer amount, TransactionType transactionType, Student student) {
		super();
		this.id = id;
		this.amount = amount;
		this.transactionType = transactionType;
		this.student = student;
	}
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	

}
