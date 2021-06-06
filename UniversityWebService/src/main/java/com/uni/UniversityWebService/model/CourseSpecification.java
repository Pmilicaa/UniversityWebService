package com.uni.UniversityWebService.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courseSpecification")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
                  property = "id",
                  scope = long.class)
public class CourseSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "ects")
    private int ECTS;

    @Column(name = "code")
    private String code;

    @OneToMany(
            mappedBy = "courseSpecification",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL

    )
    private List<CourseInstance> courseInstances;

    @OneToMany(
            mappedBy = "courseSpecification",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL

    )
    private List<Enrollment> enrollments;
    
    @OneToMany(
            mappedBy = "courseSpecification",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL

    )
    private List<Teaching> teachings;

    

    public CourseSpecification(Long id, String title, int eCTS, String code, List<CourseInstance> courseInstances,
			List<Enrollment> enrollments, List<Teaching> teachings) {
		this.id = id;
		this.title = title;
		this.ECTS = eCTS;
		this.code = code;
		this.courseInstances = courseInstances;
		this.enrollments = enrollments;
		this.teachings = teachings;
	}

	public CourseSpecification() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getECTS() {
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<CourseInstance> getCourseInstances() {
		return courseInstances;
	}

	public void setCourseInstances(List<CourseInstance> courseInstances) {
		this.courseInstances = courseInstances;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public List<Teaching> getTeachings() {
		return teachings;
	}

	public void setTeachings(List<Teaching> teachings) {
		this.teachings = teachings;
	}

}
