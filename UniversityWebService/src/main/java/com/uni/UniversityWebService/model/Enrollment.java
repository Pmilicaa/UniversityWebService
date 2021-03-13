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
	private Set<ExamPeriod> courseInstances = new HashSet<ExamPeriod>();
	
	@ManyToOne
	@JoinColumn(name = "courseInstanceId", referencedColumnName = "courseInstanceId", nullable = false)
	private CourseInstance courseInstance;

	
	public Enrollment(Long id, Set<ExamPeriod> courseInstances, CourseInstance courseInstance) {
		this.id = id;
		this.courseInstances = courseInstances;
		this.courseInstance = courseInstance;
	}

	public Enrollment() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ExamPeriod> getCourseInstances() {
		return courseInstances;
	}

	public void setCourseInstances(Set<ExamPeriod> courseInstances) {
		this.courseInstances = courseInstances;
	}

	public CourseInstance getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(CourseInstance courseInstance) {
		this.courseInstance = courseInstance;
	}

}
