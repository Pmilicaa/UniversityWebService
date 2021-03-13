package com.uni.UniversityWebService.model;

import java.util.Date;
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
@Table(name = "ExamPeriod")
public class ExamPeriod {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "examPeriodId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "examPeriodStartDate", unique = false, nullable = false)
	private Date examPeriodStartDate;
	
	@Column(name = "examPeriodEndDate", unique = false, nullable = false)
	private Date examPeriodEndDate;
	
	@ManyToOne
	@JoinColumn(name="enrollmentId", referencedColumnName="enrollmentId", nullable=false)
	private Enrollment enrollment;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "examPeriod")
	private Set<Exam> exams = new HashSet<Exam>();

	public ExamPeriod(Long id, String name, Date examPeriodStartDate, Date examPeriodEndDate, Enrollment enrollment, Set<Exam> exams) {
		this.id = id;
		this.name = name;
		this.examPeriodStartDate = examPeriodStartDate;
		this.examPeriodEndDate = examPeriodEndDate;
		this.enrollment = enrollment;
		this.exams = exams;
	}

	public ExamPeriod() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExamPeriodStartDate() {
		return examPeriodStartDate;
	}

	public void setExamPeriodStartDate(Date examPeriodStartDate) {
		this.examPeriodStartDate = examPeriodStartDate;
	}

	public Date getExamPeriodEndDate() {
		return examPeriodEndDate;
	}

	public void setExamPeriodEndDate(Date examPeriodEndDate) {
		this.examPeriodEndDate = examPeriodEndDate;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
	
}
