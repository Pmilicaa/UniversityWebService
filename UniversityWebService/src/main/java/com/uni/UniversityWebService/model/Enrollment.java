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
@Table(name = "Enrollment")
public class Enrollment {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrollmentId", unique = true, nullable = false)
	private Long id;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "enrollment")
	private Set<Exam> exams = new HashSet<Exam>();
	
	@ManyToOne
	@JoinColumn(name = "courseSpecificationId", referencedColumnName = "id", nullable = false)
	private CourseSpecification courseSpecification;
	
	@ManyToOne
	@JoinColumn(name = "studentId", referencedColumnName = "id", nullable = false)
	private Student student;

	
	public Enrollment(Long id, Set<Exam> exams, CourseSpecification courseSpecification, Student student) {
		this.id = id;
		this.exams = exams;
		this.courseSpecification = courseSpecification;
		this.student = student;
	}


	public Enrollment() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Set<Exam> getExams() {
		return exams;
	}


	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}


	public CourseSpecification getCourseSpecification() {
		return courseSpecification;
	}


	public void setCourseSpecification(CourseSpecification courseSpecification) {
		this.courseSpecification = courseSpecification;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

}
