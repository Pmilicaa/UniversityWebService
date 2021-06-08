package com.uni.UniversityWebService.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Enrollment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id",
		scope = long.class)
public class Enrollment {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrollmentId", unique = true, nullable = false)
	private Long id;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="exam_Id",  nullable = false)
	private Exam exam;

	@ManyToOne
	@JoinColumn(name = "courseSpecificationId", referencedColumnName = "id", nullable = false)
	private CourseSpecification courseSpecification;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId", referencedColumnName = "id", nullable = false)
	private Student student;

	
	public Enrollment(Long id, Exam exam, CourseSpecification courseSpecification, Student student) {
		this.id = id;
		this.exam = exam;
		this.courseSpecification = courseSpecification;
		this.student = student;
	}

	public Enrollment(Exam exam, CourseSpecification courseSpecification, Student student) {
		this.exam = exam;
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

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
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
