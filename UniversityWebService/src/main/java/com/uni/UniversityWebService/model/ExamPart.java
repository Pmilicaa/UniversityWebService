package com.uni.UniversityWebService.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ExamPart")
public class ExamPart {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "examPartId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "examPartStartDate", unique = false, nullable = false)
	private Date examPartStartDate;
	
	@Column(name = "classroom", unique = false, nullable = false)
	private String classroom;
	
	@Column(name = "examPartPoints", unique = false, nullable = false)
	private int examPartPoints;

	@Column(name = "requiredPoints", nullable = false)
	private int requiredPoints;
	
	@ManyToOne
	@JoinColumn(name = "examPartTypeId", referencedColumnName = "examPartTypeId", nullable = false)
	private ExamPartType examPartType;
	
	@ManyToOne
	@JoinColumn(name = "examPartStatusId", referencedColumnName = "examPartStatusId", nullable = false)
	private ExamPartStatus examPartStatus;

	public ExamPart(Long id, Date examPartStartDate, String classroom, int examPartPoints,
			ExamPartType examPartType, ExamPartStatus examPartStatus, int requiredPoints) {
		this.id = id;
		this.examPartStartDate = examPartStartDate;
		this.classroom = classroom;
		this.examPartPoints = examPartPoints;
		this.examPartType = examPartType;
		this.examPartStatus = examPartStatus;
		this.requiredPoints = requiredPoints;
	}

	public ExamPart() {
		
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

	public int getRequiredPoints() {
		return requiredPoints;
	}

	public void setRequiredPoints(int requiredPoints) {
		this.requiredPoints = requiredPoints;
	}
}
