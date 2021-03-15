package com.uni.UniversityWebService.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Exam")
public class Exam {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "examId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "examPoints", unique = false, nullable = false)
	private int examPoints;
	
	@Column(name = "grade", unique = false, nullable = false)
	private int grade;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "exam")
	private Set<ExamPart> examParts = new HashSet<ExamPart>();
	
	@ManyToOne
	@JoinColumn(name = "examPeriodId", referencedColumnName = "examPeriodId", nullable = false)
	private ExamPeriod examPeriod;

	public Exam(Long id, int examPoints, int grade, Set<ExamPart> examParts, ExamPeriod examPeriod) {
		this.id = id;
		this.examPoints = examPoints;
		this.grade = grade;
		this.examParts = examParts;
		this.examPeriod = examPeriod;
	}

	public Exam() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getExamPoints() {
		return examPoints;
	}

	public void setExamPoints(int examPoints) {
		this.examPoints = examPoints;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Set<ExamPart> getExamParts() {
		return examParts;
	}

	public void setExamParts(Set<ExamPart> examParts) {
		this.examParts = examParts;
	}

	public ExamPeriod getExamPeriod() {
		return examPeriod;
	}

	public void setExamPeriod(ExamPeriod examPeriod) {
		this.examPeriod = examPeriod;
	}
	
}