package com.uni.UniversityWebService.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="cardNumber")
	private String cardNumber;
	
	@Column(name="balance")
	private Integer balance;
	
	@Column(name="accountNumber")
	private Integer accountNumber;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
	)
	private List<Document> documents;
	
	@OneToMany(
			mappedBy = "student",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			
	)
	private List<Transaction> transactions;
	
	@OneToMany(
			mappedBy = "student",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
	
	)
	private List<Enrollment> enrollments;

	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name="User_id", referencedColumnName = "id")
	private User  user;

	public Student() {
		super();
	}

	public Student(Long id, String firstName, String lastName, String cardNumber, Integer balance,
			Integer accountNumber, List<Document> documents, List<Transaction> transactions,
			List<Enrollment> enrollments,User user) {
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
		this.user=user;

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
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
}
