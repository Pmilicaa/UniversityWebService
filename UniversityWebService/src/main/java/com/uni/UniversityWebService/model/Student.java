package com.uni.UniversityWebService.model;

import java.util.List;

public class Student {

	private Long id;
	private String firstName;
	private String lastName;
	private String cardNumber;
	private Integer balance;
	private Integer accountNumber;
	private List<Document> documents;
	private List<Transaction> transactions;
	private List<Enrollment> enrollments;


	public Student() {
		super();
	}

	public Student(Long id, String firstName, String lastName, String cardNumber, Integer balance,
			Integer accountNumber, List<Document> documents, List<Transaction> transactions,
			List<Enrollment> enrollments) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.documents = documents;
		this.transactions = transactions;
		this.enrollments = enrollments;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
}
