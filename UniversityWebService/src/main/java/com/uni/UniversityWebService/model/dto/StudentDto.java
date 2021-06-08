package com.uni.UniversityWebService.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Transaction;
import com.uni.UniversityWebService.model.User;

public class StudentDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String cardNumber;
	private Integer balance;
	private Integer accountNumber;
	private List<TransactionDto> transactionsDto;
	private List<EnrollmentDto> enrollmentsDto;
	private UserDto userDto;
	
	
	public StudentDto() {
		
	}
	
	public StudentDto(Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.cardNumber = student.getCardNumber();
		this.balance = student.getBalance();
		this.accountNumber = student.getAccountNumber();
		this.transactionsDto = convertTransactionsToDtos(student.getTransactions());
		this.enrollmentsDto = convertEnrollmentsToDtos(student.getEnrollments());
		this.userDto = new UserDto(student.getUser());
	}
	
	public Student convertStudentDtoToStudent(Student student) {
		student.setId(this.getId());
		student.setFirstName(this.getFirstName());
		student.setLastName(this.getLastName());
		student.setBalance(this.getBalance());
		student.setCardNumber(this.getCardNumber());
		student.setAccountNumber(this.getAccountNumber());
//		User user = userDto.convertUserDtoToUser(student.getUser());
//		student.setUser(user);
		
		return student;
	}
	
	private List<EnrollmentDto> convertEnrollmentsToDtos(List<Enrollment> enrollments) {
		List<EnrollmentDto> enrollmentsDto = new ArrayList<EnrollmentDto>();
		for (Enrollment enrollment : enrollments) {
			enrollmentsDto.add(new EnrollmentDto(enrollment));
		}
		return enrollmentsDto;
	}
	
	
	private List<TransactionDto> convertTransactionsToDtos(List<Transaction> transactions) {
		List<TransactionDto> transactionsDto = new ArrayList<TransactionDto>();
		for (Transaction transaction : transactions) {
			transactionsDto.add(new TransactionDto(transaction));
		}
		return transactionsDto;
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

	public List<TransactionDto> getTransactionsDto() {
		return transactionsDto;
	}

	public void setTransactionsDto(List<TransactionDto> transactionsDto) {
		this.transactionsDto = transactionsDto;
	}

	public List<EnrollmentDto> getEnrollmentsDto() {
		return enrollmentsDto;
	}

	public void setEnrollmentsDto(List<EnrollmentDto> enrollmentsDto) {
		this.enrollmentsDto = enrollmentsDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
