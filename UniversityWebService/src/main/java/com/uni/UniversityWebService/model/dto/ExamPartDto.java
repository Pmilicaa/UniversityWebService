package com.uni.UniversityWebService.model.dto;

import java.util.Date;

import com.uni.UniversityWebService.model.ExamPartStatus;
import com.uni.UniversityWebService.model.ExamPartType;

public class ExamPartDto {

	private Long id;
	private Date examPartStartDate;
	private String classroom;
	private int examPartPoints;
	private int requiredPoints;
	private ExamPartType examPartType;
	private ExamPartStatus examPartStatus;
	
	
	public ExamPartDto(Long id, Date examPartStartDate, String classroom, int examPartPoints, int requiredPoints,
			ExamPartType examPartType, ExamPartStatus examPartStatus) {
		super();
		this.id = id;
		this.examPartStartDate = examPartStartDate;
		this.classroom = classroom;
		this.examPartPoints = examPartPoints;
		this.requiredPoints = requiredPoints;
		this.examPartType = examPartType;
		this.examPartStatus = examPartStatus;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getExamPartStartDate() {
		return examPartStartDate;
	}


	public void setExamPartStartDate(Date examPartStartDate) {
		this.examPartStartDate = examPartStartDate;
	}


	public String getClassroom() {
		return classroom;
	}


	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}


	public int getExamPartPoints() {
		return examPartPoints;
	}


	public void setExamPartPoints(int examPartPoints) {
		this.examPartPoints = examPartPoints;
	}


	public int getRequiredPoints() {
		return requiredPoints;
	}


	public void setRequiredPoints(int requiredPoints) {
		this.requiredPoints = requiredPoints;
	}


	public ExamPartType getExamPartType() {
		return examPartType;
	}


	public void setExamPartType(ExamPartType examPartType) {
		this.examPartType = examPartType;
	}


	public ExamPartStatus getExamPartStatus() {
		return examPartStatus;
	}


	public void setExamPartStatus(ExamPartStatus examPartStatus) {
		this.examPartStatus = examPartStatus;
	}
	
	

	
}
