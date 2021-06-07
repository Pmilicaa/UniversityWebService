package com.uni.UniversityWebService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Set<ExamPart> examParts = new HashSet<ExamPart>();

	@JsonBackReference
	@OneToOne(cascade={CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "exam")
	private Enrollment enrollment;

	@OneToOne(cascade={CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "exam")
	private Teaching teaching;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "examPeriodId", referencedColumnName = "examPeriodId", nullable = false)
	private ExamPeriod examPeriod;



	public Exam(Long id, int examPoints, int grade, Set<ExamPart> examParts, Enrollment enrollment,
			ExamPeriod examPeriod, Teaching teaching) {
		this.id = id;
		this.examPoints = examPoints;
		this.grade = grade;
		this.examParts = examParts;
		this.enrollment = enrollment;
		this.examPeriod = examPeriod;
		this.teaching = teaching;
	}

	public Exam(int examPoints, int grade, Enrollment enrollment, Teaching teaching, ExamPeriod examPeriod) {
		this.examPoints = examPoints;
		this.grade = grade;
		this.examParts = new HashSet<>();
		this.enrollment = enrollment;
		this.teaching = teaching;
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

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public Teaching getTeaching() {
		return teaching;
	}

	public void setTeaching(Teaching teaching) {
		this.teaching = teaching;
	}
	
}
