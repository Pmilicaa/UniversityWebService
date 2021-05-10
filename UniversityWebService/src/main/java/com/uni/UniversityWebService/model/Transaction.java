package com.uni.UniversityWebService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "amount")
	private Integer amount;
	
	@OneToOne
	@JoinColumn(name="transactionType", referencedColumnName = "id")
	private TransactionType transactionType;
	
	@ManyToOne
	@JoinColumn(name="student", referencedColumnName = "id")
	@JsonBackReference
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
